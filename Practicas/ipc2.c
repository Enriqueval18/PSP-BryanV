#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>
#include <string.h>
void main()
{
    int fd[2];
    pid_t pid;
    pipe(fd);
    pid = fork();

    if (pid == 0)
    {
    close(fd[1]);
    int a[70];
    for(int i = 0; i<=3 ; i++){
        	a[i] = i;
        }
	printf("numero primero: %d \n",a[0]);
	printf("numero segundo: %d \n",a[1]);
	printf("numero tercero: %d \n",a[2]);
    int suma  = a[0]+a[1]+a[2];
    printf("suma total de numeros: %d \n",suma);

    }
    else
    {
        close(fd[0]); 
        for(int i = 0; i<=3 ; i++)
        {
        write( fd[1], &i, sizeof(i));
        }
        wait(NULL);
    }
}
