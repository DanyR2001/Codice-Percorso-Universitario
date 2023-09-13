
from ImpiegatoMod import *
from TecnicoMod import *
from AmministrativoMod import *
import random

numImMax=10

Amm=random.randint(1,numImMax)
Tec=random.randint(1,numImMax)
Imp=random.randint(1,numImMax)

Max=max(Amm,Tec,Imp)

for i in range(Max):
    if i<Amm:
        tem=Amministrativo()
    if i<Tec:
        tem=Tecnico()
    if i<Imp:
        tem=Impiegato()

print("Tec n:",Tec," act:",Tecnico.numImpiegati,", Amm n:",Amm," act:",Amministrativo.numImpiegati,", Imp n:",Imp," act:",Impiegato.numImpiegati)