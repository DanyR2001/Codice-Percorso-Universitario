#include <stdio.h>
#include "item.h"
#include "list.h"

#define DIM 10


int main(){
    
    int i, pos;
    Item elem;
    List l = newList();
    List l1 ;
    
    for(i=0;i<5;i++){
        elem=inputItem();
        addListTail(l, elem);
    }
    l1 = cloneListItem(l);
    reverseList(l);
    printList(l);
    printf("\n");
    printList(l1);
    
    printf("\n");
 	
    return 0;
}
