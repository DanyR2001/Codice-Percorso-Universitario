

class UtenzeAbitazione:

    registro=dict()
    cl_serbatoio=1000



    def __init__(self,nome:str):
        self.nome=nome
        self._contatore_acqua=0
        UtenzeAbitazione.registro[nome]=0
        self.attiva_utenze()

    def get_nome(self):
        print(self.nome)

    @classmethod
    def disponibilita_gas(Class):
        print("quantita {}".format(Class.cl_serbatoio))

    @property
    def stato(self):
        if  self.apri_acqua==self._apri_acqua and self.get_consumi==self._get_consumi and self.accendi_riscaldamento==self._accendi_riscaldamento:
            return "ON"
        else :
            return "OFF"

    def attiva_utenze(self):
        self.apri_acqua=self._apri_acqua
        self.get_consumi=self._get_consumi
        self.accendi_riscaldamento=self._accendi_riscaldamento

    def disattiva_utenze(self):
        self.apri_acqua = lambda *args: None
        self.get_consumi =lambda *args: None
        self.accendi_riscaldamento =lambda *args: None

    #apri_acqua, accendi_riscaldamento, e get_consumi

    def _apri_acqua(self,num_cl):
        self._contatore_acqua+=num_cl

    def _accendi_riscaldamento(self,num_cl):
        if UtenzeAbitazione.cl_serbatoio>num_cl:
            UtenzeAbitazione.cl_serbatoio-=num_cl
            UtenzeAbitazione.registro[self.nome]+=num_cl
        else:
            UtenzeAbitazione.cl_serbatoio=0
            raise ValueError("Attenzione: il serbatoio condominiale e` vuoto")


    def _get_consumi(self):
        return "acqua:{}, gas:{}".format(self._contatore_acqua,UtenzeAbitazione.registro[self.nome])

if __name__=="__main__":
    first=UtenzeAbitazione("marco")
    second=UtenzeAbitazione("mario")
    print(first.stato)
    first.apri_acqua(1000)
    first.accendi_riscaldamento(500)
    print(first.get_consumi())
    try:
        first.accendi_riscaldamento(1000)
    except ValueError as err:
        print(err)
        first.disattiva_utenze()
    print(first.stato)
