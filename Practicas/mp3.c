#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
  pid_t varpadre,varhijo,varhijo2; 
  
  varpadre = fork(); //Esto hace que se divida padre e hijo
  if(varpadre == 0) { //proceso hijo1
  		sleep(10);
        	printf("estoy despierto\n");
 	
    }
  else{ //padre
   varhijo = fork(); //creando otro hijo
   if (varhijo == 0) {//hijo2
            	printf("este es mi id %d, el id de mi padre es %d\n",getpid(),getppid());
		
        } else { //padre
        	wait(NULL); //Espera a cualquier hijo
        	wait(NULL); //Espera a cualquier hijo
        	printf("soy el padre y he esperado a  mis hijos\n");
        }
    }
   exit(0);
}
