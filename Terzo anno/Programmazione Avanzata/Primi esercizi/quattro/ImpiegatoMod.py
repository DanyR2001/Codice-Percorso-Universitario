class Impiegato:

    numImpiegati = 0

    def __init__(self):
        self.agg()

    @classmethod
    def agg(cls):
        cls.numImpiegati+=1