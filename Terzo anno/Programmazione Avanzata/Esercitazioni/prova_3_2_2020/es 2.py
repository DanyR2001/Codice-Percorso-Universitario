import functools
import sys


def corutine(function):
    @functools.wraps(function)
    def wrap(*args, **kwargs):
        generator=function(*args,**kwargs)
        next(generator)
        return generator
    return wrap

@corutine
def gestore_int(recever=None,succesor=None):
    while True:
        event=yield
        if(isinstance(event,int)):
            print("Richiesta gestita da gestore_int")
            if recever is not None:
                recever.send((event,"file_int"))
        elif succesor is not None:
            succesor.send(event)

@corutine
def gestore_str(recever=None,succesor=None):
    while True:
        event=yield
        if(isinstance(event,str)):
            print("Richiesta gestita da gestore_str")
            if recever is not None:
                recever.send((event,"file_str"))
        elif succesor is not None:
            succesor.send(event)

@corutine
def gestoreDiDefault(succesor=None):
    while True:
        event=yield
        print("Messaggio da gestoreDiDefault: non e` stato possibile gestire la richiesta {}".format(event))
        if succesor is not None:
            succesor.send(event)

@corutine
def gestore_tuple(succesor=None):
    while True:
        event=yield
        if isinstance(event,tuple):
            if event[0] in sys.modules[__name__].__dict__:
                y=sys.modules[__name__].__dict__[event[0]](event[1:])
                x=eval("{}({})".format(event[0],event[1:]))
                print("Richiesta gestita da gestore_tuple: e` stata creata un’istanza della classe {} con i seguenti attributi {}".format(x.__class__,x.__dict__))
                print("Richiesta gestita da gestore_tuple: e` stata creata un’istanza della classe {} con i seguenti attributi {}".format(y.__class__, y.__dict__))
            else:
                print("Richiesta gestita da gestore_tuple: istanza non creata perche’ il primo elemento della tupla non e` una classe definita nel modulo esercizio2.py")
        elif succesor is not None:
            succesor.send(event)


@corutine
def writeInFile():
    while True:
        event=yield
        fp=open(event[1],"a")
        toWrite=str(event[0])+"\n"
        fp.write(toWrite)
        fp.close()

class file:

    '''Client: Uses handlers'''

    def __init__(self):
        self.handler = gestore_int(writeInFile(),gestore_str(writeInFile(),gestore_tuple(gestoreDiDefault(None))))

    def delegate(self, requests):
        '''Iterates over requests and sends them, one by one, to handlers as per sequence of handlers defined above.'''
        for request in requests:
            self.handler.send(request)
        self.handler.close()

class Panino:

    def __init__(self,marco):
        self.name=marco
        print("classe",marco)

# Create a client object
fil = file()

# Create richieste to be processed.
richieste = []

richieste.append(3)
richieste.append("a")
richieste.append(5)
richieste.append(("Panino","ciao"))
fil.delegate(richieste)
