#include <stdio.h>
#include "utils.h"
#include "item.h"


void printArray(Item *a, int n){

    int i;
    for(i = 0; i < n; i++)
        outputItem(a[i]);
    printf("\n");
}


void inputArray(Item *arr, const int n){

    int i;
    for(i = 0; i < n; i++)
        arr[i] = inputItem();
    
}

int bubbleSort (Item *a, int n) {

    int i, j, cont = 0;

    for (i = 1; i < n; i++) {
        for (j = 0; j < n - i; j++) {
            cont++;
            if (cmpItem(a[j], a[j + 1]) > 0)
                swap(a + j, a + j + 1);
        }
    }

    return cont;

}
