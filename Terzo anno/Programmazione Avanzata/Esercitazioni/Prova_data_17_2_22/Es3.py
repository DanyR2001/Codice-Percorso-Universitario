
class ClDaProteggere:

    def leggi(self):
        return "leggi"

    def scriviA(self):
        return "scriviA"

    def scriviB(self):
        return "scriviB"

class ProteggiClasse:

    def __init__(self,*args):
        self._proxy=ClDaProteggere()
        self._methodToAcc=args

    def __getattr__(self, item):
        if item not in self._methodToAcc:
            raise AttributeError("il metodo non puo essere invocato")
        else:
            """
            setattr(self,item,getattr(self._proxy,item))
            return getattr(self,item)
            oppure
            """
            return getattr(self._proxy,item)

if "__main__"==__name__:
    x=ProteggiClasse("leggi","scriviA","scriviB")
    print(x.leggi())
    print(x.scriviA())

