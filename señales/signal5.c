#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>
#include <string.h>
#include <fcntl.h>
#include <signal.h>
int fd[2]; // pipe1
pid_t p1, p2;


void salir(){
    exit(0);
}

void impar (int signo) {
   int guardar3;
            read(fd[0], &guardar3, sizeof(guardar3));
            if(guardar3 % 2 ==1){
                printf("Numero impar %d recibido por el proceso p2 con pid %d\n",guardar3,getpid());
            }
}
void par (int signo) {
     int guardar2;
        read(fd[0], &guardar2, sizeof(guardar2));
         if(guardar2 % 2 ==0){
            printf("Numero par %d recibido por el proceso p2 con pid %d\n",guardar2,getpid());
        }
}


int main()
{
    int digito;
    pipe(fd);  // pipe1
    p1 = fork();
    if (p1 == 0) // p2
    {
        signal(SIGUSR2,salir);
        signal(SIGUSR1,par);
            while (1)
            {
                sleep(1);
            }
            
    }
    else
    {
        p2 = fork();
        if (p2 == 0) // p3
        {
            signal(SIGUSR2,salir);
            signal(SIGUSR1,impar);
            while (1)
            {
                sleep(1);
            }
            
        }
        else // p1
        {  
            while (1)
            {
                printf("Introduce un numero:");
                scanf("%d", &digito);
                write(fd[1], &digito, sizeof(digito));
                if(digito == 0) {
                    kill(p1,SIGUSR2);
                    kill(p2,SIGUSR2);
                    break;

                }
                if(digito % 2 == 1) {  
                    kill(p2, SIGUSR1);
                } 
                else if(digito % 2 == 0){ 
                    kill(p1,SIGUSR1);
                }
                sleep(0.5);
            }
            close(fd[0]);
            close(fd[1]);
            exit(0);
        }
    }
}
