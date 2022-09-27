#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define DIM 4


void leggi_file(FILE *,int **);
int * cerca_max(int **);
void scrivi_file(FILE *, int *);

void leggi_file(FILE* file, int **matrice){
  srand(0);
  int n_elementi = 0;
  for(int i=0 ; i<DIM ; i++){
    fscanf(file, "%d", &n_elementi);
    *(matrice+i) = malloc(sizeof(int)* (n_elementi+1)); //assegno il vettore da n_elementi+1 a matrice[i]
    *(*(matrice+i)+0) = n_elementi; //assegno il numero di elementi in matrice[i][0]

    //random
    for(int j=1; j<=*(*(matrice+i)); j++)
      *(*(matrice+i)+j)=rand()%10;

  }
}

int *cerca_max(int **matrice){
  int * vettore_massimi = calloc(DIM, sizeof(int));
  for(int i=0;i<DIM;i++){
    for(int j=1;j<= *(*(matrice+i)+0) ; j++){
      if(*(*(matrice+i)+j) > *(vettore_massimi+i) )
        *(vettore_massimi+i) = *(*(matrice+i)+j);
    }
  }
  return vettore_massimi;
}

void scrivi_file(FILE* file_output, int* vettore_massimi){
  for(int i=0; i<DIM;i++)
  {
    fprintf(file_output, "%d ", *(vettore_massimi+i));
  }
}

int main(int argc, char *argv[])
{
  int *matrice[DIM],*vect_max;
  FILE *output, *input;
  input=fopen(argv[1],"r");
  if(!input)
    exit (0);
  output=fopen(argv[2],"w");
  if(!output)
    exit (2);
  leggi_file(input, matrice);

  for(int i=0; i<DIM; i++){
    for(int j=0; j<= *(*(matrice+i)+0); j++){
      printf("%d ", *(*(matrice+i)+j));
    }
    printf("\n");
  }

  vect_max=cerca_max(matrice);
  scrivi_file(output, vect_max);
  free(vect_max);
  fclose(input);
  fclose(output);
}
