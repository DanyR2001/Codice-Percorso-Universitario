/*
 *  Created on: 11 nov 2021
 * Scrivere un programma C che crea 4 figli (denominati P0,P1,P2,P3).
 * Successivamente il processo padre genererà una serie di stringhe e una a la volta
 * le invierà al primo figlio P0. (Sono n giri di pipe)
 * Ogni figlio a sua volta invierà il messaggio ricevuto al figlio
 * successivo Pi -> Pi+1. L'ultimo figlio invierà il messaggio al padre.
 * Il padre termina stampando il messaggio ricevuto.
 * il padre dopo aver ricevuto il primo messaggio invierà il secondo

 * Successivamente il processo padre genererà 10.000 interi casuali e li
 * invierà uno alla volta a ciascuno dei figli tramite una pipe dedicata
 * (separati da una pausa di 10 msec.).
 * Ogni figlio ricevuto l’intero x verificherà se questo è divisibile per
 * un intero (37 il processo P1, 61 P2, 89 P3 e 107 P4) e se il numero
 * ricevuto e' divisibile scriverà nel file “multipli.txt” il messaggio:
 * “x è divisibile per y” (x è l’intero ricevuto y è il divisore).
 * Una volta chiusa la pipe il processo figlio terminerà
 */

#include <ourhdr.h>
#include <sys/wait.h>

#define NPROC 4
#define WRITE_END 1
#define READ_END 0

void Worker(int n, int rfd, int wfd){
	char msg[100], buf[200];
	int rd;
	FILE *fds;
	size_t ls = 99;
	if((fds = fdopen(rfd, "r")) == NULL)
			err_sys("fdopen failed");

	//ClosePipes(n)
	char c;
	if((c = fgets(msg, ls, fds)) == 's'){
		printf("ho letto %d caratteri e questo e il risultato ->%s",rd,msg);
		//Processa il buffer
		msg[rd-1] = '\0'; //elimino il carattere alla fine '\n'
		sprintf(buf, "Ricevuro <%s>", msg);
		if(write(STDOUT_FILENO, buf, strlen(buf)) < 0)
			err_sys("Write to stdout failed");

		//Riinvio il msg sulla pipe n+1 esima
		if(write(wfd, msg, rd) < 0)
			err_sys("Write pipe failed");

		if(rd < 0){
			err_sys("err");
		}
		//chiusura pipe in lettura
		close(rfd);
		close(wfd);
	}
	printf("%c uscito dal while\n",c);

}

int main(void){
	int i;
	int pipes[NPROC + 1][2];
	int pid[NPROC];
	/*for(i = 0; i < NPROC; i++){
		if(pipe(pipes[i]) < 0 || pipe(pipes[i + 1]) < 0)
			err_sys("Pipe failes: %d", i);*/
	//Creo la prima pipe
	if(pipe2(pipes[0],O_NONBLOCK) < 0)
		err_sys("ERRORE CREAZIONE PRIMA PIPE");

	for(i = 0; i < NPROC; i++){

		//Creo le pippe
		if(pipe2(pipes[i+1],O_NONBLOCK) < 0){
			err_sys("err pipe %d", i);
		}
		//child
		else if((pid[i]=fork()) == 0){
			Worker(i, pipes[i][READ_END], pipes[i + 1][WRITE_END]);
			exit(0);//Assicura che il figlio termini
		}
		//Parent nulla da fare
		else ;
	}
	//Solo il padre arriva a eseguire fin qui e chiude le pipe che non servono
	/*for(i = 0; i < NPROC; i++){
		close(pipes[i][READ_END]);
		close(pipes[i+1][WRITE_END]);
	}*/

	FILE *fds;
	if((fds = fdopen(pipes[NPROC][READ_END], "r")) == NULL)
		err_sys("fdopen failed");

	//Invia il messsaggio
	char RetBuf[100];
	char *msg = "Viva l'economia circolare\n";
	int rd;
	size_t ls = 99;
	//Invio 10 messaggi
	//for(i = 0; i < 10; i++){
	int wb=0;
	wb=write(pipes[0][WRITE_END], msg, sizeof(msg));
		if(wb < 0){
			err_sys("Write failed to pipe 0");
		}
		if((rd = getline(&RetBuf, &ls, fds))<0 )
			err_sys("getline failed (%d)", rd);
		printf("Messaggio ricevuto: %s", RetBuf);
//	}

	//Chiusura pipe in scrittura per l'invio del primo EOF
	close(pipes[0][WRITE_END]);
	printf("Pipe 0 chiusa");

	//waiting dei childs
	//for(i = 0; i < NPROC; i++)
		//waitpid(pid[i], NULL, 0);


	return EXIT_SUCCESS;

}
