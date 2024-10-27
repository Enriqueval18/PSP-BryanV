#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>
#include <time.h> 
int main(void)
{
int fp,p,fs,q;  
time_t t;
int numero1;
srand((unsigned) time(&t));
numero1=rand() % 10; //genera un numero aleaotorio entre 1 al 10
p=mkfifo("FIFO1", S_IFIFO|0666);

fp = open("FIFO1", 1);
printf("Mandando informaci�n al pipe FIFO1...\n");
int i = numero1;
write(fp,&i, sizeof(i));
close(fp);   

fs = open("FIFO2", 0);  
int a;
q= read(fs, &a, sizeof(a)); 
printf("Leyendo informacion del pipe FIFO2...\n");
printf("%d\n", a);    //leemos el factorial calculado
close(fs); 

unlink("FIFO1");
unlink("FIFO2");

}