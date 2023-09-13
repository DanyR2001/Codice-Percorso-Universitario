
"""
    •Modificare la funzione al punto precedente in modo che la funzione decorata
    •operi su qualsiasi elemento della lista che puo`essere convertito in int
    •non lanci un’eccezione se un elemento della lista non puo`essere convertito a int
"""

import functools


def decorator(func):
    @functools.wraps(func)
    def wrapper(it,*args,**kwargs):
        li=list()
        for x in it:
            try:
                li.append(int(x))
            except:
                pass
        return func(*li)
    return wrapper

@decorator
def somma(*args):
    sum=0
    for x in args:
        sum+=x
    return sum

if __name__=="__main__":
    print(somma([3,1.5,"6","nonna"]))