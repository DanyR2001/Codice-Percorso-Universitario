import java.util.GregorianCalendar;

public class Regalo {
	private GregorianCalendar Data;
	private double Peso;
	private String Regione_destinatario;
	
	public Regalo(GregorianCalendar data, double peso, String regione_destinatario) {
		Data=data;
		Peso=peso;
		Regione_destinatario=regione_destinatario;
	}
	
	public int calcolaCosto() {
		if(Regione_destinatario.equals("Nord"))
			return 10;
		else if (Regione_destinatario.equals("Centro"))
			return 15;
		else if (Regione_destinatario.equals("Sud"))
			return 20;
		else
			return 25;
	}
	
	public String toString(){
		int day=Data.get(GregorianCalendar.DAY_OF_MONTH);
		int month=Data.get(GregorianCalendar.MONTH);
		month++;
		int year=Data.get(GregorianCalendar.YEAR);
		return "Data: "+day+"-"+month+"-"+year+", peso: "+Peso+", regirone destinatario: "+Regione_destinatario;
	}
	public GregorianCalendar getData() {
		return Data;
	}

	public void setData(GregorianCalendar data) {
		Data = data;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public String getRegione_destinatario() {
		return Regione_destinatario;
	}

	public void setRegione_destinatario(String regione_destinatario) {
		Regione_destinatario = regione_destinatario;
	}
}
