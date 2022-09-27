#include <stdio.h>
#include <string.h>

int palindromaIter(char parola[]){
    int i, j;

    for (i = 0, j= strlen(parola)-1; i < j; i++, j--)
    {
        if(parola[i]!=parola[j])
            return 0;
    }
    return 1; 
}

int palindromaTail1(char parola[], int i, int j){
    if(i<j){
        if(parola[i]!=parola[j])
            return 0;
        else
            return palindromaTail1(parola, i+1, j-1);
    }
    return 1;
}

int palindromaTail(char parola[]){
    return palindromaTail1(parola, 0, strlen(parola)-1);
}

int palindromaRicorsiva1(char parola[], int len){
    if(len<=1)
        return 1;
    if(parola[0]!=parola[len-1])
        return 0;
    return palindromaRicorsiva1(parola+1, len-2);
}

int palindromaRicorsiva(char parola[]){
    return palindromaRicorsiva1(parola, strlen(parola));
}

int main(int argc, char *argv[])
{
    if(argc!=2){
        fprintf(stderr, "\nErrore, inserire una stringa ");
        return 1;
    }
 
    if(palindromaIter(argv[1]))
        printf("\nPalindroma Iter"); 
    else
         printf("\nNon Palindroma Iter");

    if(palindromaTail(argv[1]))
        printf("\nPalindroma Tail"); 
    else
         printf("\nNon Palindroma Tail");
    
    if(palindromaRicorsiva(argv[1]))
        printf("\nPalindroma Ric"); 
    else
         printf("\nNon Palindroma Ric");
    return 0;
}