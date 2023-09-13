import MyDictionary
from MyDictionary import *
from MyPair import Pair
for k in vars(MyDictionary):
    print(k)
for k in vars():
    print(k)
x=Dictionary()
x['mara']='meo'
x.print()
x['mara']='miao'
x.print()
del x['mara']
x.print()
print("hahah")
print(x == x)
print("----")
x['mara']='meo'
x['orco']='mio'
x['mero']='miao'
x.print()
print("----")
print("len ",len(x))
print(x['mara'])
print(x['asbulla'])
print(x == x)
print("----")
y=Dictionary()
y.print()
print("----")
print(x == y)
print("----")

y["mario"]="gallo"
y.print()
print("----")

print(x == y)
print("----")
del y["mario"]
print("----")
y.print()
print("----")
y['mara']='meo'
y['orco']='mio'
y['mero']='miao'
print("----")
y.print()
print("----")
print(x == y)
print("----")
"""
a=input("inserisci la parola da ricercare del file:")
fp=open('marco','r')
fp.close()
fp=open('marco','r')
cont=0
for line in fp:
    print(line)
    if line.count(a)>=0:
        cont+=line.count(a)
if cont>0:
    print("trovata ",cont," volte")
else:
    print("NON TROVATA")
"""
