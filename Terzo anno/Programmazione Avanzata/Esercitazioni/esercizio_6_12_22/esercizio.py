import collections
import inspect

from moduloVeicoli import Autobus,Auto

class Manovratore:

    def __init__(self, VeicoleCallablePairs):
        self.callablesForVeicole=collections.defaultdict(list)
        for veicolo, caller in VeicoleCallablePairs:
            self.callablesForVeicole[veicolo].append(caller)
            veicolo.manovratore = self

    def aziona(self, veicolo):
        callables = self.callablesForVeicole.get(veicolo)
        if callables is not None:
            for caller in callables:
                caller(veicolo)
        else:
            raise AttributeError("No on_change() method registered for {}".format(callables))


class Strada:

    def __init__(self,listaAuto,listaBus):
        self.dictVeicoli=dict()
        for auto in listaAuto:
            self.dictVeicoli[auto]=Auto(auto)
        for NumBus,tratta in listaBus:
            self.dictVeicoli[NumBus]=Autobus(NumBus,tratta)
        tuples=list()
        for id_vec,obj in self.dictVeicoli.items():
            if isinstance(obj,Auto):
                tuples.append((obj,self.auto_aggiorna))
            elif isinstance(obj,Autobus):
                tuples.append((obj,self.bus_fermata))
                tuples.append((obj,self.bus_capolinea))
        self._menovratore=Manovratore(tuples)

    def auto_aggiorna(self,auto=None):
        if auto is not None:
            print("L’auto {} sta facendo benzina".format(auto.id_veicolo))
            auto.reset_spia()

    def bus_fermata(self,AutoBus=None):
        func=inspect.stack()[2][3]
        if AutoBus is not None:
            if func=="arrivaAllaFermata":
                print("L’autobus {} sta effettuando una fermata alle ore {}".format(AutoBus.id_veicolo,AutoBus.aggiorna_ora_ultima_fermata()))

    def bus_capolinea(self, AutoBus=None):
        func = inspect.stack()[2][3]
        if AutoBus is not None:
            if func == "arrivaAlCapolinea":
                print("L’autobus {} è arrivato al capolinea: ora il suo tragitto è {}.".format(AutoBus.id_veicolo,
                                                                                    AutoBus.aggiorna_direzione()))


    def getVeicolo(self,id_veicolo):
        return self.dictVeicoli[id_veicolo]


#test per programma senza bonus: togliere gli apici alla riga successiva e quelli dopo l'invocazione di main se si e` implementatata questa versione"
"""
def main():
    print("\nTest con 2 auto e 2 autobus:")
    automobiliID=("AB123CD", "AF234EF")
    autobusInfo=(("11",("via Roma","via Poseidonia")),("21",("via Canalone","via Vinciprova")))
    strada=Strada(automobiliID,autobusInfo)
    auto1=strada.getVeicolo("AB123CD")
    auto2=strada.getVeicolo("AF234EF")
    bus1=strada.getVeicolo("11")
    bus2=strada.getVeicolo("21")
    
    auto1.sonoARiserva()
    auto2.sonoARiserva()
    bus1.arrivaAllaFermata()
    bus1.arrivaAllaFermata()
    
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    

if __name__=="__main__":
    main()
"""

"""
Il programma deve stampare (gli orari ovviamente sono diversi):
Test con 2 auto e 2 autobus:
L’auto AB123CD sta facendo benzina
L’auto AF234EF sta facendo benzina
L’autobus 11 sta effettuando una fermata alle ore 19:52:37
L’autobus 11 sta effettuando una fermata alle ore 19:52:37
L’autobus 21 sta effettuando una fermata alle ore 19:52:37
L’autobus 21 sta effettuando una fermata alle ore 19:52:37
"""

#test per programma con bonus: togliere gli apici alla riga successiva e quelli dopo l'invocazione di main se si e` implementatata questa versione"
"""
def main():
    print("\nTest con 2 auto e 2 autobus:")
    automobiliID=("AB123CD", "AF234EF")
    autobusInfo=(("11",("via Roma","via Poseidonia")),("21",("via Canalone","via Vinciprova")))
    strada=Strada(automobiliID,autobusInfo)
    auto1=strada.getVeicolo("AB123CD")
    auto2=strada.getVeicolo("AF234EF")
    bus1=strada.getVeicolo("11")
    bus2=strada.getVeicolo("21")
    
    auto1.sonoARiserva()
    auto2.sonoARiserva()
    bus1.arrivaAllaFermata()
    bus1.arrivaAllaFermata()
    
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    

    print("\nOra usiamo un numero diverso di veicoli")
    automobiliID=("AB123CD", "AF234EF","BG345KL")
    autobusInfo=(("11",("via Roma","via Poseidonia")),("21",("via Canalone","via Vinciprova")),("10", ("piazza delle Concordia", "via Ligea")),
                 ("1", ("piazza Malta", "Vietri sul Mare")))
    strada=Strada(automobiliID,autobusInfo)
    auto1=strada.getVeicolo("AB123CD")
    auto2=strada.getVeicolo("AF234EF")
    auto3=strada.getVeicolo("BG345KL")
    bus1=strada.getVeicolo("11")
    bus2=strada.getVeicolo("21")
    bus3=strada.getVeicolo("10")
    bus4=strada.getVeicolo("1")

    auto3.sonoARiserva()
    auto1.sonoARiserva()
    auto2.sonoARiserva()
    bus4.arrivaAllaFermata()
    bus3.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus1.arrivaAllaFermata()
    bus1.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus3.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus3.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    
if __name__=="__main__":
    main()
"""

"""
Il programma con bonus deve stampare  (gli orari ovviamente sono diversi):
Test con 2 auto e 2 autobus:
L’auto AB123CD sta facendo benzina
L’auto AF234EF sta facendo benzina
L’autobus 11 sta effettuando una fermata alle ore 19:44:58
L’autobus 11 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58

Ora usiamo un numero diverso di veicoli
L’auto BG345KL sta facendo benzina
L’auto AB123CD sta facendo benzina
L’auto AF234EF sta facendo benzina
L’autobus 1 sta effettuando una fermata alle ore 19:44:58
L’autobus 10 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
L’autobus 11 sta effettuando una fermata alle ore 19:44:58
L’autobus 11 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
L’autobus 10 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
L’autobus 10 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
L’autobus 21 sta effettuando una fermata alle ore 19:44:58
    
"""  


#test per programma con superbonus:  togliere gli apici alla riga successiva e quelli dopo l'invocazione di main se si e` implementatata questa versione"

def main():
    print("\nTest con 2 auto e 2 autobus:")
    automobiliID=("AB123CD", "AF234EF")
    autobusInfo=(("11",("via Roma","via Poseidonia")),("21",("via Canalone","via Vinciprova")))
    strada=Strada(automobiliID,autobusInfo)
    auto1=strada.getVeicolo("AB123CD")
    auto2=strada.getVeicolo("AF234EF")
    bus1=strada.getVeicolo("11")
    bus2=strada.getVeicolo("21")
    
    auto1.sonoARiserva()
    auto2.sonoARiserva()
    bus1.arrivaAllaFermata()
    bus1.arrivaAllaFermata()
    bus1.arrivaAlCapolinea()
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus2.arrivaAlCapolinea()

    print("\nOra usiamo un numero diverso di veicoli")
    automobiliID=("AB123CD", "AF234EF","BG345KL")
    autobusInfo=(("11",("via Roma","via Poseidonia")),("21",("via Canalone","via Vinciprova")),("10", ("piazza delle Concordia", "via Ligea")),
                 ("1", ("piazza Malta", "Vietri sul Mare")))
    strada=Strada(automobiliID,autobusInfo)
    auto1=strada.getVeicolo("AB123CD")
    auto2=strada.getVeicolo("AF234EF")
    auto3=strada.getVeicolo("BG345KL")
    bus1=strada.getVeicolo("11")
    bus2=strada.getVeicolo("21")
    bus3=strada.getVeicolo("10")
    bus4=strada.getVeicolo("1")

    auto3.sonoARiserva()
    auto1.sonoARiserva()
    auto2.sonoARiserva()
    bus4.arrivaAllaFermata()
    bus3.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus1.arrivaAllaFermata()
    bus1.arrivaAlCapolinea()
    bus1.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus2.arrivaAlCapolinea()
    bus2.arrivaAlCapolinea()
    bus3.arrivaAllaFermata()
    bus4.arrivaAlCapolinea()
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus3.arrivaAlCapolinea()
    bus3.arrivaAllaFermata()
    bus4.arrivaAlCapolinea()
    bus2.arrivaAllaFermata()
    bus2.arrivaAllaFermata()
    bus3.arrivaAlCapolinea()
if __name__=="__main__":
    main()



"""
Il programma con superbonus deve stampare  (gli orari ovviamente sono diversi)::
Test con 2 auto e 2 autobus:
L’auto AB123CD sta facendo benzina
L’auto AF234EF sta facendo benzina
L’autobus 11 sta effettuando una fermata alle ore 19:39:44
L’autobus 11 sta effettuando una fermata alle ore 19:39:44
L’autobus 11 è arrivato al capolinea: ora il suo tragitto e` ('via Poseidonia', 'via Roma')
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 è arrivato al capolinea: ora il suo tragitto e` ('via Vinciprova', 'via Canalone')

Ora usiamo un numero diverso di veicoli
L’auto BG345KL sta facendo benzina
L’auto AB123CD sta facendo benzina
L’auto AF234EF sta facendo benzina
L’autobus 1 sta effettuando una fermata alle ore 19:39:44
L’autobus 10 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 11 sta effettuando una fermata alle ore 19:39:44
L’autobus 11 è arrivato al capolinea: ora il suo tragitto e` ('via Poseidonia', 'via Roma')
L’autobus 11 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 è arrivato al capolinea: ora il suo tragitto e` ('via Vinciprova', 'via Canalone')
L’autobus 21 è arrivato al capolinea: ora il suo tragitto e` ('via Canalone', 'via Vinciprova')
L’autobus 10 sta effettuando una fermata alle ore 19:39:44
L’autobus 1 è arrivato al capolinea: ora il suo tragitto e` ('Vietri sul Mare', 'piazza Malta')
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 10 è arrivato al capolinea: ora il suo tragitto e` ('via Ligea', 'piazza delle Concordia')
L’autobus 10 sta effettuando una fermata alle ore 19:39:44
L’autobus 1 è arrivato al capolinea: ora il suo tragitto e` ('piazza Malta', 'Vietri sul Mare')
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 21 sta effettuando una fermata alle ore 19:39:44
L’autobus 10 è arrivato al capolinea: ora il suo tragitto e` ('piazza delle Concordia', 'via Ligea')

                 
    
    
    
    
"""
