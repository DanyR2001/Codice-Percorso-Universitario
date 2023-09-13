import functools


def decora(f):
    @functools.wraps(f)
    def wrapper(*args,**kwargs):
        if len(kwargs)==0:
            result=""
            for arg in args:
                if type(arg) == str:
                    result+=arg+" "
                else:
                    raise TypeError
            res=f(*arg,**kwargs)
            result+=str(res)
            return result
        else:
            raise TypeError
    return wrapper

@decora
def campana(*args):
    counter=0
    for arg in args:
        if arg.count('a')>0:
            counter+=arg.count("a")
    return counter

print(campana("i","massimo","belli","marco","ciao"))
