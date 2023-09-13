
class Pacco:

    Ordinato, Spedito, Ricevuto = 1,2,3

    def __init__(self):
        self.state=Pacco.Ordinato

    def __succ(self):
        self.state+=1

    def __pred(self):
        self.state-=1

    @property
    def state(self):
        return self._state

    @state.setter
    def state(self,value):
        assert isinstance(value,int) and value in range(1,4), "Errore parametri"
        if value == Pacco.Ordinato:
            self.pred=lambda *args: print("Errore il pacco è ordinato, non ha stati precedenti")
            self.succ=self.__succ
            self._state=Pacco.Ordinato
        elif value == Pacco.Spedito:
            self.pred = self.__pred
            self.succ = self.__succ
            self._state = Pacco.Spedito
        elif value==Pacco.Ricevuto:
            self.pred = self.__pred
            self.succ =lambda *args: print("Errore il pacco è stato ricevuto, non ha stati successivi")
            self._state = Pacco.Ricevuto

    def stampaStato(self):
        states = (None, 'Ordinato', 'Spedito', 'Ricevuto')
        print('Il pacco è nello stato {}'.format(states[self.state]))


def main():
	pacco =Pacco()
	pacco.stampaStato()
	pacco.pred()
	pacco.succ()
	pacco.stampaStato()
	pacco.succ()
	pacco.stampaStato()
	pacco.succ()
	pacco.stampaStato()
	pacco.succ()

if __name__== "__main__":
	main()
