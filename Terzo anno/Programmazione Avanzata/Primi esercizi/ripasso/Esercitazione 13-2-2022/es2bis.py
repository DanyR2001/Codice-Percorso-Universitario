import inspect
from datetime import date
import copy
import itertools
import random


class ProdottoOsservato:
    M = "altamente disponibile"
    D = "disponibile"
    E = "non disponibile"

    MAXSCORTE = 1000
    MAXORDINE = 350

    def __init__(self, nome):
        self._observers=set()
        self.nome = nome
        self.quantita = 0
        self.stato_scorte = ProdottoOsservato.E
        self._acquirenti = dict()


    @property
    def stato_scorte(self):
        return self._stato_scorte

    @stato_scorte.setter
    def stato_scorte(self, value):
        if value == ProdottoOsservato.M:
            self.immagazzina = lambda *args: print("non puoi acquistare altri prodotti")
            self.vendi = self._vendi
        elif value == ProdottoOsservato.D:
            self.immagazzina = self._immagazzina
            self.vendi = self._vendi
        elif value == ProdottoOsservato.E:
            self.immagazzina = self._immagazzina
            self.vendi = lambda *args: print("non puoi vendere altri prodotti")
        self._stato_scorte = value
        self.observers_notify("stato_scorte")

    def observers_add(self, observer, *observers):
        for observer in itertools.chain((observer,), observers):
            self._observers.add(observer)
            # Decidere voi cosa passare ad update (al posto dei puntini)
            observer.update(self)

    def observer_discard(self, observer):
        self._observers.discard(observer)

    # completare questo metodo che notifica un cambio stato agli ossservatori invocando il metodo update dell'osservatore
    def observers_notify(self):
        for observer in self._observers:
            observer.update(self)

    def aggiorna(self, nome, numero, data):
        self._acquirenti[nome]=(numero,data)
        self.observers_notify()

    def _vendi(self, nomeAcquirente, numero):
        if numero > ProdottoOsservato.MAXORDINE or numero > self.quantita:
            print("Attenzione: vendita di {} unita` del prodotto {} non possibile".format(numero, self.nome))
            return
        else:
            self.quantita = self.quantita - numero
            self.aggiorna(nomeAcquirente, numero, date.today())
            if self.quantita == 0:
                self.stato_scorte = ProdottoOsservato.E
            if 0 < self.quantita < ProdottoOsservato.MAXSCORTE:
                self.stato_scorte = ProdottoOsservato.D

    def _immagazzina(self, numero):
        if numero <= 0:
            return
        self.quantita = self.quantita + numero
        if 0 < self.quantita < ProdottoOsservato.MAXSCORTE:
            self.stato_scorte = ProdottoOsservato.D
        if self.quantita == ProdottoOsservato.MAXSCORTE:
            self.stato_scorte = ProdottoOsservato.M

    # serve per il test in esercizio1.py se usate questa classe anche nell'esercizio 1
    def elimina_scorte(self):
        self.quantita = 0
        self.stato_scorte = ProdottoOsservato.E


# completare le due seguenti classi
class Grossista:

    def __init__(self, nome: str, listaprodotti: list):
        self.nome = nome
        self.prodotti = list()
        for p in listaprodotti:
            self.prodotti.append(p)

    # metodo update: AGGIUNGETE VOI UNO O PIU` PARAMETRI AL POSTO DEI PUNTINI
    def update(self, Prodotto=None):
        funzioneChiamante=inspect.stack()[3].function
        funzioneChiamata=inspect.stack()[2].function
        print(funzioneChiamante,funzioneChiamata)
        if funzioneChiamante=="_vendi":
            print("Nuova vendita del prodotto {}: quantita` disponibile = {}".format(Prodotto.nome,Prodotto.quantita))
            if Prodotto.quantita <= Prodotto.MAXSCORTE/3:
                print("Necessario approvvigionamento del prodotto {}".format(Prodotto.nome))
                Prodotto._immagazzina(Prodotto.MAXSCORTE-Prodotto.quantita)
        elif funzioneChiamante=="_immagazzina":
            print("Immagazzinata una nuova quantita` del prodotto {}: quantita` disponibile = {}".format(Prodotto.nome,Prodotto.quantita))

        if funzioneChiamata == "stato_scorte":
            print("Cambio dello stato delle scorte del prodotto {}: il prodotto ora e` nello stato {}".format(Prodotto.nome,Prodotto.stato_scorte))
        elif funzioneChiamata == "aggiorna":
            for prodotto in self.prodotti:
                if prodotto.nome == Prodotto.nome:
                    print(inspect.stack()[3])




class StoricoGrossista:
    def __init__(self):
        self.storico = []

    # metodo update: AGGIUNGETE VOI UNO O PIU` PARAMETRI AL POSTO DEI PUNTINI
    def update(self, Prodotto=None):
        caller = inspect.stack()[2][3]
        if caller == "vendi":
            self.storico.append("giorno {}:vendita del prodotto {}".format("prova",Prodotto.nome))
        elif caller == "immagazina":
            self.storico.append("giorno {}:immagazzinamento di una nuova quantita` del prodotto {}".format("prova",Prodotto.nome))

    def stampa_report(self):
        o = open("Report.txt", "a")
        for s in self.storico:
            o.write(s + "\n")
        o.close()


def main():
    p1 = ProdottoOsservato("Paperini")
    p2 = ProdottoOsservato("Nuterra")

    print("Inizialmente il prodotto {} e` nello stato {}".format(p1.nome, p1.stato_scorte))
    print("Inizialmente il prodotto {} e` nello stato {}\n".format(p2.nome, p2.stato_scorte))

    g = Grossista("GrossistaCampania", [p1, p2])
    gs = StoricoGrossista()

    for p in g.prodotti:
        p.observers_add(g, gs)
        p.immagazzina(ProdottoOsservato.MAXSCORTE)

    c = 0
    for p in g.prodotti:
        p.vendi("SupermarketSun", 310 + c)
        p.vendi("SupermarketLongS", 300 + c)
        p.vendi("SupermarketFoop", 160 + c)
        p.vendi("SupermarketPrai", 305 + c)
        p.vendi("SupermarketLongS", 330 + c)
        c += 10

    print("\n\nCreo un report")
    gs.stampa_report()


if __name__ == "__main__":
    main()

"""Il programma deve stampare:
Inizialmente il prodotto Paperini e` nello stato non disponibile
Inizialmente il prodotto Nuterra e` nello stato non disponibile

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
Necessario approvvigionamento del prodotto Paperini
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
Necessario approvvigionamento del prodotto Nuterra
Immagazzinata una nuova quantita` del prodotto Nuterra: quantita` disponibile = 1000
Cambio dello stato delle scorte del prodotto Nuterra: il prodotto ora e` nello stato altamente disponibile
Nuovo acquirente del prodotto Nuterra

Nuova vendita del prodotto Nuterra: quantita` disponibile = 685
Nuovo acquirente del prodotto Nuterra
Cambio dello stato delle scorte del prodotto Nuterra: il prodotto ora e` nello stato disponibile

Nuova vendita del prodotto Nuterra: quantita` disponibile = 345


Creo un report
"""

"""Il file Report contiene:

giorno 2019-12-16: immagazzinamento di una nuova quantita` del prodotto Paperini
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` altamente disponibile

giorno 2019-12-16: immagazzinamento di una nuova quantita` del prodotto Nuterra
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` altamente disponibile

giorno 2019-12-16: vendita del prodotto Paperini
La vendita e` effettuata ad un nuovo acquirente
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` disponibile

giorno 2019-12-16: vendita del prodotto Paperini
La vendita e` effettuata ad un nuovo acquirente

giorno 2019-12-16: vendita del prodotto Paperini

giorno 2019-12-16: immagazzinamento di una nuova quantita` del prodotto Paperini
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` altamente disponibile
La vendita e` effettuata ad un nuovo acquirente

giorno 2019-12-16: vendita del prodotto Paperini
La vendita e` effettuata ad un nuovo acquirente
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` disponibile

giorno 2019-12-16: vendita del prodotto Paperini

giorno 2019-12-16: vendita del prodotto Nuterra
La vendita e` effettuata ad un nuovo acquirente
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` disponibile

giorno 2019-12-16: vendita del prodotto Nuterra
La vendita e` effettuata ad un nuovo acquirente

giorno 2019-12-16: vendita del prodotto Nuterra

giorno 2019-12-16: immagazzinamento di una nuova quantita` del prodotto Nuterra
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` altamente disponibile
La vendita e` effettuata ad un nuovo acquirente

giorno 2019-12-16: vendita del prodotto Nuterra
La vendita e` effettuata ad un nuovo acquirente
c'e` stato  un cambio stato delle scorte del prodotto: il nuovo stato e` disponibile

giorno 2019-12-16: vendita del prodotto Nuterra
"""






