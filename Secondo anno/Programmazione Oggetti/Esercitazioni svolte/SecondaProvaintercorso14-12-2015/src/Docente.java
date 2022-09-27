
public class Docente extends Utente {
	private String Insegnamento;
	
	public Docente(String nome,String cognome,String login, String password,String insegnamento) {
		super(nome,cognome,login, password);
		Insegnamento=insegnamento;
		// TODO Auto-generated constructor stub
	}

	public String getInsegnamento() {
		return Insegnamento;
	}

	public void setInsegnamento(String insegnamento) {
		Insegnamento = insegnamento;
	}
	
}
