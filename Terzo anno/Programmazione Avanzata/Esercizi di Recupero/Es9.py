

def decora(funz):
    def dec(cls):
        count = 0
        setattr(cls, "count", count)
        oldfunc=getattr(cls,funz)
        def newFunc(self,*args,**karg):
            x=getattr(cls,"count")
            x += 1
            setattr(cls,"count",x)
            oldfunc(self,*args,*karg)
        setattr(cls,oldfunc.__name__,newFunc)
        def getCount():
            return getattr(cls,"count")
        setattr(cls,"getCount",getCount)
        return cls
    return dec

@decora("marco")
class Mario:

    def marco(self):
        print("ciao")


if "__main__"==__name__:
    x=Mario()
    x.marco()
    x.marco()
    print(x.__class__.getCount())