#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>
#include <time.h> 
int main(void)
{
int fp,p,q;  
time_t t;
int numero1;
srand((unsigned) time(&t));
numero1=rand() % 10; //genera un numero aleaotorio entre 1 al 10

fp = open("FIFO1", 1);
printf("Mandando informaci�n al pipe FIFO1...\n");
int i = numero1;
write(fp,&i, sizeof(i));
p=mkfifo("FIFO2", S_IFIFO|0666);


fp = open("FIFO2", 0);  
int a;
q= read(fp, &a, sizeof(a)); 
int x = a;
printf("Leyendo informacion del pipe FIFO2...\n");
printf("%d\n", x);    //leemos el factorial calculado

close(fp);   

unlink("FIFO1");
unlink("FIFO2");

}