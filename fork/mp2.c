#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
void main() {
	pid_t varabuelo,varpadre,varnieto;
	varabuelo = fork(); //Creo el padre y el hijo

	if(varabuelo == 0) { //Este es padre
	
		varpadre = fork(); //Creo el padre y el hijo
		
		if(varpadre == 0){//Nieto
		printf("Soy el proceso hijo: %d y mi padre tiene el id %d\n", getpid(),getppid());
		}
		
		else{//padre
		varpadre = wait(NULL);
		printf("Soy el proceso padre: %d y mi padre tiene el id %d\n", getpid(),getppid());
		}
		
	}
	else{ //este es el abuelo
		varpadre = wait(NULL);
		printf("Soy el abuelo tengo el id: %d y mi hijo tiene el id %d\n",getpid(),varpadre);
	}	
	
   exit(0);
}
