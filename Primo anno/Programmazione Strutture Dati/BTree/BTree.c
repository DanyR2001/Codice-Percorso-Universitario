#include <stdlib.h>
#include "BTree.h"
#include "item.h"

struct node{
	Item value;
	struct node *left;
	struct node *right;
};

BTree newTree(){
	return NULL;
}

int isEmptyTree(BTree b){
	if(b==NULL) return 1;
	return 0;
}

BTree buildTree(BTree b1, BTree b2, Item e){
	if(e==NULL) return NULL;
	BTree b=malloc(sizeof(struct node));
	b->value=e;
	b->left=b1;
	b->right=b2;
	
	return b;
}

Item getBTreeRoot(BTree b){
	if(isEmptyTree(b)) return NULL;
	return b->value;
}

BTree getLeft(BTree b){
	if(isEmptyTree(b)) return NULL;
	return b->left;
}
BTree getRight(BTree b){
	if(isEmptyTree(b)) return NULL;
	return b->right;
}

void preOrder(BTree b){
	if(!isEmptyTree(b)){
		outputItem(b->value);
		preOrder(b->left);
		preOrder(b->right);
	}
}
void postOrder(BTree b){
	if(!isEmptyTree(b)){
		postOrder(b->left);
		postOrder(b->right);
		outputItem(b->value);
	}
}
void inOrder(BTree b){
	if(!isEmptyTree(b)){
		inOrder(b->left);
		outputItem(b->value);
		inOrder(b->right);	
	}	
}