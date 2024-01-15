/*
 ============================================================================
 Name        : esercizioTutorato.c
 Author      : daniele
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
Scrivere un programma C che, data in input una serie di path da riga
di comando, crei un processo figlio per ogni path passata, con il compito
di trovare il file dalla dimensione più grande al suo interno
ricorsivamente. Una volta trovato il file, il processo figlio lo passerà al
padre e ques'ultimo stamperà il più grande tra i file trovati dai figli.
 */

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <ourhdr.h>
#include <dirent.h>

struct info{
	char maxPath[PATH_MAX];
	long maxDim;
};

int filter(const struct dirent *entry){
	if((entry->d_type==DT_DIR&&strcmp(".",entry->d_name)&& strcmp("..",entry->d_name))||entry->d_type==DT_REG)
			return 1;
	return 0;
}


struct info MaxFile(char *path){
	char buffer[PATH_MAX];
	struct dirent ** entries;
	struct info greatest, tmp;
	struct stat s;
	int n;

	strcpy(greatest.maxPath, "");
	greatest.maxDim = -1;

	if((n = scandir(path, &entries, filter, NULL)) < 0)
		err_sys("scandir failed");

	for(int i=0;i<n;i++){
		sprintf(buffer, "%s/%s", path, entries[i] -> d_name);

		if(entries[i]->d_type==DT_REG){
			if(stat(buffer, &s)<0)
				err_sys("stat failed");

			if(s.st_size > greatest.maxDim){
				greatest.maxDim = s.st_size;
				strcpy(greatest.maxPath, buffer);
			}
		}
		else{
			tmp=MaxFile(buffer);
			if(tmp.maxDim > greatest.maxDim){
				greatest.maxDim = tmp.maxDim;
				strcpy(greatest.maxPath, tmp.maxPath);
			}
		}
	}

	free(entries);
	return greatest;
}

void worker(char *path,int pipes){
	struct info x=MaxFile(path);
	//printf("figlio provo a scrivere %s %ld/n",x.maxPath,x.maxDim);
	if(write(pipes,&x,sizeof(struct info))<0)
		err_sys("err scrittura pipe");
	//printf("finito \n");
	close(pipes);
	exit(0);
}


int main(int argc,char *argv[]) {
	if(argc<2)
		err_sys("problema numero input");
	struct info confronto[argc];
	int pids[argc];
	int pipes[argc][2];
	for(int i=0;i<argc;i++)
		if(pipe(pipes[i])<0)
					err_sys("pipe failed\n");
	int pos;
	for(int i=1;i<=argc;i++){
		pos=i-1;
		if((pids[pos]=fork())<0)
			err_sys("fork error");
		else if(pids[pos]==0){
			worker(argv[i],pipes[pos][WRITE_END]);
		}
	}
	int rb=0;
	struct info temp,max;
	max.maxDim=-1;
	for(int i=0;i<argc-1;i++){
		if((rb=read(pipes[i][READ_END],&temp,sizeof(struct info)))>=0){
			//printf("letto %s dim %d \n",temp.maxPath,temp.maxDim);
			if(max.maxDim<temp.maxDim){
				max.maxDim=temp.maxDim;
				strcpy(max.maxPath,temp.maxPath);
			}
			close(pipes[i][READ_END]);
		} else if(rb<0){
				err_sys("Read failed");
			}
		}
	for(int f=0;f<argc;f++)
				if(waitpid(pids[f],NULL,0)<0)
					err_sys("You have to wait that all child terminates their task\n");
	printf("Il file piu grande fra le varie directory e %s con dim %d",max.maxPath,max.maxDim);
	return EXIT_SUCCESS;
}
