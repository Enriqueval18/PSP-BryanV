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
int fs[2];
pid_t pid;
pipe(fd);
pipe(fs);
pid = fork(); 
time_t t;
int numero1;
int fact = 1;
srand((unsigned) time(&t));
numero1=rand() % 10;
if (pid==0)
{
   close(fd[1]);
   int i;
   read(fd[0], &i,sizeof(i));
   printf("%d\n",i);
   for (i; i > 1; i--){
    fact = fact * i;
    }
    close(fs[0]); //escribe el segundo pipe
    write(fs[1], &fact,sizeof(fact));

}
else
{
   close(fd[0]); 
   int i = numero1;
   write(fd[1], &i,sizeof(i));
   printf("El proceso padre genera el numero %d, en el pipe1\n",i);
   close(fs[1]);
   int fact;
   read(fs[0], &fact,sizeof(fact));
   printf("El factorial calculado por el proceso hijo: %d != %d\n",i,fact);
   wait(NULL);
}

}