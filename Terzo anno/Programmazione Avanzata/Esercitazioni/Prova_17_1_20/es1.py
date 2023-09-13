import functools
import re


def corutine(function):
    @functools.wraps(function)
    def wrap(*args,**kwargs):
        gen=function(*args,**kwargs)
        next(gen)
        return gen
    return wrap

@corutine
def searcher(c1,c2,receiver1, receiver2):
    Flag=True
    stop1 = stop2 = True
    try:
        while Flag:
            name = yield
            try:
                fp=open(name,"r")
                for word in fp:
                    print(word)
                    if word.startswith(c1):
                        try:
                            receiver1.send(word.replace("\n",""))
                        except StopIteration:
                            stop1=False
                    elif word.startswith(c2):
                        try:
                            stop2=receiver2.send(word.replace("\n",""))
                        except StopIteration:
                            stop2=False
                    Flag=stop2 or stop1
                    if not Flag:
                        break
                    print(Flag, stop2, stop1)
            except FileNotFoundError as error:
                print("Il file {} e` inesistente".format(name))
    except StopIteration:
        print("Nel file {} sono contenute entrabe le parole di stop".format(name))
    print(Flag,stop2,stop1)

@corutine
def listCreator(stop=None):
    lis=list()
    while True:
        name = yield
        lis.append(name)
        print(lis)
        if stop is not None:
            if stop==name:
                return False
class Test:

    def __init__(self):
        self.handler=searcher("ma","mi",listCreator("mami"),listCreator("mimo"))

    def delegate(self, requests):
        for request in requests:
            self.handler.send(request)
        self.handler.close()

tests = Test()

# Create richieste to be processed.
richieste = []

richieste.append("mario.txt")
richieste.append("massimo")
tests.delegate(richieste)