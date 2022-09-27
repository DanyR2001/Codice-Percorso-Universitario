#include <stdio.h>
#include <stdlib.h>
#include <ourhdr.h>
#include <pthread.h>

char *path="/bin/ls";

void worker(char *directory,int fd){
	char *prova[]={path,"-l",directory,NULL};
	printf("%s prova \n",directory);
	if(dup2(fd, STDOUT_FILENO) < 0)
		err_sys("error dup2");
	if((execve(path, prova, NULL)) == -1)
		err_sys("Execve falied: ");

}

int main(int argc,char *argv[]) {
	int pid[argc-1];
	int fd;

	if((fd = open("file.tmp", O_WRONLY|O_CREAT|O_TRUNC|O_APPEND, 0664)) < 0){
		err_sys("open failed. Cannot open file %s for writing", stdout);
	}

	for(int i=1;i<argc;i++){
		pid[i]=fork();
		if(pid[i]<0)
			err_sys("errore fork");
		else if(pid[i]==0){
			worker(argv[i],fd);
			exit(1);
		}
	}
	return EXIT_SUCCESS;
}
