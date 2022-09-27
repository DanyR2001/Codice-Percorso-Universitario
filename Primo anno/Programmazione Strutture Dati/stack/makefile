link : list main item_int stack_list
	gcc list.o main.o item_int.o stack_list.o -o stack

linkArr : list main item_string stack_array
	gcc list.o main.o item_string.o stack_array.o -o stack

list :
	gcc -c list.c

item_int :
	gcc -c item_int.c

item_string :
	gcc -c item_string.c

main :
	gcc -c main.c

stack_list :
	gcc -c stack_list.c

stack_array :
	gcc -c stack_array.c

clean :
	rm -f list.o main.o item_int.o item_string.o stack_array.o stack_list.o stack
