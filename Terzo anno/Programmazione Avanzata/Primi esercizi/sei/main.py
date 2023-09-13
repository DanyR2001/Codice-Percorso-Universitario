
from Panino import Panino

x=Panino()

x.miao="venti sette"
print(x.__slots__["dict"])
x.varA="ciao"
x.marco=" sette"
print(vars(Panino))
print(x.__slots__["dict"])

