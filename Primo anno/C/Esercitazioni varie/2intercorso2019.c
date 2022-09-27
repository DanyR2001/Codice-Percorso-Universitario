#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char s[20],y[20],v[20];

typedef struct Libro{
char *nome;
char *cognome;
char *titolo;
float prezzo;
}Libro;

void saveLibro(Libro *x, char **y, float p){
  x->nome=y[0];
  x->cognome=y[1];
  x->titolo=y[2];
  x->prezzo=p;
}

Libro * saveLibroInput(void){
  Libro *x=malloc(sizeof(Libro));
  if(x!=NULL){
    float j;
      printf("inserisci il nome del autore del libro \n");
      scanf("%s",s);
      printf("inserisci il cognome del autore del libro \n");
      scanf("%s",y);
      printf("inserisci il titolo del libro \n");
      scanf("%s",v);
      printf("inserisci il prezzo del libro \n");
      scanf("%f",&j);
      x->nome=s;
      x->cognome=y;
      x->titolo=v;
      x->prezzo=j;
      return x;
  }
  else
    return NULL;
}
Libro * cmpLibro(Libro *x, Libro *y){
  if(strcmp(x->nome,y->nome)==0&&strcmp(x->cognome,y->cognome)==0&&strcmp(x->titolo,y->titolo)==0){
    if((x->prezzo)>(y->prezzo))
      return y;
    else
      return x;
    }
  else
    return NULL;
}
void stampa(Libro x, Libro *y){
  printf("Titolo:%s, Nome autore:%s, Cognome Autore:%s, Prezzo:%f \n",x.titolo,x.nome,x.cognome,x.prezzo);
  printf("Titolo:%s, Nome autore:%s, Cognome Autore:%s, Prezzo:%f \n",y->titolo,y->nome,y->cognome,y->prezzo);
}
void freeRecord(Libro *x, Libro*y){
  free(y);
}
int main(void) {
char *infoLibro[]={"Umberto","Eco","Baudolino"}, *max;
Libro info1, *info2, *info3=NULL;
float prezzo= 15.30;
saveLibro(&info1, infoLibro, prezzo);
info2=saveLibroInput();
stampa(info1, info2);
info3=cmpLibro(&info1, info2);
if(info3!=NULL)
printf("\nIl libro più economico è: %s %s %s %f \n",info3->nome,info3->cognome, info3->titolo, info3->prezzo);
freeRecord(&info1, info2);
return 0; }
