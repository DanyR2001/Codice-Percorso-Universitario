linkInt : bst main item_int 
	gcc bst.o main.o item_int.o -o bst.exe

link : bst main item_string 
	gcc bst.o main.o item_string.o -o bst.exe

bst :
	gcc -c bst.c

item_int :
	gcc -c item_int.c

item_string :
	gcc -c item_string.c

main :
	gcc -c main.c


clean :
	del bst.o main.o item_int.o item_string.o bst.exe
