#include<stdio.h>

typedef struct punto{
	float ascissa;
	float ordinata;
}punto;

void in_triangolo(punto xy[3]){
	char *x[]{"primo","secondo","terzo"};
	for(int i=0;i<3;i++){
		printf("Insersci l'ascissa del %s vertice:\n",x[i]);
		scanf("%f",&xy[i].ascissa);
		printf("Insersci l'ordinata del %s vertice:\n",x[i]);
		scanf("%f",&xy[i].ordinata);
	}
}

int check(punto x[3],punto y[3]){
	int flag=0;
	for(int i=0;i<3&&flag==0;i++){
		flag=1;
		for(int j=0;j<3;j++){
			if(x[i].ascissa==y[j].ascissa)
				if(x[i].ordinata==y[j].ordinata)
					flag=0;
		}
	}
	return flag;
}

int main(void){
	punto t1[3];
	punto t2[3];
	printf("Iserisci le coordinate del primo triangolo:\n");
	in_triangolo(t1);
	printf("Iserisci le coordinate del secondo triangolo:\n");
	in_triangolo(t2);
	if(!check(t1,t2))
		printf("I triangoli sono uguali;\n");
	else
		printf("I triangoli non sono uguali;\n");
}
