import types


def decFact(type):

    def decorator(cls):

        def riportaVariaviliDiClasse():
            for clas in cls.__mro__:
                for key,value in vars(clas).items():
                    if isinstance(value,type) :
                        yield (key,value,clas)
        setattr(cls,"riportaVariaviliDiClasse",staticmethod(riportaVariaviliDiClasse))

        return cls

    return decorator

class ClasseBase:

    x=5
    t="10"

@decFact(str)
class Figlio(ClasseBase):

    z=55
    x="cipolle"

if "__main__"==__name__:
    fi=Figlio()
    #print(Figlio.__mro__)
    #print(vars(Figlio))
    iter=Figlio.riportaVariaviliDiClasse()
    while True:
        print(next(iter))





