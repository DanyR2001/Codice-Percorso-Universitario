#include <stdlib.h>
#include <stdio.h>
#include "bst.h"
#include "item.h"



int main(){
	BST bst=newBST();

	int var = 30;
	int vect[]={20, 10, 30, 5, 15, 25, 40, 3, 6, 13, 35};
	int i;

	for(i=0; i<sizeof(vect)/sizeof(int); i++)
		insertBST(&bst, &vect[i]);

	deleteBST(&bst, &var);

	printf("Massimo:\t");
	outputItem(max(bst));
	printf("\nMinimo:\t");
	outputItem(min(bst));

	printf("\n\nInserisci elemento da cercare:\t");

	if(search(bst, inputItem())==NULL)
		printf("Elemento non trovato.\n");
	else
		printf("Elemento trovato.\n");

	return 0;
}