
def decFact(*argss,**kwargss):

    def decClas(cls):

        def setArgs(self,*args):
            for arg in args:
                setattr(self,arg,None)

        def setKwArgs(self,**kwargs):
            for key,value in kwargs.items():
                setattr(self,key,value)

        oldInit=getattr(cls,"__init__")
        def newInit(self,*args,**kwargs):
            setArgs(self,*argss)
            setKwArgs(self,**kwargss)
            return oldInit(self,*args,**kwargs)

        setattr(cls,"__init__",newInit)
        return cls
    return decClas

@decFact("ha","haha","hahaha",ciao=3,marco=5)
class classeBase:
    def __init__(self,**kwargs):
        for key,val in kwargs.items():
            setattr(self,key,val)

if "__main__"==__name__:
    x=classeBase(ciao="panino", marco = "marco")
    print(vars(x))




