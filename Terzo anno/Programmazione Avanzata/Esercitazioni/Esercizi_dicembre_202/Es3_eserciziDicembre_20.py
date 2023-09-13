import types


class tale:

    _shared_state={"nome":None,"cognome":None,"eta":None}

    def __new__(cls, *args, **kwargs):
        obj=super().__new__(cls,*args,**kwargs)
        super().__setattr__(obj,"__dict__",cls._shared_state)
        return obj

    def __setattr__(self, key, value):
        if key not in self._shared_state:
            raise AttributeError("{} non è ammissibile nello stato".format(key))
        else:
            super().__setattr__(key,value)

if "__main__"==__name__:
    x=tale()
    y=tale()
    z=tale()
    print(vars(x),dir(x))
    x.nome="marco"
    y.cognome="russo"
    z.eta=12
    print(vars(x),dir(x))
    print(vars(y))
    print(vars(z))
    print(y.nome)
    print(z.cognome)
    print(x.eta)
    x.cipolla="vjsd"