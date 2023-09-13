
"""
    Scrivere una classe di base ClsBase in cui c’e` un metodo addAttr che
    • prende in input due argomenti: una stringa s e un valore v,
    • controlla se la classe ha l’attributo di nome s e se tale attributo non e` presente allora aggiunge alla
        classe l’attributo s con valore v; in caso contrario non fa niente.
    • Il metodo deve funzionare anche per le eventuali sottoclassi di ClsBase
"""

class ClsBase:

    def __init__(self):
        pass

    def addAttr(self, s, v):
        if s not in vars(self.__class__):
            setattr(self.__class__, s, v)

class ClsSubClass(ClsBase):
    pass

if __name__ == "__main__":
    x = ClsBase()
    print(vars(x.__class__))
    x.addAttr("cipolle", 4)
    print(vars(x.__class__))
    y=ClsSubClass()
    print(vars(y.__class__))
    y.addAttr("cipolle", 4)
    print(vars(y.__class__))
