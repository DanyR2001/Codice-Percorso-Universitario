
"""
    Definire un decoratore di classe che permette alla classe decorata di contare le sue istanze.
"""


def decora(cls):
    oldInit=getattr(cls,"__init__")
    counter=0
    setattr(cls,"ClassCounter",counter)
    def newInit(self,*args,**kwargs):
        cls.ClassCounter+=1
        oldInit(self,*args,**kwargs)
    setattr(cls,"__init__",newInit)
    return cls


@decora
class Panino:
    pass


class Mortadella(Panino):
    pass


if __name__=="__main__":
    x=Panino()
    y=Panino()
    z=Mortadella()
    print(Panino.ClassCounter)