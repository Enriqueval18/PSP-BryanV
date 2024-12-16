#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
	pid_t varabuelo, varpadre, varpadre2, varhijo;
	varabuelo = fork();
	if(varabuelo==0)//padre 1 
	{	
		if(getpid()%2 == 0)
		{
			printf("soy el primer padre mi pid es: %d , y el pid de mi padre es: %d\n",getpid(),getppid());
		}
		else
		{
			printf("soy el primer padre mi pid es: %d\n",getpid());
		}
		
	}
	else{ //parte de abuelo
		varpadre = fork();
		if(varpadre == 0) //parte del segundo padre
		{
			varpadre2 = fork();
			if(varpadre2 == 0)
			{
				if(getpid()%2 == 0)
				{
					printf("soy el hijo de mi segundo padre mi pid es: %d, y el de mi padre es: %d\n",getpid(),getppid());
				}
				else
				{
					printf("soy el hijo de mi segundo padre mi pid es: %d\n",getpid());
				}	
				
			}
			else {
				wait(NULL);
				if(getpid()%2 == 0)
				{
					printf("soy el segundo padre mi pid es: %d, y el de mi padre es: %d\n",getpid(),getppid());
				}
				else
				{
					printf("soy el segundo padre mi pid es: %d\n",getpid());
				}
				
			}
		}
		else //verdadero abuelo
		{
			wait(NULL);
			wait(NULL);
			if(getpid()%2 == 0)
			{
				printf("soy el abuelo mi pid es: %d, y el de mi padre es: %d  \n",getpid(),getppid());
			}
			else
			{
				printf("soy el abuelo mi pid es: %d\n",getpid());
			}
			
		}
	}
}
//el orden de procesos es el primer hijo, el nieto, el segundo hijo y el abuelo
