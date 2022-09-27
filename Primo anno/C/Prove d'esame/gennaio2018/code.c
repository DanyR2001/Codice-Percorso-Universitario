#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct data{
    char nome[20];
    char cognome[20];
    char cf[17];
}data;

void leggi_file(FILE*, data**, int*);
void aggiorna(data*, char*, char*, char*, int);
void scrivi_file(FILE*, data*, int);

void leggi_file(FILE *input, data ** array, int* dim){
  *dim=0;
  while(fscanf(input, "%*s") != EOF ){
   (*dim)++;
  }
  rewind(input);
  printf("%d\n",*dim);
  *dim = *dim /3;
  *array = malloc(sizeof(data)* (*dim+1));
  for(int i=0; i<*dim; i++){
    fscanf(input, "%s", (*array+i)->nome);
    fscanf(input, "%s", (*array+i)->cognome);
    fscanf(input, "%s", (*array+i)->cf);
  }
}

void aggiorna (data *vect, char *nome, char*cognome, char *cf, int dim){
  strcpy((vect+dim)->nome,nome);
  strcpy((vect+dim)->cognome,cognome);
  strcpy((vect+dim)->cf,cf);
}

void scrivi_file (FILE * output, data * vect, int dim){
  for(int i=0; i<=dim; i++){
    fprintf(output, "%s %s %s ", (vect+i)->nome, (vect+i)->cognome, (vect+i)->cf);
  }
}


int main(){
  char buffer[20];
  int dim;
  data* array;
  FILE* file;
  file = fopen("lista.txt", "r");
  if (file == NULL){
    printf("errore");
    return 1;
  }

  FILE* output = fopen("output.txt","w");

  leggi_file(file,&array,&dim);
  aggiorna(array, "Michele", "Nappi", "nppmch169p22b119", dim);
  for(int i=0; i<=dim;i++){
  printf("[%d] %s %s %s \n",i, (array+i)->nome, (array+i)->cognome, (array+i)->cf);
  }

  scrivi_file(output,array, dim);
  fclose(file);
  fclose(output);
  return 0;
}


