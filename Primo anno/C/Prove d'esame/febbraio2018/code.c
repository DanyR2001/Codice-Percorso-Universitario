#include <stdlib.h>
#include <string.h>
#include <stdio.h>

typedef struct anagrafe{
  char cognome[20];
  char nome[20];
  float media;
}anagrafe;

anagrafe * leggi_file(FILE *, int*);
void calcola(anagrafe*, float* ,int);
void scrivi_file(FILE* ,anagrafe* ,anagrafe** ,int);

anagrafe *leggi_file(FILE *input, int *dim_vect){
  *dim_vect = 0;
  while(fscanf(input, "%*s") != EOF){
    (*dim_vect)++;
  }
  *dim_vect /= 3;
  rewind(input);
  anagrafe* vettore= malloc(sizeof(anagrafe)* *dim_vect);
  for(int i=0; i<*dim_vect;i++){
    fscanf(input, "%s %s %f", (vettore+i)->cognome, (vettore+i)->nome, &((vettore+i)->media));
  }
  return vettore;
}

void calcola(anagrafe *vect, float * tot_media, int dim_vect){
  *tot_media =0;
  for (int i=0; i< dim_vect; i++){
    *tot_media += (vect+i)->media;
  }
  *tot_media/=dim_vect;
}

void scrivi_file(FILE *output, anagrafe *vect, anagrafe **max, int dim_vect){
  *max=vect;
  for (int i=1;i<dim_vect;i++){
    if ((vect+i)->media > (*max)->media)
      *max=vect+i;
  }
 fprintf(output, "%f", (*max)->media);
}



int main(int argc, char *argv[])
{
  anagrafe *vect, *max;
  float tot_media;
  int dim_vect;
  FILE *input, *output;
  input=fopen(argv[1],"r");
  output=fopen(argv[2],"w");
  if(input == NULL || output == NULL)
    printf("error");


  vect =leggi_file(input,&dim_vect);
  calcola(vect,&tot_media,dim_vect);
  printf("Media: %f",tot_media);
  scrivi_file(output,vect,&max,dim_vect); 
  return 0;
}
