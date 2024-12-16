#include <stdio.h> 
#include <signal.h> 
#include <stdlib.h>
#include <unistd.h>
  
int main() 
{ 
    signal(SIGINT, SIG_IGN);  //CONTROL C
    signal(SIGKILL, SIG_IGN); //IGNORA DADO EL KILL NO PUEDE SER IGNORADO

    while (1) 
    { 
        printf("hello world\n"); 
        sleep(1); 
    } 
    return 0; 
} 
