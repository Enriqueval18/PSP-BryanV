#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>
#include <string.h>
#include <fcntl.h>
void suma (int signo) {
   int suma;
            read(fd[0], &guardar3, sizeof(guardar3));
            if(guardar3 % 2 ==1){
                printf("Numero impar %d recibido por el proceso p2 con pid %d\n",guardar3,getpid());
            }
}
void main()
{
    int fd[2]; // pipe1
    int fs[2]; // pipe3
    pid_t p1, p2, p3;
    pipe(fd);
    pipe(fs);
    p1 = fork();
    if (p1 == 0)
    {
        p2 = fork();
        if (p2 == 0)
        {
            p3 = fork();
            if (p3 == 0) // p3
            {
                int nrecibido;
                {
                    int suma;
                    close(fs[1]);
                    read(fs[0], &nrecibido, sizeof(nrecibido));
                    printf("%d", nrecibido);
                }
            }
            else // p2}]
            {
                int numerorecibido;
                close(fd[1]);
                read(fd[0], &numerorecibido, sizeof(numerorecibido)); // si funciona
                int numeros;
                close(fs[0]);
                for (int i = 0; i < numerorecibido; i++)
                {
                    printf("Introduce numero:");
                    scanf("%d", &numeros);
                    write(fs[1], &numeros, sizeof(numeros));
                }
                wait(NULL);
            }
        }
        else // p1
        {
            printf("Introduce la cantidad de numeros a procesar:");
            int numeros;
            scanf("%d", &numeros);
            close(fd[0]);
            int enviarnumero = numeros;
            write(fd[1], &enviarnumero, sizeof(enviarnumero)); // envio el numero al proceso 2 utilizando el pipe1
            wait(NULL);
        }
    }
}