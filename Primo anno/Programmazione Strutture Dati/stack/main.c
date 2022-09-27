#include <stdio.h>
#include "item.h"
#include "stack.h"

int main(){

    int i;
    Item elem;
    Stack stack = newStack();

    for(i=0;i<5;i++){
        printf("Inserisci un elemento: ");
        elem = inputItem();
        push(stack, elem);
        printStack(stack);
        printf("\n");

    }

    for(i=0;i<5;i++){
        pop(stack);
        printStack(stack);
        printf("\n");
    }

    return 0;
}
