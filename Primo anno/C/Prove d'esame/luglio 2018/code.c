#include <stdio.h>
#include <string.h>
#define NUM_EL 4

void cerca(char *[ ], char *[ ], char *[ ], int *);
int prefisso(char *,char *, int);
void aggiorna(char *,char *, char *[],int *, int *);
void stampa(char *[ ], int) ;

//Questo programma rientra nella top 3 tracce indecifrabili del prof

int main(void)
{
  char *parole[NUM_EL]={"agosto","soleggiato","agorà","marmotta"}, *prefix[NUM_EL]={"sole","marmo","ottica","ago"},
  *archivio[2*NUM_EL]={NULL};
  int num_pref=0;
  cerca(parole, prefix, archivio, &num_pref);
  stampa(archivio, num_pref);
}

int prefisso(char* vect, char* vect1, int size){

  if(size<=0 || size > strlen(vect1)) return 0;

  for(int i=0; i<size; i++)
    if(vect[i] != vect1[i])
        return 0;
  return 1;
}

void cerca(char* word[], char* pref[], char* addr[], int* num){
  int i,j,dim,dim1,risp, ind=0; //Alcune di queste variabili sono inutili ma le ho lasciate intatte ai fini della traccia

  for(i=0; i<NUM_EL; i++)
    for(j=0; j<NUM_EL;j++)
    {
      dim=strlen(pref[i]);
      risp=prefisso(pref[i], word[j], dim);
      if(risp==1)
        aggiorna(pref[i],word[j], addr, &ind, num);
    }
}

void aggiorna(char* vect, char* vect1, char* addr[], int* ind, int* n){
  (*n)++;
  addr[(*ind)++]=vect; 
  addr[(*ind)++]=vect1;
}

void stampa(char* arch[], int num){
  for(int i=0; i<num*2; i++){
    printf("%s ",arch[i]);
  }
  printf(". Il numero di prefissi e' %d.",num);
}
