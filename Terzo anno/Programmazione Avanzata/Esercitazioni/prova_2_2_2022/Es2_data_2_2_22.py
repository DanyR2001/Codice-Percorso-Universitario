import inspect


def decoraCLasse(cls):



    oldInit=getattr(cls,"__init__")


    def newInit(self,*args,**kwargs):
        cls._args=args
        cls._kwargs=kwargs
        return oldInit(self,*args,**kwargs)

    setattr(cls,"__init__",newInit)



    def conQualiArgomenti(self):
        return (self.__class__._args,self.__class__._kwargs)

    setattr(cls,"conQualiArgomenti",conQualiArgomenti)
    return cls

@decoraCLasse
class ClasseBase:

    x=5
    t="10"

    def __init__(self,*args,**kwargs):
        pass

if __name__=="__main__":
    x=ClasseBase(1,2,4)
    print(x.conQualiArgomenti())
    y=ClasseBase(panino=1,pannolino=2)
    print(x.conQualiArgomenti())
    z=ClasseBase(1,2,4,panino=1,pannolino=2)
    print(x.conQualiArgomenti())
