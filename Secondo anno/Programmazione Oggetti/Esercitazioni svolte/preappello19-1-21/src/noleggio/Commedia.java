package noleggio;

public class Commedia extends Film{

	public Commedia(String code,String titolo){
		super(code,titolo);
	}
	
	public double calcolaPenaleRitardo(int num) {
		return 2.5*num;
	}
	
	public String toString() {
		return "Titolo :"+this.dammiTitolo()+", Codice: "+this.dammiCodice()+", film commedia ";
	}
	
}
