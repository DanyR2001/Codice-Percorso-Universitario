
def decoratoreDiClasse(cls):

    def elencaVariabili(self):
        for key,value in vars(self).items():
            if isinstance(value,int):
                yield key

    setattr(cls,"elencaVariabili",elencaVariabili)
    return cls

def decoratorFactory(type):
    def decoratoreDiClasse(cls):
        def elencaVariabili(self):
            for key, value in vars(self).items():
                if isinstance(value, type):
                    yield key

        setattr(cls, "elencaVariabili", elencaVariabili)
        return cls
    return decoratoreDiClasse

@decoratorFactory(str)
class ciao:

    def __init__(self):
        self.ciao=1
        self.mario="pappagogia"
        self.raffaella=3

if "__main__"==__name__:
    x=ciao()
    iter=x.elencaVariabili()
    while True:
        try:
            print(next(iter))
        except Exception as e:
            print("fold")
            break
    x.padrepio=3
    iter = x.elencaVariabili()
    while True:
        try:
            print(next(iter))
        except Exception as e:
            print("fold")
            break

