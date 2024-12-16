#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>
int alarma1;
int segundos;

void alarma (int numero ){ 
time_t now;
time(&now);
printf("Señal de alarma recibida %s", ctime(&now));
 if (alarma1 > 0) { //inicia
        alarma1--;  //disminuye las a las alarmas de uno en uno
        if (alarma1 > 0) { //misma condicion
            alarm(segundos);  //suena la alarma
        }
    }
}

int main() {
    printf("¿Cuantas veces sonara la alarma?\n");
    scanf("%d", &alarma1);
    printf("¿Cada cuantos segundos se repetira la alarma?\n");
    scanf("%d", &segundos);
    
    signal(SIGALRM, alarma);
    printf("Alarma activada\n");
    alarm(segundos);
    while (alarma1 > 0) { //para que se siga ejecutando
        pause();
    }
    printf("Alarma desactivada\n");
}
