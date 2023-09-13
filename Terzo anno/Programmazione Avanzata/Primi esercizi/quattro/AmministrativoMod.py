from ImpiegatoMod import Impiegato


class Amministrativo(Impiegato):

    numImpiegati = 0

    def __init__(self):
        super().__init__()
        Impiegato.agg()