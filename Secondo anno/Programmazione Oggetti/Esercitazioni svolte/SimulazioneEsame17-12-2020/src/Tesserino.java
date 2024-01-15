import java.io.Serializable;

public abstract class Tesserino implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2131589392219780785L;
	private String Codice;
	private String Nome;
	private String Cognome;
	private boolean Stato;
	
	public Tesserino(String codice,String nome,String cognome,boolean stato) {
		Codice=codice;
		Nome=nome;
		Cognome=cognome;
		Stato=stato;
	}
	
	public boolean equals(String x) {
		return Codice.equals(x);
	}
	
	public void attiva() {
		Stato=true;
	}
	
	public void disattiva() {
		Stato=false;
	}
	
	public boolean isActive() {
		return Stato;
	}

	public String getCodice() {
		return Codice;
	}

	public void setCodice(String codice) {
		Codice = codice;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public boolean isStato() {
		return Stato;
	}

	public void setStato(boolean stato) {
		Stato = stato;
	}
	
	
}
