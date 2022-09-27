import java.io.Serializable;

public class Stanza implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9065267851227219271L;
	private int Numero;
	private int Piano;
	private String Tipologia;
	private String Servizi;
	private int Telefono;
	
	public Stanza(int numero, int piano, String tipologia, String servizi, int telefono) {
		Numero = numero;
		Piano = piano;
		Tipologia = tipologia;
		Servizi = servizi;
		Telefono = telefono;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public int getPiano() {
		return Piano;
	}

	public void setPiano(int piano) {
		Piano = piano;
	}

	public String getTipologia() {
		return Tipologia;
	}

	public void setTipologia(String tipologia) {
		Tipologia = tipologia;
	}

	public String getServizi() {
		return Servizi;
	}

	public void setServizi(String servizi) {
		Servizi = servizi;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
	public boolean equals(Stanza x) {
		if(this.Numero==x.getNumero()&&this.Piano==x.getPiano()&&this.Servizi.equals(x.getServizi())&&this.Telefono==x.getTelefono()&&this.Tipologia.equals(x.getTipologia()))
			return true;
		else
			return false;
	}

}
