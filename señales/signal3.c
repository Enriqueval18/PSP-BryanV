#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>
FILE *file; //hace referencia al archivo
void parar (int numero ){ //numero no lo utiliza
    time_t now;
    time(&now);
    fprintf(file, "Intento de detener el programa con CTRL+C en %s", ctime(&now));
    fflush(file);  //asegura que los datos se guarden correctamente
}
int main() {
    file = fopen("salidas.txt", "a");
    signal(SIGINT, parar); //el controlador de c
    while (1) {
        pause();  //bucle infinito para que intente a parar
    }
    fclose(file);
}