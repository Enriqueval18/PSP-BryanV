#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>
#include <time.h> 
int main(void)
{
    int fact = 1;
    int fp,p;
    int i;
    fp = open("FIFO2", 0);  
    p= read(fp, &i, sizeof(i)); 
    printf("Leyendo informacion del pipe FIFO2...\n");
    printf("%d\n", i); 
    close(fp); 
    for (i; i > 1; i--){
    fact = fact * i;  //calculamos el factorial
    }

    fp = open("FIFO2", 1);
    printf("Mandando informacion al pipe FIFO2...\n");
    int a = fact;
    write(fp,&a, sizeof(a));
    close(fp);  

    unlink("FIFO2");
}