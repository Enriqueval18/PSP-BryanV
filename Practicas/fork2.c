#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
	pid_t p1, p2, p3, p4,suma;
	p1 = fork();
	if(p1==0)
	{
		p2 = fork();
		if(p2==0)
		{
			p3 = fork();
			if(p3==0) //p4
			{
			printf("soy p4 mi pid es: %d y el de mi padre es %d, el total es: %d\n",getpid(),getppid(),getpid()+getppid());
			}
			else //p3 
			{	
			wait(NULL);
			printf("soy p3 mi pid es: %d y el de mi padre es %d, el total es: %d\n",getpid(),getppid(),getpid()+getppid());

			}
			
		}
		else //p2
		{
			wait(NULL);
			printf("soy p2 mi pid es: %d y el de mi padre es %d, el total es: %d\n",getpid(),getppid(),getpid()+getppid());
		}
		
		
	}
	else //p1
	{
		wait(NULL);
		printf("soy p1 mi pid es: %d y el de mi padre es %d, el total es: %d\n",getpid(),getppid(),getpid()+getppid());
		
	}

}
