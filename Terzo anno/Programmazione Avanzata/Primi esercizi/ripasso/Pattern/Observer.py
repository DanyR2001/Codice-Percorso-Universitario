import collections
import copy
import datetime
import itertools
import numbers
import sys
import types

Exam = collections.namedtuple("Exam", "name cfu")


class HistoryView:

    def __init__(self):
        self.lista=list()

    def update(self,studente):
        self.lista.append((copy.deepcopy(studente.grade),copy.deepcopy(studente.english_r),copy.deepcopy(datetime.datetime.now())))



class LiveView:

    def __init__(self):
        self._studente=None

    def update(self,studente):
        if self._studente is not None:
            if self._studente.grade!= studente.grade:
                print("Cambio stato: lo studente ha superato un nuovo esame")
            if self._studente.total_cfu!= studente.total_cfu:
                print("Cambio stato: il numero di CFU e` : " , studente.total_cfu,"\n")
            if self._studente.english_r != studente.english_r:
                print("Cambio stato: lo studente ha appena superato la prova di Inglese\n")
        self._studente=copy.deepcopy(studente)




def main():
    historyView = HistoryView()
    liveView = LiveView()
    student = LaureaT_Student(0)
    student.observers_add(historyView, liveView)
    print("Lo studente sta per superare analisi matematica")
    student.add_grade(Exam("analisi matematica", 9), 28)
    print("Lo studente sta per superare asistemi operativi")
    student.add_grade(Exam("sistemi operativi", 6), 20)
    print("Lo studente sta per superare la prova di Inglese")
    student.english_r = True

    for grades, flag, timestamp in historyView.lista:
        print("Esami: {}, Inglese: {}, Data: {}".format(grades,
                                                        " " if flag == None else "superato" if flag else "non superato",
                                                        timestamp, file=sys.stderr))


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

class LaureaT_Student(Observed):

    def __init__(self,num=0,flag=False):
        super().__init__()
        self.total_cfu=num
        self.english_r=flag
        self.grade=dict()

    @property
    def total_cfu(self):
        return self._total_cfu

    @total_cfu.setter
    def total_cfu(self,value):
        assert isinstance(value,int) and value>=0
        self._total_cfu=value
        self.observers_notify()

    @property
    def english_r(self):
        return self._english_r

    @english_r.setter
    def english_r(self, value):
        assert isinstance(value, bool)
        self._english_r=value
        self.observers_notify()




    def add_grade(self,exam,vote):
        if isinstance(exam,Exam) and isinstance(vote,numbers.Number):
            if vote in range(18,31):
                self.grade[exam]=vote
                self._total_cfu+=exam.cfu
        self.observers_notify()


if __name__=="__main__":
    main()



"""
• Scrivere una classe LaureaT_Student che puo` essere osservata e che ha i seguenti attributi che ne determinano lo stato:
• total_cfu : numero cfu acquisiti
• english_r: booleano settato a False (valore di default) se e solo se lo studente non ha superato la prova di inglese
• grades: dizionario degli esami sostenuti con elementi con chiave uguale al nome dell’esame e valore uguale al voto (exam name, grade)
• exam e` una tupla del tipo definito in basso
• Exam=collections.namedtuple("Exam", "name cfu")
• Gli attributi total_cfu e english_r sono accessibili con il loro nome e modificabili con ‘=‘ mentre grades e` modificabile con il metodo add_grades che prende in input come primo argomento un oggetto Exam e come secondo argomento un int che rappresenta il voto
"""


"""
Il programma stampa:

Lo studente sta per superare analisi matematica
Cambio stato: lo studente ha superato un nuovo esame
Cambio stato: il numero di CFU e` :  9

Lo studente sta per superare a sistemi operativi
Cambio stato: lo studente ha superato un nuovo esame
Cambio stato: il numero di CFU e` :  15

Lo studente sta per superare la prova di Inglese
Cambio stato: lo studente ha appena superato la prova di Inglese

Esami: {}, Inglese: non superato, Data: 2022-11-21 22:26:12.713307
Esami: {'analisi matematica': 28}, Inglese: non superato, Data: 2022-11-21 22:26:12.756684
Esami: {'analisi matematica': 28}, Inglese: non superato, Data: 2022-11-21 22:26:12.889491
Esami: {'analisi matematica': 28, 'sistemi operativi': 20}, Inglese: non superato, Data: 2022-11-21 22:26:12.923176
Esami: {'analisi matematica': 28, 'sistemi operativi': 20}, Inglese: non superato, Data: 2022-11-21 22:26:13.075015
Esami: {'analisi matematica': 28, 'sistemi operativi': 20}, Inglese: superato, Data: 2022-11-21 22:26:13.107723

"""
