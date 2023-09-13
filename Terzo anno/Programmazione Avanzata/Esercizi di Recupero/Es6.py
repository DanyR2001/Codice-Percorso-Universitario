
"""
• Scrivere un programma che stampa le seguenti stringhe utilizzando solo i metodi di Adapter e Lavoratore:
    • Il commesso Paolo vende abiti
    • Il musicista Veronica suona musica pop
    • Il cuoco Antonio cucina una lasagna
"""

from Es6_lib import *

class Adapter:
    def __init__(self, obj, adapted_methods):
        self.obj = obj
        self.__dict__.update(adapted_methods)

    def __str__(self):
        return str(self.obj)

class Lavoratore:
    def __init__(self, nome):
        self.nome= nome

    def __str__(self):
        return"il lavoratore {}".format(self.nome)

    def lavora(self,ogg):
        return"svolge il seguente {}".format(ogg)

if __name__=="__main__":
    obj=[]
    com=Commesso("Paolo")
    lavori=["abiti","pop","lasagna"]
    obj.append(Adapter(com,dict(lavora=com.vende)))
    mus = Musicista("Veronica")
    obj.append(Adapter(mus, dict(lavora=mus.suona)))
    cuo=Cuoco("Antonio")
    obj.append(Adapter(cuo,dict(lavora=cuo.cucina)))
    for index,i in enumerate(obj):
        print("{}{}".format(str(i),i.lavora(lavori[index])))