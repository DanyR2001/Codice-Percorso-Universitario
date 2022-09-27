#include <stdio.h>

#define DIM 10

void inputArray(int *arr, const int n){

    int i;
    for(i = 0; i < n; i++)
        scanf("%d", arr + i);
    
}

/*T(n)= T(n/2) + b
1.b a=1 -> O(T(n))=log n */ 

int searchBinRic(int *a, int begin, int end, int elem){
	if(begin > end)
        return -1;
    int center;
	
    center = (begin+end)/2;

	if(a[center] == elem)
		return center;
	else if(elem <a[center])
		return searchBinRic(a, begin, center-1, elem);
	else if(elem > a[center])
		return searchBinRic(a, center+1, end, elem);
}

int searchBin (int *a, int n, int elem)
{
    return searchBinRic(a, 0, n-1, elem);
}



int main(){

	int arr[DIM];
    int n = 5;
    int cont,ele;

    inputArray(arr, n);
	
	scanf("%d",&ele);
	
	printf("%d",searchBin(arr, n, ele));

    return 0;
}