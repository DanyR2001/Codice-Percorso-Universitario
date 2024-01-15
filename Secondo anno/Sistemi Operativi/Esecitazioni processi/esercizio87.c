#include <stdio.h>
#include <stdlib.h>
#include <ourhdr.h>
#include <pthread.h>

#define NUM_PROC 3

void worker(int timesleep,int pid,int mypid){
	sleep((unsigned int)timesleep);
	printf("my pid %d, my dad pid %d \n",mypid,pid);
	exit(0);
}

int main(void) {
	int pid[NUM_PROC];
	int pidt=getpid();

	for(int i=0;i<NUM_PROC;i++){
		pid[i]=fork();
		if(pid[i]<0)
				err_sys("errore fork");
		else if(pid[i]==0){
			worker(i,pidt,getpid());
			exit(0);
		}
	}
	for(int i=0;i<NUM_PROC;i++)
		if(waitpid(pid[i],NULL,0)<0)
			err_sys("errore attesa processo");
	printf("i figli hanno finito\n");
}
