link : list main item_int
	gcc list.o main.o item_int.o -o list.exe

linkStr : list main item_string
	gcc list.o main.o item_string.o -o list.exe

list :
	gcc -c list.c

item_int :
	gcc -c item_int.c

item_string :
	gcc -c item_string.c

main : 
	gcc -c main.c

clean : 
	rm -f list.o main.o item_int.o item_string.o list.exe

