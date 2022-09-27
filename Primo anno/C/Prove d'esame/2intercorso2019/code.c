#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
	char *nome;
	char *cognome;
	char *titolo;
	float prezzo;
}Libro;

void saveLibro(Libro *, char **, float);
Libro * saveLibroInput(void);
Libro * cmpLibro(Libro *, Libro *);
void stampa(Libro, Libro *);
void freeRecord(Libro *, Libro*);

int main(void)
{
	char *infoLibro[]={"Umberto","Eco","Baudolino"},*max;
	Libro info1, *info2, *info3;
	float prezzo= 15.30;
	saveLibro(&info1, infoLibro, prezzo);
	info2=saveLibroInput();
	stampa(info1, info2);
	info3=cmpLibro(&info1, info2);
	if(info3)
	printf("\nIl libro più economico è: %s %s %s %f\n",info3->nome,info3->cognome, info3->titolo,info3->prezzo);
	freeRecord(&info1, info2);
	return 0;
}

void saveLibro(Libro * libro, char ** infoLibro, float prezzo){
	libro->nome=*(infoLibro+0);
	libro->cognome=*(infoLibro+1);
	libro->titolo=*(infoLibro+2);
	libro->prezzo=prezzo;
}

Libro * saveLibroInput(){
	if((Libro * result = malloc(sizeof(Libro))) == NULL) return NULL;
	scanf("%s", result->nome=malloc(80));
	scanf("%s", result->cognome=malloc(80));
	scanf("%s", result->titolo=malloc(80));
	scanf("%f", &(result->prezzo));
	return result;
}

void stampa(Libro libro, Libro * libro_ptr){

	printf("%s;%s\n",libro.nome, libro_ptr->nome);
	printf("%s;%s\n",libro.cognome, libro_ptr->cognome);
	printf("%s;%s\n",libro.titolo, libro_ptr->titolo);
	printf("%f;%f\n",libro.prezzo, libro_ptr->prezzo);
}

Libro * cmpLibro(Libro * l1, Libro * l2){
	if(strcmp(l1->titolo, l2->titolo)!=0)
		return NULL;
	return (l1->prezzo < l2->prezzo? l1:l2);
}

void freeRecord(Libro * l1, Libro * l2){
	free(l2);
}

