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
int guardar;
int dni;
char letra[] = "TRWAGMYFPDXBNJZSQVHLCKE";
char letraespe;
if (pid==0)
{
   close(fd[0]);
    printf("Introduce el numero del dni:\n");
   scanf("%d",&guardar);
   write(fd[1], &guardar, sizeof(guardar));  
   
   close(fs[1]);
   read(fs[0], &letraespe, sizeof(letraespe));
   printf("La letra del NIF es: %c\n",letraespe);

}
else
{
    close(fd[1]);
    read(fd[0], &guardar, sizeof(guardar));
    dni = guardar;
    dni %= 23;
    close(fs[0]);
    letraespe = letra[dni];
    write(fs[1], &letraespe, sizeof(letraespe));  
   wait(NULL);
}
}