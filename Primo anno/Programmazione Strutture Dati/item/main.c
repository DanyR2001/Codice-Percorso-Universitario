#include <stdio.h>
#include "array.h"
#include "item.h"

#define DIM 10


int main(){

	Item arr[DIM];
    int n = 5;

    inputArray(arr, n);
	bubbleSort(arr, n);
    printArray(arr, n);
	
	// printf("%d",searchBin(arr,n,ele));
	
    //cont = adaptiveBubbleSort(arr, n);

    //printf ("numero di confronti bubbleSort -> %d\n", cont);

    //adaptiveBubbleSort(arr, n);
	//printArray(arr,n);

    return 0;
}