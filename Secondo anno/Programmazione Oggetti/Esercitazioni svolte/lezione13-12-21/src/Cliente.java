import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4800815728199692831L;
	private String Nome;
	private String Cognome;
	private String Telefono;
	private String Num_carta;
	
	public Cliente(String nome, String cognome, String telefono, String num_carta) throws IOException {
		Nome = nome;
		Cognome = cognome;
		Telefono = telefono;
		if(num_carta.length()!=16)
			throw new IOException("errore carta");
		Num_carta = num_carta;
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

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getNum_carta() {
		return Num_carta;
	}

	public void setNum_carta(String num_carta) {
		Num_carta = num_carta;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Cognome, other.Cognome) && Objects.equals(Nome, other.Nome)
				&& Objects.equals(Num_carta, other.Num_carta) && Objects.equals(Telefono, other.Telefono);
	}
	
	
	
}
