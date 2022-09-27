#include <stdio.h>
#include <stdlib.h>

int mcdIter(int a, int b){
    int r;

    while (b!=0){
        r = a%b;
        a = b;
        b = r;
    }
    return a; 
}

int mcdRicorsiva(int a, int b){
    if(b==0)
        return a;
    return mcdRicorsiva(b, a%b);
}

int main(int argc, char const *argv[])
{
    if(argc!=3){
        fprintf(stderr, "\nErrore, inserire due valori interi ");
        return 1;
    }

    int a, b;
    a = atoi(argv[1]);
    b = atoi(argv[2]);

    printf("\nMCD(iterativa) di %d e %d = %d", a, b , mcdIter(a, b));
    printf("\nMCD(ricorsiva) di %d e %d = %d", a, b , mcdRicorsiva(a, b));
    return 0;
}
