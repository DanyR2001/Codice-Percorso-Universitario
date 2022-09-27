#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "key.h"
#define DIM 30

int equals(Key a, Key b){
	char *a1, *b1;
	a1 = a;
	b1 = b;
	if(strcmp(a1, b1)==0)
		return 1;
	else
		return 0;
}

int hashValue(Key k, int m){
	char *v = k;
	int h = 0, a = 128;
	for (; *v != '\0'; v++)
		h = (h*a + *v) % m;
	return h;
}

Key inputKey(){
	char *a;
	a = malloc(sizeof(char)*DIM);
	scanf("%s",a);
	return a;
}

void outputKey(Key k){
	char *a = k;
	printf("%s\t",a);
}
