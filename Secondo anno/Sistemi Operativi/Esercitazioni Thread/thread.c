/*
 ============================================================================
 Name        : Conta.c
 Author      :
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

 #include <stdio.h>
 #include <stdlib.h>
 #include <ourhdr.h>
 #include <pthread.h>


 #define N_THREADS 6

 typedef struct counter{
 	long int da;
 	long int a;
 	char car;
 }counter;

 void *worker(void *stru){
 	counter *x=(counter *)stru;
 	long da=(*x).da;
 	long a=(*x).a;
 	char stampa=(*x).car;
 	long i;
 	char buf[30];
 	for(i=da;i<a;i++){
 		sprintf(buf,"i:->%l",i);
 		if(i%10000000==0){
 			buf[0]=stampa;
 			buf[1]='\0';
 			if(write(STDOUT_FILENO, buf, strlen(buf)) < 0)
 							err_sys("Write failed");
 		}
 	}
 	buf[0]='\n';
 	buf[1]='\0';
 	if(write(STDOUT_FILENO, buf, strlen(buf)) < 0)
 		err_sys("Write failed");
 	free(x);
 }



 int main(void) {
 	long a=1000000000,da=0,size;
 	size=a/N_THREADS;
     pthread_t tid;
     int thre;
     counter *temp=malloc(sizeof(counter));
 	(*temp).da=da;
 	(*temp).a=a;
 	(*temp).car='1';
 	startCounting();
 	thre=pthread_create(&tid, NULL, worker, (void *)temp);
  pthread_join( tid, NULL);
 	stopCounting();
 	printResourceUsage();

 	pthread_t thread_id[N_THREADS];
 	counter *cont[N_THREADS];
 	char print[]={'a','b','c','d','e','f'};
 	startCounting();
 	for(int i=0;i<N_THREADS;i++){
 		cont[i]=malloc(sizeof(counter));
 		cont[i]->da=size*i;
 		cont[i]->a=size*(i+1);
 		cont[i]->car=print[i];
 		pthread_create(&thread_id[i], NULL, worker, (void *)cont[i]);

 	}
 	for(int j=0;j<N_THREADS;j++){
 		pthread_join(thread_id[j], NULL);
 	}
 	stopCounting();
 	printResourceUsage();

 	return EXIT_SUCCESS;
 }
