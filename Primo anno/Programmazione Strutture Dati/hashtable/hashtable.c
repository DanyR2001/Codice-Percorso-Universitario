#include <stdlib.h>
#include "hashtable.h"
#include "list.h"
#include "entry.h"
#include "key.h"

#define N 20

struct hashtable{
	int size;
	List *entries;
};

HashTable newHashtable(int size){
	HashTable h = malloc(sizeof(struct hashtable));

	h->size = size;
	h->entries = malloc(sizeof(List) * size);

	int i;
	for(i = 0; i < size; i++)
		h->entries[i] = newList();

	return h;
}

int insertHash(HashTable h, Entry e){
	int index = hashValue(getKey(e), h->size);
	addHead(h->entries[index], e);
	return 1;
}

Entry searchHash(HashTable h, Key k){
	int index = hashValue(k, h->size), pos;

	Entry e = newEntry(k, NULL);
	return searchList(h->entries[index], e, &pos);
}

Entry deleteHash(HashTable h, Key k){
	int index = hashValue(k, h->size);

	Entry e = newEntry(k, NULL);
	return removeListItem(h->entries[index], e);
}
