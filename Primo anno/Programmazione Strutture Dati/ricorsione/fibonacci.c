#include <stdio.h>
#include <stdlib.h>

int fibonacci (int n){
    
    if (n == 0 || n == 1)
        return 1;
    return fibonacci(n-1)+fibonacci(n-2);
}

int fibonacciIter (int n){
    int f=1, i, p1=1, p2=1;

    for (i=2; i<=n; i++){
        f = p1 + p2;
        p1 = p2;
        p2 = f;
    }
        

    return f;
}

int main (int argc, char **argv){
    if (argc != 2){
        fprintf(stderr, "Nummero parametri non corretto");
        return 1;
    }

    int fz, z, fzI;

    z = atoi(argv[1]);
        
    fz = fibonacci (z);
    printf("Fibonacci di %d e': %d", z, fz);

    fzI = fibonacciIter(z);
    printf("\nFibonacci iterativa di %d e': %d", z, fzI);

    return 0;
}