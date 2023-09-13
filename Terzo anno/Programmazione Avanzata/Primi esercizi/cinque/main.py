import functools


def dect(f):
    @functools.wraps(f)
    def wrapper(*args, **kwargs):
        if len(args) + len(kwargs) != 2:
            raise TypeError
        else:
            res = f(*args, **kwargs)
            if res != None:
                fp = open("risultato.txt", 'a')
                fp.write(str(res) + " ")
                if args:
                    fp.write(str(args[0]))
                else:
                    for x in kwargs:
                        fp.write(str(x))
                fp.write('\n')
                fp.close()
            return res
    return wrapper


@dect
def funct(primo,secondo,*args,**kwargs):
    if len(args) + len(kwargs) == 0:
        return primo+secondo
    return None


x = 5
y = 10
z = 12

print(funct(x,z))
