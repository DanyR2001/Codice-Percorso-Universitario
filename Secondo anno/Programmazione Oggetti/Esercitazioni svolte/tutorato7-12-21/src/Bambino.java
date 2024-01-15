import java.util.GregorianCalendar;

public class Bambino extends Regalo{
	private String Nome;
	private int Eta;
	private String Message;
	
	public Bambino(String nome, int eta, String message,GregorianCalendar data, double peso, String regione_destinatario){
		super(data,peso,regione_destinatario);
		Nome=nome;
		Eta=eta;
		Message=message;
	}
	
	public String toString() {
		return "HoHoHo "+Message+", "+super.toString();
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getEta() {
		return Eta;
	}

	public void setEta(int eta) {
		Eta = eta;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
}
