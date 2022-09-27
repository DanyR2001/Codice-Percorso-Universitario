
public class Squadra {
	private String Nome;
	private int Punteggio;
	private int NumPartite;
	private double Budget;
	
	public Squadra(String nome,int punteggio,int numPartite, double budget) {
		Nome=nome;
		Punteggio=punteggio;
		NumPartite=numPartite;
		Budget=budget;
	}
	
	public void addPunti(int x) {
		Punteggio+=x;
	}
	
	public void subBudget(double x) {
		Budget-=x;
	}
	
	public void playedGame() {
		NumPartite++;
	}
	
	public String toString() {
		return "Nome: "+Nome+", Punteggio:"+Punteggio+", Numero di partite diputate:"+NumPartite+", Nudget attuale:"+Budget+"\n";
	}
	
	public boolean equals(Squadra x) {
		if(Nome.equals(x.getNome())&&Punteggio==x.getPunteggio()&&NumPartite==x.getNumPartite()&&Budget==x.getBudget())
			return true;
		return false;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getPunteggio() {
		return Punteggio;
	}

	public void setPunteggio(int punteggio) {
		Punteggio = punteggio;
	}

	public int getNumPartite() {
		return NumPartite;
	}

	public void setNumPartite(int numPartite) {
		NumPartite = numPartite;
	}

	public double getBudget() {
		return Budget;
	}

	public void setBudget(double budget) {
		Budget = budget;
	}
}
