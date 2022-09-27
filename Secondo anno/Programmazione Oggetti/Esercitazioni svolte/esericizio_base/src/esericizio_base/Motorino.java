package esericizio_base;

public class Motorino {
	private String colore;
	private double velocita;
	private String modello;
	private int cilindrata;
	private boolean antifurto;
	
	public Motorino(String modello,int cilindrata, double velocita, String colore) {
		this.colore=colore;
		this.velocita=velocita;
		this.modello=modello;
		this.cilindrata=cilindrata;
		this.antifurto=false;
	}
	
	public Motorino(String modello,int cilindrata, double velocita, boolean antifurto, String colore) {
		this.colore=colore;
		this.velocita=velocita;
		this.modello=modello;
		this.cilindrata=cilindrata;
		this.antifurto=antifurto;
	}

	public double getVelocita() {
		return velocita;
	}

	public void accellera(double velocita) {
		if(this.antifurto==false)
			this.velocita+=velocita;
	}

	public boolean isAntifurto() {
		return antifurto;
	}

	public void inserisciAntifurto() {
		setAntifurto(true);
	}

	public void setAntifurto(boolean antifurto) {
		this.antifurto = antifurto;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}
	
	
	
}
