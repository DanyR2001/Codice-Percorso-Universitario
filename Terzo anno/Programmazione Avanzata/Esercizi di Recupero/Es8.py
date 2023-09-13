
"""
    Scrivere una classe che contiene un metodo che restituisce il numero di invocazioni degli altri metodi della classe.
    Il codice dei suddetti metodi non deve essere modificato.
"""
import types

def decorator(cls):
    funzioni=[nome for nome in vars(cls) if isinstance(cls.__dict__[nome],types.FunctionType) or isinstance(cls.__dict__[nome],staticmethod) and nome!="getNumInv"]

    setattr(cls,"counter",0)

    @classmethod
    def getNumInv(cls):
        return cls.counter

    setattr(cls, "getNumInv", getNumInv)

    def overwrite(key):
        oldMet=cls.__dict__[key]
        def newMetord(*args,**kwargs):
            count=getattr(cls,"counter")
            count+=1
            setattr(cls,"counter",count)
            return oldMet(*args,**kwargs)
        setattr(cls,key,newMetord)

    for key in funzioni:
        overwrite(key)

    return cls

@decorator
class ContaNumeroMetodi:

    def __init__(self):
        pass

    def ciao(self):
        print("ciao")

    def miao(self):
        print("ciao")

if __name__=="__main__":
    x=ContaNumeroMetodi()
    x.ciao()
    x.ciao()
    x.miao()
    x.ciao()
    x.miao()
    print(ContaNumeroMetodi.getNumInv())