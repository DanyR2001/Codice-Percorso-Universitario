
public class Utente {
	private String Nome;
	private String Cognome;
	private String Login;
	private String Password;
	
	public Utente(String nome,String cognome,String login, String password) {
		Nome=nome;
		Cognome=cognome;
		Login = login;
		Password = password;
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
	
	public boolean equals(String l,String p) {
		return l.equals(this.Login)&&p.equals(this.Password);
	}
	
	
}
