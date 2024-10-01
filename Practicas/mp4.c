#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> //Codigo modificado

//void main()
//{
// printf("CCC \n");
// if (fork()!=0)
// {
// printf("AAA \n");
// } else printf("BBB \n");
// exit(0);
//}

//esta salida produce un proceso huerfano que es el bbb , o no se puede producirse

void main()
{
pid_t var; 
 printf("CCC \n");
 	var = fork();
 	if (var==0){
 		printf("BBB \n");
 	} 
 	else {
 		wait(NULL);
 		printf("AAA \n");
	 }
	 exit(0);
}

