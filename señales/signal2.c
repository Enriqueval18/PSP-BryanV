#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

int tiempo = 5; 

void manejador_SIGINT(int signo) {
    exit(0);
}
int main() {
    signal(SIGINT, manejador_SIGINT);
    while (1) {
        printf("Han transcurrido: %d segundos\n", tiempo);
        tiempo += 5;
        sleep(5); 
    }
    return 0;
}
