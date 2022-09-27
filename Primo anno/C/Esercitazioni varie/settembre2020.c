#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 5

typedef struct{
    char *data;
    int dim;
}MaxString;

void ordina(char **);
int scorri(char **lista);
void swap(char **lista, int i);
char *cercaMax(char **lista);
void memStr(MaxString *info, char *ptr);
void stampa(MaxString info);

void ordina(char **lista){
    while(scorri(lista));
}

int scorri(char **lista){
    int sorted = 0;
    for(int i= 0; i<MAX-1; i++){
        if(strcmp(lista[i], lista[i+1]) > 0){
            swap(lista, i);
            sorted = 1;
        }
    }
    return sorted;
}

void swap(char **lista, int i){
    char *temp = lista[i];
    lista[i] = lista[i+1];
    lista[i+1] = temp;
}

char *cercaMax(char **lista){
    char *max = lista[0];

    for(int i = 1; i < MAX; i++){
        if (strlen(lista[i]) > strlen(max))
            max = lista[i];
    }
    return max;
}

void memStr(MaxString *info, char *ptr){
    int len = strlen(ptr);
    info->data = malloc(len * sizeof(char));
    strcpy(info->data, ptr);
    info->dim = len;
}

void stampa(MaxString info){
    printf("%s %d\n", info.data, info.dim);
}


int main(){
    char *lista[MAX] = {"aa", "bb", "ccc", "dddd", "eee"}, *max;
    MaxString inf;
    ordina(lista);
    max = cercaMax(lista);
    memStr(&inf, max);
    
    for(int i = 0; i < MAX; i++){
        printf("%s ", lista[i]);
    }
    
    stampa(inf);
    return 0;
}

