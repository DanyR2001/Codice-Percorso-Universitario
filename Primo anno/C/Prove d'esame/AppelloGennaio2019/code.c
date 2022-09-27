#include <stdio.h>
#include <stdlib.h>
#include <string.h>



int read_file(FILE*, char*);
char* store_vect (char*);
int pal(char*);
char* reverse(char* s1);


int main(){
  FILE* file=fopen("input","r");
  char stringa[100];
  read_file(file, stringa);
  char* stored_string = store_vect(stringa);
  printf("%s\n",stored_string);
  printf("%d\n",pal(stored_string));
  char* reverse_string = reverse(stored_string);
  printf("%s",reverse_string);
  return 0;
}

int read_file(FILE* in, char*s){
  char input;
  int i=0;
  while( ((input = getc(in))!=EOF) && i<99){
    *(s+i)=input;
    i++;
  }
  return 0;
}

char* store_vect (char *s){
  char* temp= malloc(strlen(s)+1);
  strcpy(temp,s);
  return temp;
}

int pal(char* s1){
  int dim=strlen(s1);
  for(int i=0; i<dim/2; i++){
    if(*(s1+i) != *(s1+dim-2-i)) //NOTA: perchè -2? Standard Unix. Ogni file termina con \n\0
      return 0;
  }
  return 1;
}

char* reverse (char* s1){
  int dim=strlen(s1);
  char* temp = malloc(dim+1);
  for(int i=0; i<dim; i++)
    *(temp+i)=*(s1+dim-2-i);
  *(s1+dim)='\0';
  return temp;
}
