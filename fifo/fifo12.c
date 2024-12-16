#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
int main()
{
    int fact = 1;
    int fp,p,q;
    int i;
    p=mkfifo("FIFO1", S_IFIFO|0666);
    fp = open("FIFO1", 0);  
    q= read(fp, &i, sizeof(i)); 
    int c = i;
    printf("Leyendo informacion del pipe FIFO1...\n");
    printf("%d\n", c);    //leo un caracter 
    



    for (c; c > 1; c--){
    fact = fact * c;  //calculamos el factorial
    }

    //creamos el fifo02 y le enviamos el factorial (le escribimos)
    fp = open("FIFO2", 1);
    printf("Mandando informacion al pipe FIFO2...\n");
    int a = fact;
    write(fp,&a, sizeof(a));
    
    close(fp); 
    

    unlink("FIFO1");
    unlink("FIFO2");

    
}