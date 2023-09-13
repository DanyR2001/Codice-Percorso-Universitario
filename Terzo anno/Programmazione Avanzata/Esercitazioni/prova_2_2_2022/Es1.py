import functools
import numbers


def corutine(function):
    @functools.wraps(function)
    def wrap(*args,**kwargs):
        gen=function(*args,**kwargs)
        next(gen)
        return gen
    return wrap

@corutine
def gestore_0_100(successor=None):
    flag=True
    while True:
        number = yield
        if flag:
            if isinstance(number,numbers.Number):
                if number in range(0,101):
                    print("Richiesta {} gestita da gestore_0_100".format(number))
                elif successor is not None:
                    try:
                        successor.send(number)
                    except StopIteration:
                        if flag:
                            flag=False
                        else:
                            print("il successivo gestore per la richiesta {} è spento mi spengo anchio".format(number))
                            break
            else:
                raise ValueError("La richiesta {} non è un numero".format(number))
        else:
            print("\n")


@corutine
def gestore_101_200(successor=None):
    flag=True
    while True:
        number = yield
        if isinstance(number,numbers.Number):
            if number in range(101,201):
                print("Richiesta {} gestita da gestore_101_200".format(number))
            elif successor is not None:
                try:
                    successor.send(number)
                except StopIteration as err:
                    if flag:
                        flag=False
                    else:
                        print("il successivo gestore per la richiesta {} è spento mi spengo anchio".format(number))
                        break
        else:
            raise ValueError("La richiesta {} non è un numero".format(number))

@corutine
def gestore_negativo(successor=None):
    while True:
        number = yield
        if isinstance(number,numbers.Number):
            if number < 0:
                print("Richiesta {} gestita da gestore_negativo: la catena smette di funzionare".format(number))
                if successor is not None:
                    successor.close()
                break
            elif successor is not None:
                try:
                    successor.send(number)
                except StopIteration:
                    successor.close()
        else:
            raise ValueError("La richiesta {} non è un numero".format(number))

@corutine
def gestoreDiDefault(successor=None):
    while True:
        number = yield
        if isinstance(number,numbers.Number):
            if number > 200:
                print("Messaggio da gestoreDiDefault: non e` stato possibile gestire la richiesta {}".format(number))
            elif successor is not None:
                successor.send(number)
        else:
            raise ValueError("La richiesta {} non è un numero".format(number))

class Test:

    '''Client: Uses handlers'''

    def __init__(self):
        self.handler = gestore_0_100(gestore_101_200(gestore_negativo(gestoreDiDefault(None))))

    def delegate(self, requests):
        for request in requests:
            self.handler.send(request)
        self.handler.close()

if "__main__"==__name__:
    x=Test()
    y=list()
    y.append(10)
    y.append(150)
    y.append(210)
    y.append(-4)
    y.append(10)
    y.append(150)
    y.append(210)
    y.append(10)
    y.append(150)
    y.append(210)
    x.delegate(y)
