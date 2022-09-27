#include <stdio.h>
#include <stdlib.h>

int* compatta(int* s1, int dim){
  int* s2 = malloc(sizeof(int)*dim);
  int el_distinti = 0;
  for(int i=0; i<dim-1; i++){
    if(*(s1+i) == *(s1+i+1))
      continue;
    *(s2 + el_distinti++) = *(s1+i);
  }
  *(s2 + el_distinti++) = *(s1+dim-1);

  s2 = realloc(s2, sizeof(int)*(el_distinti+1));
  return s2;
}

int uguale(int* s1,int dim){
  for(int i=1; i<dim; i++){
    if(*(s1+0) != *(s1+i))
      return 0;
  }
  return 1;
}

void shift(int* s1, int dim){
  for(int i=1; i<dim; i++)
    *(s1+i-1)==*(s1+i);
  *(s1+dim-1)=0;
}



//Test codice
int main(){
  int vect[10]={1,2,2,4,4,4,5,6,7,7};
  int* vect_distinti = compatta(vect, 10);
  
  for(int i=0; i< 6; i++){
    printf("%d ", *(vect_distinti+i));
  }

  int vect_uguali[3]={1,1,1};
  printf("\n %d %d\n ", uguale(vect,10), uguale(vect_uguali,3));

  shift(vect,10);

  for(int i=0; i<10; i++){
    printf("%d ", *(vect+i));
  }
  return 0;
}
