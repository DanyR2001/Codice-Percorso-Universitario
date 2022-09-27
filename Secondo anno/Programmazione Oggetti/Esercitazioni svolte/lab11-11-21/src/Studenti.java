
public class Studenti extends Persona{
	private String specializzazione;
	
	public Studenti(String Nome,String Cognome,String Data,String spec) {
		super(Nome,Cognome,Data);
		specializzazione=spec;
	}
	
	public String toString() {
		return super.toString()+", Specializzazione: "+specializzazione;
	}
}
