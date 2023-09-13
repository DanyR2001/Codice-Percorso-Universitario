

class Bambino:

	ISCRITTO, AL_SECONDO_ANNO, AL_TERZO_ANNO, DIPLOMATO = 1, 2, 3, 4

	def __init__(self):
		self.state = Bambino.ISCRITTO

	@property
	def state(self):
		return self._state


	@state.setter
	def state(self,value):
		assert isinstance(value, int) and value in range(1, 5), 'Wrong parameter!'
		if value== Bambino.ISCRITTO:
			self._state=Bambino.ISCRITTO
			self.pred=lambda *args: print("Il bambino  e` appena stato iscritto al I anno e non puo` tornare in uno stato precedente")
			self.succ=self.__succ
			self.salta_anno=self.__salta_anno
		elif value== Bambino.AL_SECONDO_ANNO:
			self._state=Bambino.AL_SECONDO_ANNO
			self.pred=self.__pred
			self.succ = self.__succ
			self.salta_anno = self.__salta_anno
		elif value ==Bambino.AL_TERZO_ANNO:
			self._state=Bambino.AL_TERZO_ANNO
			self.pred = self.__pred
			self.succ = self.__succ
			self.salta_anno =lambda *args: print("Il bambino e` nello stato alTerzoAnno  e non puo` saltare un anno")
		else:
			self._state=Bambino.DIPLOMATO
			self.pred=self.__pred
			self.succ=lambda *args:print("Il bambino  si e` gia` diplomato e non puo` avanzare in uno stato successivo")
			self.salta_anno =lambda *args: print("Il bambino e` nello stato alTerzoAnno  e non puo` saltare un anno")



	def __succ(self):
		self.state+=1

	def __pred(self):
		self.state -=1

	def __salta_anno(self):
		self.state+=2

	def stampaStato(self):
		states = (None, 'iscritto', 'al secondo anno', 'al terzo anno', 'diplomato')
		print('Il bambino è {}'.format(states[self.state]))

def main():
	bambino =Bambino()
	bambino.stampaStato()
	bambino.pred()
	bambino.succ()
	bambino.stampaStato()
	bambino.succ()
	bambino.stampaStato()
	bambino.salta_anno()
	bambino.succ()
	bambino.stampaStato()
	bambino.succ()

if __name__== "__main__":
	main()



"""IL programma deve stampare:

Il bambino e` nello stato  iscritto
Il bambino  e` appena stato iscritto al I anno e non puo` tornare in uno stato precedente
Il bambino e` nello stato  alSecondoAnno
Il bambino e` nello stato  alTerzoAnno
Il bambino e` nello stato alTerzoAnno  e non puo` saltare un anno
Il bambino e` nello stato  diplomato
Il bambino  si e` gia` diplomato e non puo` avanzare in uno stato successivo
"""