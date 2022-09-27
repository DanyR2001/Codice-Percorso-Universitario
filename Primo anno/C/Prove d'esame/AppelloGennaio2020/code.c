#include <stdio.h>
#include <string.h>
#define MAX 5
/*definizione prototipi*/
char * cerca_pal(char *[], FILE *);
int pal(char *);
void scrivi_file(FILE *, char *);

int main(int argc, char *argv[])
{
  FILE *output, *input;
  input=fopen(argv[1],"r");
  output=fopen(argv[2],"w");
  char *data[MAX]={"nvcfvfdv", "vfvfhvvs","xxppxx","uutryvsdg","nvjfiep"}, *ptr_pal;
  ptr_pal=cerca_pal(data, input);
  if (ptr_pal)
    scrivi_file(output,ptr_pal);
}


char* cerca_pal(char* data[], FILE* F){
  char temp[50];
  fscanf(F, "%s", temp);
  for(int i=0;i<MAX;i++){
    if (strcmp(temp, *(data+i)) == 0)
        if(pal(temp))
            return *(data+i);
  }
  return NULL;
}

int pal(char* string){
  for(int i=0; i< strlen(string)/2; i++){ //Traccia: utilizzare notazione puntatore e vettore wtf
    if(string[i] != *(string+strlen(string)-1-i))
      return 0;
  return 1;
  }
}

void scrivi_file(FILE* F, char* string){
  fprintf(F, "%s %p", string, string);
}
