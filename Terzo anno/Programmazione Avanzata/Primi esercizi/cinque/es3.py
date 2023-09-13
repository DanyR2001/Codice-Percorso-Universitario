import functools

def myDecorator(aClass):
    def contaVarClasse(self, t):
        counter = 0
        #print(type(self).__dict__)
        dict=type(self).__dict__
        for key in dict:
            if key!= '__module__' and key!= '__doc__':
                if type(dict[key]) == t:
                    counter += 1
        print(counter)
    aClass.contaVar=contaVarClasse
    return aClass

@myDecorator
class padrepio:
    miao=0

    def __init__(self):
        print("sciao")



class classeBase:
    varC=1000

    def __init__(self):
        self.varL=10

    def f(self,v):
        print(v*self.varL)

    @staticmethod
    def g(pizza):
        print(pizza*__class__.varC)



def ensure(Class):
    setattr(Class,"__init__",classeBase.__init__)
    setattr(Class,"varC",classeBase.varC)
    setattr(Class,"f",classeBase.f)
    setattr(Class,"g",staticmethod(classeBase.g))
    return Class



@ensure
class Figlio:
    pass

x=Figlio()
print(x.varC)
x.f(10)
print(vars(Figlio))
print(Figlio.g(10))


