
"""
    Definire un decoratore di funzione che trasforma una funzione che prende in input un numero variabile
    di numeri in una funzione che prende in input una lista e opera solo sugli elementi della lista
    di tipo float, inte strconvertiti in int.

    •la funzione somma non decorata viene invocata in questo modo:somma(3.5, 6, 1.2)
    •se usiamo il decoratore, possiamo invocare somma([1.3, 4 ,"6"])
"""

import functools


def decorator(func):
    @functools.wraps(func)
    def wrapper(it,*args,**kwargs):
        li=list()
        print("o")
        for x in it:
            print("sa",type(x))
            if type(x) == str:
                print("srt")
                tmp=int(x)
                li.append(tmp)
            elif type(x) == int or type(x) == float:
                print("int o float")
                li.append(x)
        return func(*li)
    return wrapper


@decorator
def somma(*args):
    sum=0
    for x in args:
        sum+=x
    return sum


if __name__=="__main__":
    print(somma([3,1.5,"6"]))