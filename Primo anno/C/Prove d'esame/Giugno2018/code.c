#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void concatena(char *, char *, char *);
void conta_consonanti(char [], int *);
void copy_string(char [ ], char [ ], int);

int main(){
  char *input1= "sdaeteruiop";
  char *input2= "eiyearteoiana";
  char* output= malloc( strlen(input1)+strlen(input2)+1);
  concatena(input1,input2, output);
  printf("%s",output);
  return 0;
}

void concatena(char* input1, char* input2, char* output){
  int num_cons1 = 0;
  int num_cons2 = 0;
  int dim_input1= strlen(input1);
  int dim_input2= strlen(input2);

  conta_consonanti(input1, &num_cons1);
  conta_consonanti(input2, &num_cons2);

  if(num_cons1 < num_cons2){
    copy_string(output, input1, 0);
    copy_string(output, input2, dim_input1);
  } else {
    copy_string(output,input2, 0);
    copy_string(output,input1,dim_input2);
  }
}

void conta_consonanti(char vect[], int* num_cons){
  int i=0;
  while(vect[i]){
    if(vect[i] != 'a' && vect[i] != 'e' && vect[i] != 'i' && vect[i] != 'o' && vect[i] != 'u')
      (*num_cons)++;
    i++;
  }
}

void copy_string(char output[], char input[], int offset){
  int i=0;
  while(input[i]){
    output[offset+i] = input[i];
    i++;
  }
  output[offset+i]='\0';

}
