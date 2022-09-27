/*Cerca una citt� in un archivio e ne stampa l'indirizzo*/
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define MAX 5

void stampa_in(int *x){
	do{
		printf("Digita 1 per inserire e 0 per uscire\n");
		scanf("%d",x);
		if(*x!=0&&*x!=1)
			printf("hai sbagliato ridigita\n");
	}while(*x!=0&&*x!=1);
}
void leggi_city(char x[]){
	printf("Inserisci la citta da controllare:\n");
		scanf("%s",x);
}
char * cerca_city(char *data[], char x[]){
	int flag=0,i,j;
	for(i=0;i<5&&flag==0;i++){
		if(!strcmp(data[i],x))
			return data[i];
			}
	return NULL;

}
int conta(char *x, int *vo, int *co){
	*vo=0,*co=0;
	char z[]={'A','E','I','O','U'};
	for(int i=0;i<strlen(x);i++)
		for(int j=0;j<5;j++)
			if(toupper(x[i])==z[j]){
				*vo=*vo+1;
			}
	*co=strlen(x)-*vo;
	return strlen(x);
	/*
	for(int i=0;i<strlen(x);i++)
		switch(toupper(x[i]){
		case 'A':case 'E':case 'I':case 'O':case 'U':
			*vo=*vo+1;
			break;
		default:
			*co=*co+1;
			break;
		}
		return strlen(x);
	*/
}
void stampa_out (char *x){
	if(x==NULL)
			printf("La citta non e in archivio\n");
	else
		printf("La citta e in archivio e la sua locazione e %p\n",x);
}

int main(){
	char *data_city[MAX]={"Milano","Napoli","Palermo","Roma","Torino"}, *ptr_city=NULL, city[20];
	int risposta, dimCity, vocCity, consCity;
	do{
		stampa_in(&risposta);
		if(risposta==1){
			leggi_city(city);
			ptr_city=cerca_city(data_city, city);
			if(ptr_city!=NULL){
				dimCity=conta(ptr_city, &vocCity, &consCity);
				printf("\n%d %d %d\n",dimCity, vocCity, consCity);
			}
			stampa_out(ptr_city);
		}
	}while(risposta);
}
