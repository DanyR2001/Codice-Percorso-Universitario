import functools


def coroutine(function):
    @functools.wraps(function)
    def wrap(*args,**kwargs):
        gen=function(*args,**kwargs)
        next(gen)
        return gen
    return wrap

@coroutine
def gestore_ag(recever=None):
    flag=True
    try:
        while flag:
            stringa=yield
            if stringa is not None:
                if stringa[0] >= 'a' and  stringa[0] <= 'g' :
                    print("“Richiesta {} gestita da gestore_ag".format(stringa))
                else:
                    if recever is not None:
                        try:
                            recever.send(stringa)
                        except Exception:
                            print("Il successore di {} ha smesso di funzionare a causa della richiesta {} e di conseguenza smette di funzionare anche {}".format("gestore_ag",stringa,"gestore_ag"))
                            recever.close()
                            raise ValueError
    except Exception:
        print("catena chiusa")


@coroutine
def gestore_hn(recever=None):
    while True:
        stringa=yield
        if stringa is not None:
            if stringa[0] >= 'h' and  stringa[0] <= 'n' and stringa[0].isalpha():
                print("“Richiesta {} gestita da gestore_hn".format(stringa))
            else:
                if recever is not None:
                    try:
                        recever.send(stringa)
                    except Exception as err:
                        print("Il successore di {} ha smesso di funzionare a causa della richiesta {} e di conseguenza smette di funzionare anche {}".format(
                                "gestore_hn", stringa, "gestore_hn"))
                        recever.close()
                        raise ValueError

@coroutine
def gestore_distr(recever=None):
    try:
        while True:
            stringa = yield
            if stringa is not None:
                if not stringa[0].isalpha():
                    print("Richiesta {} gestita da gestore_distr: uso improprio della catena di gestori".format(stringa))
                    if recever is not None:
                        recever.close()
                    raise ValueError()
                else:
                    recever.send(stringa)
    except Exception:
        print("124")

@coroutine
def gestoreDiDefault(recever=None):
    try:
        while True:
            stringa = yield
            if stringa is not None:
                print("Messaggio da gestoreDiDefault: non è stato possibile gestire la richiesta {} ".format(stringa))
            if recever is not None:
                recever.send(stringa)
    except Exception:
        print("gGAGDS")


class Test:

    '''Client: Uses handlers'''

    def __init__(self):
        self.handler = gestore_ag(gestore_hn(gestore_distr(gestoreDiDefault(None))))

    def delegate(self, requests):
        for request in requests:
            self.handler.send(request)
        self.handler.close()

if "__main__"==__name__:
    x=Test()
    y=list()
    y.append("appia")
    y.append("halloween")
    y.append("zorro")
    y.append("ABACO")
    y.append("123stella")
    y.append("mazzo")
    y.append("zorro")
    x.delegate(y)
