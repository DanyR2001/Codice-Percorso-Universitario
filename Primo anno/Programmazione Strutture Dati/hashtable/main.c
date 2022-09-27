#include <stdio.h>
#include "item.h"
#include "list.h"
#include "entry.h"
#include "hashtable.h"
#include "key.h"

#define DIM 5

int main(){
	HashTable h = newHashtable(DIM);

	int i;
	for(i = 0; i < 5; i++){
		printf("Inserisci il nome: ");
		Key k = inputKey();

		printf("Inserisci l' eta': ");
		Item item = inputItem();

		Entry e = newEntry(k, item);

		insertHash(h, e);
	}


	printf("Inserisci il nome da cercare: ");
	Key k = inputKey();
	Entry e = searchHash(h, k);

	if(e != NULL){
		Item item = getValue(e);
		printf("L' eta' e': ");
		outputItem(item);
	}

	else
		printf("Elemento non presente.\n");

	return 0;
}
