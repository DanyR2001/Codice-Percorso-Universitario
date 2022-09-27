#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct city{
  char citta[20];
  char nazione[20];
  long int abitanti;
}city;

void leggi_file(FILE*, city**, int*);
void aggiorna(city[], city*, city, int);

void leggi_file(FILE *input, city **array, int *dim){
  while( fscanf(input, "%*s %*s %*s") != EOF)
    (*dim)++;

  *array=malloc(*dim * sizeof(city));
  rewind(input);
  for(int i=0; i<*dim; i++){
    fscanf(input, "%s %s %ld", (*array+i)->citta, (*array+i)->nazione, &((*array+i)->abitanti)); 
  }
}

void aggiorna(city vect[], city* old, city new, int dim_vect){
  int max=0;
  for(int i=1; i<dim_vect;i++)
    if((vect+i)->abitanti > (vect+max)->abitanti)
      max=i;

  strcpy(old->citta, (vect+max)->citta);
  strcpy(old->nazione,(vect+max)->nazione);
  old->abitanti=(vect+max)->abitanti;

  strcpy((vect+max)->citta, new.citta);
  strcpy((vect+max)->nazione, new.nazione);
  (vect+max)->abitanti = new.abitanti;
}

int main(){
  FILE* file = fopen("input", "r");
  city* array;
  int dim_array=0;
  city nuova_citta = {"Mosca", "Russia", 11.000};

  leggi_file(file, &array, &dim_array);
  for(int i=0; i<dim_array; i++){
    printf("[%d] %s %s %ld\n", i, array[i].citta, array[i].nazione, array[i].abitanti);
  }

  city old;
  aggiorna(array, &old, nuova_citta, dim_array);


}
