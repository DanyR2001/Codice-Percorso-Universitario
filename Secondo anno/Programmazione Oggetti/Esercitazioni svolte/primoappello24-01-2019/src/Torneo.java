import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Torneo {
	private String Nome;
	private ArrayList<Squadra> Classifica;
	
	public Torneo(String nome) {
		Nome=nome;
		Classifica=new ArrayList<Squadra>();
	}
	
	public void addSquadra(Squadra x) {
		Classifica.add(x);
	}
	
	public void addSquadra(String nome,int punteggio,int numPartite, double budget) {
		Squadra x=new Squadra(nome, punteggio, numPartite, budget);
		Classifica.add(x);
	}
	
	public void play(Squadra a1,Squadra a2) throws IOException {
		if(a1.getBudget()<100||a2.getBudget()<100)
			throw new IOException("una delle due è povera");
		PartitaCalcio x=new PartitaCalcio(a1, a2, new GregorianCalendar(), 100);
		PartitaBasket y=new PartitaBasket(a1, a2, new GregorianCalendar());
		x.gioca();
		y.gioca();
	}
	
	public void playTorneo() throws IOException {
		if(Classifica.size()>2)
			for(int i=0;i<Classifica.size();i++)
				for(int j=i+1;j<Classifica.size();j++)
					play((Squadra)Classifica.get(i),(Squadra)Classifica.get(j));
	}
	
	public String printList(){
		String x="";
		for(int i=0;i<Classifica.size();i++)
			x+=Classifica.get(i).toString();
		return x;
	}

	
	public String Classifica(){
		ArrayList<Squadra> temp=new ArrayList<Squadra>();
		temp=(ArrayList<Squadra>) Classifica.clone();
		int i=0,j=1;
		while(i<temp.size()) {
			while(j<temp.size()) {
				if(temp.get(i).getPunteggio()<temp.get(j).getPunteggio()) {
					temp.add(i, temp.get(j));
					temp.add(j,temp.get(i+1));
					temp.remove(i+1);
					temp.remove(j+1);
				}
				j++;
			}
			i++;
			j=i;
		}
		String x="";
		for(i=1;i<=temp.size();i++) {
			x+=" "+i+") "+temp.get(i-1).getNome()+" Punteggio: "+temp.get(i-1).getPunteggio()+"\n";
		}
		return x;
	}
	
}
