#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
//void main()
//{
// pid_t pid1, pid2;
// printf("AAA \n");
// pid1 = fork();
// if (pid1==0)
// {
// printf("BBB \n");
// }
// else
// {
// pid2 = fork();
// printf("CCC \n");
// }
// exit(0);
//}
//Genera la salida de procesos huerfanos que se encarga el sistema, se producen distintas salidas de orden diferente
void main(){
 pid_t pid1, pid2;
 printf("AAA \n");
 
 pid1 = fork();
 if (pid1==0) //hijo
 	{
 		printf("BBB \n");
 	}
 else //padre
 	{	
 		wait(NULL)
 		pid2 = fork();
 		printf("CCC \n");
 	}
 	exit(0);
}

