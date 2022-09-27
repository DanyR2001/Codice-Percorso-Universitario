link : array utils main item_int
	gcc array.o utils.o main.o item_int.o -o array.exe

linkStr : array utils main item_string
	gcc array.o utils.o main.o item_string.o -o array.exe

array :
	gcc -c array.c

utils :
	gcc -c utils.c

item_int :
	gcc -c item_int.c

item_string :
	gcc -c item_string.c

main : 
	gcc -c main.c

clean : 
	rm -f array.o utils.o main.o item_int.o item_string.o array.exe

