#include <stdlib.h>
#include "entry.h"
#include "key.h"
#include "item.h"

struct entry{
	Key key;
	Item value;
};

Entry newEntry(Key k, Item i){
	Entry e = malloc(sizeof(struct entry));
	e->key = k;
	e->value = i;
	return e;
}

Key getKey(Entry e){
	if(e!=NULL)
		return e->key;
	else 
		return NULL;
}
Item getValue(Entry e){
	if(e!=NULL)
		return e->value;
	else 
		return NULL;
}
