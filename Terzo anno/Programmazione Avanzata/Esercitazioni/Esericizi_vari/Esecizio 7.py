import datetime
import inspect
import itertools


class Observed:
    def __init__(self):
        self.__observers = set()

    def observers_add(self, observer, *observers):
        for observer in itertools.chain((observer,), observers):
            self.__observers.add(observer)
            observer.update(self)

    def observer_discard(self, observer):
        self.__observers.discard(observer)

    def observers_notify(self):
        for observer in self.__observers:
            observer.update(self)

class VistaStorica:

    def __init__(self):
        self.storia_vendite=list()
        self.andamento_vendite=list()

    def update(self,libro):
        if libro is not None:
            self.storia_vendite.append((libro.nome,libro.numero_copie,datetime.datetime.now()))
            if libro.alta_progressione == True:
                self.andamento_vendite.append("Cambio stato: con l'ultimo acquisto, il libro {},ha piu` che raddoppiato le vendite".format(
                    libro.nome))
            else:
                self.andamento_vendite.append("Cambio stato: con l'ultimo acquisto, le vendite di {} sono aumentate meno della meta".format(
                    libro.nome))

    def storia(self):
        returnment=list()
        for tripla,progressione in zip(self.storia_vendite,self.andamento_vendite):
            returnment.append((tripla,progressione))
        return returnment

class VistaIst:

    def update(self, libro=None):
        if libro is not None:
            print("Cambio stato:nuove vendite del libro {}".format(libro.numero_copie))
            if libro.alta_progressione == True:
                print("Cambio stato: con l'ultimo acquisto, il libro {},ha piu` che raddoppiato le vendite".format(libro.nome))
            else:
                print("Cambio stato: con l'ultimo acquisto, le vendite di {} sono aumentate meno della meta".format(libro.nome))

class Riferimenti(dict):

    def __setitem__(self, key, value):
        raise RuntimeError

    def settaEle(self,key,value):
        super(Riferimenti,self).__setitem__(key,value)

class Libro(Observed):

    def __init__(self,nome,lista:list):
        super().__init__()
        self.nome=nome
        self.riferimenti=Riferimenti()
        for i in range(len(lista)):
            self.riferimenti.settaEle(i,lista[i])
        self._numero_copie=0
        self._alta_progressione=False



    @property
    def numero_copie(self):
        return self._numero_copie

    @numero_copie.setter
    def numero_copie(self,value):
        if value >= self._numero_copie*2:
            flag=True
        else:
            flag=False
        self._numero_copie=value
        self.alta_progressione=flag
        self.observers_notify()

    @property
    def alta_progressione(self):
        return self._alta_progressione

    @alta_progressione.setter
    def alta_progressione(self,value):
        self._alta_progressione=value






if __name__=="__main__":
    l=["ciao","miao"]
    x=Libro("sasso",l)
    Vi=VistaIst()
    Vs=VistaStorica()
    x.observers_add(Vi,Vs)
    x.numero_copie=10
    x.numero_copie=30
    x.numero_copie=1
    print(Vs.storia())







