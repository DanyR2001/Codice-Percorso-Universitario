#include <math.h>
#include <stdlib.h>

#include "point.h"

struct point {
	float x;
	float y;
};

Point createPoint(float x, float y){
	Point p;
	
	p=malloc(sizeof(struct point));
	
	p->x= x;
	p->y=y;
	
	return p;
	 
}
 
float ascissa(Point p){
	return p->x;
	
}

float ordinata(Point p){
	return p->y;
}

float distanza(Point p1, Point p2){
	float d, dx, dy;
	dx= p1->x - p2->x;
	dy= p1->y - p2->y;
	
	d=sqrt(dx*dx + dy*dy);
	
	return d;
}