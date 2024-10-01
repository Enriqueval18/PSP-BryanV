#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
void main() {
	pid_t varpadre,varhijo;
	varpadre = fork(); //Creo el padre y el hijo

	if(varpadre == 0) { //Este es el hijo
		printf("Bryan Valencia Soy el proceso hijo: %d\n", getpid());
		exit(0);
		
	}
	else{ //este es el padre
		varhijo = wait(NULL);
	}	printf("Soy el padre tengo el id: %d mi hijo tiene el pid: %d\n",getpid(),varhijo);
   exit(0);
}
