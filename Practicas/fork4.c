#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
pid_t p1,p2,p3,p4,p5,acumulado;
acumulado = getpid();
p1 = fork();
if(p1==0)
	{
	p5 = fork();
	if(p5==0)
	{
		printf("soy el p5 mi pid es: %d\n",getpid());
		if ( getpid() % 2 == 0 )
		{
			acumulado = acumulado+10;
			printf("%d\n",acumulado);
        	}
    		else{
    			acumulado = acumulado-100;
    			printf("%d\n",acumulado);
        	}
	}
	else{
		waitpid(p5,NULL,0);
		printf("soy el p2 mi pid es: %d\n",getpid());
		if ( getpid() % 2 == 0 )
		{
			acumulado = acumulado+10;
			printf("%d\n",acumulado);
        	}
    		else{
    			acumulado = acumulado-100;
    			printf("%d\n",acumulado);
        	}
	}

	}
else 
	{
	p3 = fork();
	if(p3 == 0){
		p4 = fork();
		if(p4==0){
		printf("soy el p4 mi pid es: %d\n",getpid());
		if ( getpid() % 2 == 0 )
		{
			acumulado = acumulado+10;
			printf("%d\n",acumulado);
        	}
    		else{
    			acumulado = acumulado-100;
    			printf("%d\n",acumulado);
        	}
		}
		else{
		waitpid(p4,NULL,0);
		printf("soy el p3 mi pid es: %d\n",getpid());
		if ( getpid() % 2 == 0 )
		{
			acumulado = acumulado+10;
			printf("%d\n",acumulado);
        	}
    		else{
    			acumulado = acumulado-100;
    			printf("%d\n",acumulado);
        	}
		}	
	
		}
	else
		{
		waitpid(p3,NULL,0);
		waitpid(p1,NULL,0);
		printf("soy el p1 mi pid es: %d\n",getpid());	
		
		}
	}
}
