#include <stdio.h>
#include <stdlib.h>

int fact (int n){
    
    if (n == 0)
        return 1;
    return n*fact(n-1);
}

int factIter (int n){
    int f=1, i;

    for (i=1; i<=n; i++)
        f = f*i;

    return f;
}

int main (int argc, char **argv){
    if (argc != 2){
        fprintf(stderr, "Nummero parametri non corretto");
        return 1;
    }

    int fz, z, fzI;

    z = atoi(argv[1]);
        
    fz = fact (z);
    printf("Il fattoriale di %d e': %d", z, fz);

    fzI = factIter(z);
    printf("\nIl fattoriale di %d e': %d", z, fzI);

    return 0;
}