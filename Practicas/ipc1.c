#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>
#include <string.h>
void main(){

    int fd[2]; 
    char buffer[70];
    pid_t pid;
    // Creamos el pipe
    pipe(fd); 
    
    //Se crea un proceso hijo
    pid = fork();

    if (pid==0)
    {
        close(fd[1]); // Cierra el descriptor de escritura
        printf("Soy el proceso hijo con pid %d\n", getpid());
        read(fd[0], buffer, 70);
        printf("\t Fecha/Hora: %s \n", buffer);
    }
    else
    {
    close(fd[0]); // Cierra el descriptor de lectura
	time_t t;
	time(&t);
	write(fd[1], ctime(&t),70);
    wait(NULL);
       
    }
}
