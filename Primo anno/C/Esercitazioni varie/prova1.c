#include <stdio.h>
#include <string.h>
#define MAX 5
#define INPUT 'x'

char * cercaC(char *data[]){
	int flag=0,i,j;
	for(i=0;i<5&&flag==0;i++){
		for(j=0;j<strlen(data[i])&&flag==0;j++){
			if(data[i][j]==INPUT)
				flag=1;
			}
		}
		i--;
	if(flag==1)
		return data[i];
	else
		return NULL;

}
char * cercaPref (char **data, char *pref){
	int flag=0,i,j;
	for(i=0;i<5&&flag==0;i++){
		flag=1;
		for(j=0;j<strlen(pref)&&flag==1;j++){
			if(data[i][j]!=pref[j])
				flag=0;
			}
	}
	i--;
	if(flag==0)
		return NULL;
	else
		return data[i];
	/*
	char * cercaPref (char **data, char *pref){
	int i;
	for(i=0;i<MAx;i++)
		if(!strncmp(data[i],prt,streln(ptr))
			return data[i];
	return NULL;
	}
	*/
}
void stampa_out (char *x, char *s){
	printf("La prima stringa contente la x e %s \n",x);
	printf("La prima stringa contente la il suffisso e %s \n",s);
}

int main()
{
	char *data[MAX]={"bgdsjdf","pfofydb","nfhsgxdi","uetdgds","vcfsxkd"}, *ptrString, *pref="uet", *str;
	ptrString=cercaC(data);
	str=cercaPref(data,pref);
	stampa_out(ptrString, str);
}
