import java.util.Date;
import java.util.Objects;

public abstract class Attore {
	private String Nome;
	private String Cognome;
	private Date DataNascita;
	
	public Attore(String nome, String cognome, Date dataNascita) {
		Nome = nome;
		Cognome = cognome;
		DataNascita = dataNascita;
	}

	public abstract double getCompenso(int x);

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

	public Date getDataNascita() {
		return DataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		DataNascita = dataNascita;
	}

	public String toString() {
		return "Nome=" + Nome + ", Cognome=" + Cognome + ", DataNascita=" + DataNascita + ", ";
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Attore)) {
			return false;
		}
		Attore other = (Attore) obj;
		return Objects.equals(Cognome, other.Cognome) && DataNascita.equals(other.getDataNascita())
				&& Objects.equals(Nome, other.Nome);
	}
	
}
