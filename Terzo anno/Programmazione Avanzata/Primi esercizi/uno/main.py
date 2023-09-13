def fattorialeRic(n):
        if(n==1):
            return 1
        else:
            return fattorialeRic(n-1)*n

def fattorialeIter(n):
    result=1;
    for i in range(1,n+1):
        result*=i;
    return result

print("fattoriale di 3:",fattorialeRic(3));
print("fattoriale di 3:",fattorialeIter(3));

# es lista contiene iterable
L=[1,2,3,'a',5]
# es list
a=list([1,3,'a',6])
# es tuple IMMUTABILE
t=(1,2,'4',4)
x,b,c,y=t
print("x:",x,"b:",b,"c:",c,"y:",y)
# es set insieme
ins={1,2,3,'5',9}
# es dict
d={"k1":25,"k2":34,"k3":'a'}

def funcSumInt(a):
    res = 0
    for i in a:
        if (type(i) == int):
            res += i
    return res

def funcSumIntDict(a):
    res = 0
    for i in a.values():
        if type(i) == int:
            res += i
    return res

print("value:",funcSumInt(L))
print("tot :",funcSumInt(a))
print("val:",funcSumInt(t))
print("ins:",funcSumInt(ins))
print("ins:",funcSumIntDict(d))

from moduloBase import Base
x=Base()
x.print_x()
x.modifica_x("sasso")
x.print_x()
print(x)
from moduloDer1Der2 import Der2
x=Der2()
x.print_x()
x.modifica_x("pesci")
x.print_x()






