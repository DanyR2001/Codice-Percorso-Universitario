#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX 5

typedef struct info{
  char stringa[20];
  int dim_stringa;
}info;

char * max_parola(char *[]); /*determina l’indirizzo della parola più lunga presente nell’array di puntatori a carattere*/
info * copia_max(char *); /* a partire dall’indirizzo della parola più lunga copia la parola e la sua dimensione in un record di cui restituisce il puntatore*/

int main()
{
  char *data[MAX]={"sole", "tavolo","vetro","finestra","aia"}, *ptr_max;
  info *rec;
  ptr_max=max_parola(data);
  rec=copia_max(ptr_max);
  printf ("%s %d\n", rec->stringa, rec->dim_stringa); /*stampa il contenuto del record ossia la parola più lunga e la sua dimensione: nel caso in esame l’output sarà: finestra 8 */

}

char* max_parola(char* data[]){
  int lett_max=0;
  int idx_max=0;
  for(int i=0; i<MAX; i++){
    if( strlen(*(data+i)) > lett_max){
     lett_max = strlen(*(data+i));
      idx_max=i;
    }
  }
  return *(data+idx_max);
}

info * copia_max(char* max_parola){
  info * tmp = malloc(sizeof(info));
  strcpy(tmp->stringa, max_parola);
  tmp->dim_stringa=strlen(max_parola);
  return tmp;
}
