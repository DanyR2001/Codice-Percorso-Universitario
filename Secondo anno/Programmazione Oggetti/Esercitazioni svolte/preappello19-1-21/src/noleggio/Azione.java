package noleggio;

public class Azione extends Film{
	
	public Azione(String code,String titolo){
		super(code,titolo);
	}
	
	public double calcolaPenaleRitardo(int num) {
		return 3*num;
	}
	
	public String toString() {
		return "Titolo :"+this.dammiTitolo()+", Codice: "+this.dammiCodice()+", film d'azione ";
	}
	
}
