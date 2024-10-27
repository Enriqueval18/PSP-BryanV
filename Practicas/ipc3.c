#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>
#include <time.h> 
#include <sys/wait.h> 
void main(){

    int fd[2]; 
    pid_t pid;
    pipe(fd); 
    pid = fork();
    time_t t;
    int numero1,numero2;
    srand((unsigned) time(&t));
    numero1=rand() % 50; 
    numero2=rand() % 50;
   
    if (pid==0)
    {
   close(fd[0]); 
   int i = numero1;
   int e = numero2;
	write(fd[1], &i,sizeof(i));
   write(fd[1], &e,sizeof(e));

    }
    else
    {
   close(fd[1]); 
   int i;
   int e;
   read(fd[0], &i,sizeof(i));
   read(fd[0], &e,sizeof(e));
   int suma = i+e;
   int resta = i-e;
   int multi = i*e;
   int divi = i/e;

   printf("%d + %d = %d\n",i,e,suma);
   printf("%d - %d = %d\n",i,e,resta);
   printf("%d * %d = %d\n",i,e,multi);
   printf("%d / %d = %d\n",i,e,divi);


   wait(NULL);

    }
}

