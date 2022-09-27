#include <stdio.h>
#include "point.h"

void main(){
	Point p1, p2;
	float x, y, d;
	
	scanf("%f", &x);
	scanf("%f", &y);
	
	p1=createPoint(x, y);
	
	scanf("%f", &x);
	scanf("%f", &y);
	
	p2=createPoint(x,y);
	
	d=distanza(p1, p2);
	
	printf("%.2f", d);
	
	
}