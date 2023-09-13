import functools


from Es2 import ProdottoOsservato


def coroutine(function):
    @functools.wraps(function)
    def wrap(*args, **kwargs):
        generator=function(*args,**kwargs)
        next(generator)
        return generator
    return wrap


@coroutine
def gestore_ven(succesor=None):
    while True:
        Prodotto,name= yield
        if name is not None:
            if name == "vendi":
                print("Nuova vendita del prodotto {}: quantita` disponibile = {}".format(Prodotto.nome,Prodotto.quantita))
                if Prodotto.quantita <= Prodotto.MAXSCORTE / 3:
                    print("Necessario approvvigionamento del prodotto {}".format(Prodotto.nome))
                    Prodotto._immagazzina(Prodotto.MAXSCORTE - Prodotto.quantita)
            else:
                if succesor is not None:
                    succesor.send((Prodotto,name))



@coroutine
def gestore_imm(succesor=None):
    while True:
        Prodotto, name = yield
        if name is not None:
            if name == "immagazzina":
                print("Immagazzinata una nuova quantita` del prodotto {}: quantita` disponibile = {}".format(Prodotto.nome,Prodotto.quantita))
            else:
                if succesor is not None:
                    succesor.send((Prodotto, name))


@coroutine
def gestore_ss(succesor=None):
    while True:
        Prodotto, name = yield
        if name is not None:
            if name == "stato_scorte":
                print("Cambio dello stato delle scorte del prodotto {}: il prodotto ora e` nello stato {}".format(Prodotto.nome, Prodotto.stato_scorte))
            else:
                if succesor is not None:
                    succesor.send((Prodotto, name))


@coroutine
def gestore_na(succesor=None):
    while True:
        Prodotto, name = yield
        if name is not None:
            if name == "aggiorna":
                print("Nuovo acquirente del prodotto {}".format(Prodotto.nome))
            else:
                if succesor is not None:
                    succesor.send((Prodotto, name))

@coroutine
def gestoreDiDefault(successor=None):
    while True:
        Prodotto, name = yield
        if name is not None:
            if successor is None:
                print(".")

class Grossista:

    def __init__(self, nome: str, listaprodotti: list):
        self.nome = nome
        self.prodotti = list()
        for p in listaprodotti:
            self.prodotti.append(p)

    def update(self, prodotto, s):
        self.handler = gestore_ven(gestore_imm(gestore_ss(gestore_na(gestoreDiDefault(None)))))
        self.delegate(s, prodotto)

    # completare questo metodo che invia al gestore la richiesta e prima di uscire invoca ...
    def delegate(self, s, prodotto):
        self.handler.send((prodotto,s))






def main():
    p1 = ProdottoOsservato("Paperini")
    p2 = ProdottoOsservato("Nuterra")

    g = Grossista("GrossistaCampania", [p1, p2])

    for p in g.prodotti:
        p.observers_add(g)
        p.immagazzina(ProdottoOsservato.MAXSCORTE)

    c = 0
    for p in g.prodotti:
        p.vendi("SupermarketSun", 310 + c)
        p.vendi("SupermarketLongS", 300 + c)
        p.vendi("SupermarketFoop", 160 + c)
        p.vendi("SupermarketPrai", 305 + c)
        p.vendi("SupermarketLongS", 330 + c)
        c += 10


if __name__ == "__main__":
    main()

"""Il programma deve stampare:

Immagazzinata una nuova quantita` del prodotto Paperini: quantita` disponibile = 1000
Cambio dello stato delle scorte del prodotto Paperini: il prodotto ora e` nello stato altamente disponibile

Immagazzinata una nuova quantita` del prodotto Nuterra: quantita` disponibile = 1000
Cambio dello stato delle scorte del prodotto Nuterra: il prodotto ora e` nello stato altamente disponibile

Nuova vendita del prodotto Paperini: quantita` disponibile = 690
Nuovo acquirente del prodotto Paperini
Cambio dello stato delle scorte del prodotto Paperini: il prodotto ora e` nello stato disponibile

Nuova vendita del prodotto Paperini: quantita` disponibile = 390
Nuovo acquirente del prodotto Paperini

Nuova vendita del prodotto Paperini: quantita` disponibile = 230
Necessario aprovvigionamento del prodotto Paperini
Immagazzinata una nuova quantita` del prodotto Paperini: quantita` disponibile = 1000
Cambio dello stato delle scorte del prodotto Paperini: il prodotto ora e` nello stato altamente disponibile
Nuovo acquirente del prodotto Paperini

Nuova vendita del prodotto Paperini: quantita` disponibile = 695
Nuovo acquirente del prodotto Paperini
Cambio dello stato delle scorte del prodotto Paperini: il prodotto ora e` nello stato disponibile

Nuova vendita del prodotto Paperini: quantita` disponibile = 365

Nuova vendita del prodotto Nuterra: quantita` disponibile = 680
Nuovo acquirente del prodotto Nuterra
Cambio dello stato delle scorte del prodotto Nuterra: il prodotto ora e` nello stato disponibile

Nuova vendita del prodotto Nuterra: quantita` disponibile = 370
Nuovo acquirente del prodotto Nuterra

Nuova vendita del prodotto Nuterra: quantita` disponibile = 200
Necessario aprovvigionamento del prodotto Nuterra
Immagazzinata una nuova quantita` del prodotto Nuterra: quantita` disponibile = 1000
Cambio dello stato delle scorte del prodotto Nuterra: il prodotto ora e` nello stato altamente disponibile
Nuovo acquirente del prodotto Nuterra

Nuova vendita del prodotto Nuterra: quantita` disponibile = 685
Nuovo acquirente del prodotto Nuterra
Cambio dello stato delle scorte del prodotto Nuterra: il prodotto ora e` nello stato disponibile

Nuova vendita del prodotto Nuterra: quantita` disponibile = 345
"""