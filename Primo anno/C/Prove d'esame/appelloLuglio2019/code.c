#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char * concatena(char *, char *);
void conta_consonanti(char [ ], int *);

int main(){
	char* input1= "sdaeteruiop";
	char* input2= "eiearteoiana";
	char* output = concatena(input1,input2);
	printf("%s",output);
	return 0;
}



char* concatena(char* input1, char* input2){
  int consonanti1,consonanti2;
  conta_consonanti(input1, &consonanti1);
  conta_consonanti(input2, &consonanti2);
  char* output = malloc(consonanti1 + consonanti2);


  int i=0, j=0;
  while(*(input1+i)){
    switch(*(input1+i)){
      case 'a': case 'e' : case 'i' :
      case 'o' : case 'u':
            break;
      default:
            *(output + j++) = *(input1 +i );   //nota: x + y++ equivale a fare x+y e poi y=y+1.
            break;
    }
    i++;
  }
  
  
  i=0;

  while(*(input2+i)){
    if( *(input2+i) != 'a' && *(input2+i) != 'e' && *(input2+i) != 'i' && *(input2+i) != 'o' && *(input2+i) != 'u') //questo if e lo switch sopra fanno la stessa cosa
      *(output + j++) = *(input2 +i );                                                                              //per ridurre il codice ripetuto si può fare un ciclo
    i++;
  }

  return output;

}


void conta_consonanti(char string[ ], int* output){
	*output=0;
	for (int i=0; i<strlen(string); i++){
	  if( *(string+i) != 'a' && *(string+i) != 'e' && *(string+i) != 'i' && *(string+i) != 'o' && *(string+i) != 'u')
			(*output)++;
	}
}

