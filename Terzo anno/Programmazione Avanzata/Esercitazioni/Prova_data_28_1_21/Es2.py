import functools


def myDecoratorFact(n):

    def decora(funz):
        @functools.wraps(funz)
        def wrapper(*args,**kwargs):
            if len(args)+len(kwargs)!=n:
                raise TypeError
            return funz(*args,**kwargs)
        return wrapper
    return decora

class x:

    @myDecoratorFact(5)
    def banana(self,*args,**kwargs):
        print("cipolle",args,kwargs)


if "__main__"==__name__:
    ist=x()
    x.banana("hahha",2,pes="3",cas=4,maio=5)