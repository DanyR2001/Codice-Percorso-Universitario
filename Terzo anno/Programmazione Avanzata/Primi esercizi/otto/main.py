
def decora(classe,funz,ff):
    def dec(cls):
        setattr(cls,funz,getattr(classe,ff))
        return cls
    return dec

class ClasseOnFF:
    def ff(self):
        print("cipolle")

    def pippo(self):
        print("daefsdg")

@decora(ClasseOnFF,"ciao","pippo")
class Class1:
    pass

x=Class1()
x.ciao()

