import abc
import functools


def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator
    return wrapper

@coroutine
def handler_eq(successor=None):
    while True:
        parola, carattere=yield
        if len(parola)>0 and parola[0].isalpha() and parola[0]== carattere:
            print("Richiesta {} gestita da handler_eq".format(parola))
        elif successor is not None:
            successor.send((parola, carattere))

@coroutine
def handler_diff(successor=None):
    while True:
        parola, carattere=yield
        if len(parola)>0 and parola[0].isalpha() and parola[0]!=carattere:
            print("Richiesta {} gestita da handler_diff: richiesta modificata".format(parola))
            new_handler = handler_eq(handler_diff(handler_digit(DefaultHandler(None))))
            new_handler.send((parola[1:],carattere))
        elif successor is not None:
            successor.send((parola, carattere))

@coroutine
def handler_digit(successor=None):
    while True:
        parola, carattere=yield
        if len(parola)>0 and parola[0].isdigit():
            print("Richiesta {} gestita da handler_digit".format(parola))
        elif successor is not None:
            successor.send((parola, carattere))

@coroutine
def DefaultHandler(successor=None):
    while True:
        parola, carattere=yield
        if len(parola)>0 and not parola[0].isdigit() and not parola[0].isalpha():
            print("Messaggio da DefaultHandler: non è stato possibile gestire la richiesta {}".format(parola))
        elif successor is not None:
            successor.send((parola, carattere))


class Client:



    def entrust(self,listStringhe:list,listaCaratteri:list):
        self.henler=handler_eq(handler_diff(handler_digit(DefaultHandler(None))))
        for (parola,lettera) in zip(listStringhe,listaCaratteri):
            self.henler.send((parola,lettera))
        self.henler.close()

if __name__=="__main__":
    x=Client()
    l1=["sasso","sasso","0masso","@fracasso"]
    l2=["s","a","b","c"]
    x.entrust(l1,l2)