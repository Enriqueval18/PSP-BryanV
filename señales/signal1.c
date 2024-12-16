#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <time.h>
#include <unistd.h>

void manejador_SIGINT(int signo) {
    time_t now;
    time(&now);
    printf("Fin del proceso %d: %s",getpid(),ctime(&now));
    exit(0);
}

int main() {
    time_t inicio;
    time(&inicio);
    printf("Inicio del proceso %d: %s \n" ,getpid(),ctime(&inicio));
    signal(SIGINT, manejador_SIGINT);
    while (1) {
        pause(); 
    }
    return 0;
}
