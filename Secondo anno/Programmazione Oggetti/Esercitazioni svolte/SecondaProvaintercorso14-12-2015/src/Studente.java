import java.util.ArrayList;

public class Studente extends Utente {
	private PianoStudi p;
	private String Matricola;
	
	public Studente(String nome,String cognome,String login, String password,String matricola,String piano) {
		super(nome,cognome,login, password);
		Matricola=matricola;
		p=new PianoStudi(piano);
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public PianoStudi getP() {
		return p;
	}
	
	public boolean equals(String m) {
		return m.equals(this.Matricola);
	}

	@Override
	public String toString() {
		return "Studente " + p + " Matricola=" + Matricola + " media voti"+p.getMedia();
	}
	

}
