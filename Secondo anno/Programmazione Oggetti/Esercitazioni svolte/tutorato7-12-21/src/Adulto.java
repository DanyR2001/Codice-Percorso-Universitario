import java.util.GregorianCalendar;

public class Adulto extends Regalo{
	private String Mittente;
	
	public Adulto(String mittente, GregorianCalendar data, double peso, String regione_destinatario) {
		super(data,peso,regione_destinatario);
		Mittente=mittente;
	}
	
	public String toString(){
		return "Mittente: "+Mittente+", "+super.toString();
	}

	public String getMittente() {
		return Mittente;
	}

	public void setMittente(String mittente) {
		Mittente = mittente;
	}
	
}
