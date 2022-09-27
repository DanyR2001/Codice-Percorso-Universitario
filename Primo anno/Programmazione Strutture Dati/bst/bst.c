#include <stdlib.h>
#include "bst.h"
#include "item.h"

struct node{
	Item value;
	struct node *left;
	struct node *right;
};



BST newBST()
{
	return NULL;
}





int isEmptyBST(BST b){
	if(b==NULL) 
		return 1;
	return 0;
}




BST getLeft(BST b){
	if(isEmptyBST(b)) return NULL;
	return b->left;
}
BST getRight(BST b){
	if(isEmptyBST(b)) return NULL;
	return b->right;
}





Item search(BST bst, Item item)
{
	if(isEmptyBST(bst))
		return NULL;

	int res=cmpItem(item, bst->value);

	if(res==0)
		return bst->value;
	else if(res<0)
		return search(getLeft(bst), item);
	else
		return search(getRight(bst), item);
}




Item min(BST bst)
{
	if(isEmptyBST(bst))
		return NULL;

	while(getLeft(bst)!=NULL)
		bst=bst->left;

	return bst->value;
}




Item max(BST bst)
{
	if(isEmptyBST(bst))
		return NULL;

	while(getRight(bst)!=NULL)
		bst=bst->right;

	return bst->value;
}




void insertBST(BST *bst, Item item)
{
	if(isEmptyBST(*bst))
	{
		*bst=malloc(sizeof(struct node));
		(*bst)->value=item;
		(*bst)->left=NULL;
		(*bst)->right=NULL;
	}
	else
	{
		int res=cmpItem(item, (*bst)->value);

		if(res<0)
			insertBST(&((*bst)->left), item);
		else if(res>0)
			insertBST(&((*bst)->right), item);
	}
}

Item deleteBST(BST *bst, Item item)
{
	
	if(isEmptyBST(*bst))
		return NULL;

	int res=cmpItem(item, (*bst)->value);

	if(res == 0)
	{
		if(isEmptyBST((*bst)->left))
		{
			BST tmp = *(bst);
			(*bst) = (*bst)->right;
			Item value = tmp->value;
			free(tmp);
			return value;
		}

		else if(isEmptyBST((*bst)->right))
		{
			BST tmp = *(bst);
			(*bst) = (*bst)->left;
			Item value = tmp->value;
			free(tmp);
			return value;
		}

		else
		{
			Item m = max((*bst)->left);
			Item r = (*bst)->value;
			(*bst)->value = m;
			deleteBST(&((*bst)->left), m);
			return r;
		}
	}

	else if(res<0)
		return deleteBST(&((*bst)->left), item);

	else 
		return deleteBST(&((*bst)->right), item);
	

}