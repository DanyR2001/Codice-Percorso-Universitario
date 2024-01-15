#include <stdio.h>
#include <stdlib.h>
#include <ourhdr.h>
#include <ctype.h>
#include <unistd.h>
#include<string.h>

#define read_pipe 0
#define write_pipe 1

#define NUM_PROC 4
#define NUM_PIPE NUM_PROC
#define CONT 10000

void worker(int pid,int piperd,int div,int fd){
	int rb,wb;
	int num;
	//printf("cioa %d\n",pid);
	while((rb=read(piperd,&num,sizeof(num)))>0){
		//printf("figlio ha letto %d",num);
		if(rb<0)
			err_sys("Errore read");
		if(num%div==0){
			char temp[20];
			sprintf(temp,"\n %d e divisibile per %d \n ",div,num);
			//printf("dio %s \n",temp);
			if((wb=write(fd,temp,strlen(temp)))<0)
				err_sys("errore write");
		}
	}
	exit(0);
}

int main(void) {
	int pids[NUM_PROC];
	int pipes[NUM_PIPE][2];
	int dividendi[]={37,61,89,107};
	int wb;

	int fd;
	if((fd=open("multiply.txt",O_CREAT|O_TRUNC|O_WRONLY,0664))<0)
		err_sys("errore di apertura");

	for(int i=0;i<NUM_PIPE;i++)
		if(pipe2(pipes[i],0)<0)
			err_sys("errore creazione pipe");
	for(int j=0;j<NUM_PROC;j++){
		pids[j]=fork();
		if(pids[j]<0)
			err_sys("Errore creazione processo");
		else if(pids[j]==0){
			worker(getpid(),pipes[j][read_pipe],dividendi[j],fd);
			exit(0);
		}
	}
	srand(time(NULL));
	for(int k=0;k<CONT;k++){
		//printf("%d \n",k);
		int random=rand();
		//printf("%d random \n",random);
		for(int t=0;t<NUM_PIPE;t++){
			if((wb=write(pipes[t][write_pipe],&random,sizeof(random)))<0)
				err_sys("errore scrittura \n");
		}
	}
	printf("FINE \n");
	return EXIT_SUCCESS;
}
