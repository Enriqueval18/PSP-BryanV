#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
pid_t p1,p2,p3,p4,p5,p6,p1abuelo,p2abuelo;
p1abuelo = getpid();
p1 = fork();

	if(p1==0)
	{	p2abuelo = getpid();
		p2 = fork();
		if(p2 == 0)
			{
			p5 = fork();
				if(p5 == 0)
					{	
						printf("soy el p5 mi pid es: %d y mi abuelo es: %d\n",getpid(),p2abuelo);
					}
				else
					{	
						waitpid(p5,NULL,0);
						printf("soy el p3 mi pid es: %d y mi abuelo es: %d\n",getpid(),p1abuelo);
					}
			}
		else
			{
			p4 = fork();
				if(p4 ==0)
					{
					p6 = fork();
					if(p6 == 0)
						{
							printf("soy el p6 mi pid es: %d y mi abuelo es: %d\n",getpid(),p2abuelo);
						}
					else
						{	
							waitpid(p6,NULL,0);
							printf("soy el p4 mi pid es: %d y mi abuelo es: %d\n",getpid(),p1abuelo);
						}
			
					}
				else 
					{
						waitpid(p2,NULL,0);
						waitpid(p4,NULL,0);
						printf("soy el p2 mi pid es: %d\n",getpid());
					}
			}
	}
	else //p1
		{
			waitpid(p1,NULL,0);
			printf("soy el p1 mi pid es: %d\n",getpid());
		}
}
