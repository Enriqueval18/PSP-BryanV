#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
int main()
{
    int fact = 1;
    int fp,p,fs,q;
    int i;
    fp = open("FIFO1", 0);  
    p= read(fp, &i, sizeof(i)); 
    printf("Leyendo informacion del pipe FIFO1...\n");
    printf("%d\n", i);    //leo un caracter 
    close(fp); 

    for (i; i > 1; i--){
    fact = fact * i;  //calculamos el factorial
    }
    //creamos el fifo02 y le enviamos el factorial (le escribimos)
    q=mkfifo("FIFO2", S_IFIFO|0666);
    fs = open("FIFO2", 1);
    printf("Mandando informacion al pipe FIFO2...\n");
    int a = fact;
    write(fs,&a, sizeof(a));
    close(fs);   

    unlink("FIFO1");
    unlink("FIFO2");

    
}