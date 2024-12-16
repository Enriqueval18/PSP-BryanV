#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <time.h>
#include <sys/wait.h>
pid_t p2, p3; // para los hijos
int pipe1[2]; // pipe1
int pipe2[2]; // pipe2
int pipe3[2]; // pipe3
void main()
{
	pipe(pipe1); // inicio los pipes
	pipe(pipe2);
	pipe(pipe3);
	p2 = fork(); // primer hijo

	if (p2 == 0)
	{
		p3 = fork(); // segundo hijo
		if (p3 == 0)
		{
			int cont = 0;
			int sum = 0;
			int nomult = 0;
			int recib = 1;

			close(pipe2[1]);
			read(pipe2[0], &cont, sizeof(recib)); // recibo cuantos numeros leera

			for (int i = 0; i < cont; i++)
			{ // mientras que no reciba todos los numeros hace bucle
				read(pipe2[0], &recib, sizeof(recib));

				if (recib % 2 == 0)
				{
					sum = sum + recib; // sumo los multiplos
				}
			}

			close(pipe3[0]); // envio los resultados
			write(pipe3[1], &sum, sizeof(recib));
		}
		else
		{

			int num;
			int cantidad;

			close(pipe1[1]);
			read(pipe1[0], &cantidad, sizeof(cantidad)); // leo la cantidad  3

			close(pipe2[0]);
			write(pipe2[1], &cantidad, sizeof(cantidad)); // envio la cantidad de numeros a leer

			for (int i = 0; i < cantidad; i++)
			{ // voy enviando los numeros
				printf("Introduce número:");
				scanf("%d", &num);
				write(pipe2[1], &num, sizeof(num));
			}



			close(pipe3[1]);
			int recib;
			read(pipe3[0], &recib, sizeof(recib)); // recibo los multiplos de 2
			printf("la suma de los multiplos de 2 es igual a = %d\n", recib);
			wait(NULL);
		}
	}
	else
	{
		printf("Introduce la cantidad de números a procesar:"); // la cantidad de numeros
		int numeros;
		scanf("%d", &numeros);
		close(pipe1[0]);
		write(pipe1[1], &numeros, sizeof(numeros)); // envio la cantidad
		waitpid(p2, NULL, 0);
	}
	exit(0);
}
