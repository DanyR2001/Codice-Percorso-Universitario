import java.util.ArrayList;

public class SlittaBabboNatale {
	private ArrayList<Regalo> Collezione;
	private double PesoMax;
	
	public SlittaBabboNatale(double pesoMax) {
		Collezione= new ArrayList();
		PesoMax=pesoMax;
	}
	
	private double getPesoSlitta() {
		double peso=0;
		if(!Collezione.isEmpty())
			for(int i=0;i<Collezione.size();i++)
				peso+=Collezione.get(i).getPeso();
		return peso;
	}
	
	public void aggiungiRegalo(Regalo x) throws PesoMaxSuperato {
		if(this.getPesoSlitta()+x.getPeso()>PesoMax)
			throw new PesoMaxSuperato();
		else
			Collezione.add(x);
	}
	
	public double calcolaCosto() {
		double costo=0;
		if(!Collezione.isEmpty())
			for(int i=0;i<Collezione.size();i++)
				costo+=Collezione.get(i).calcolaCosto();
		return costo;
	}
	
	public void Spedisci() {
		//for(int i)
	}
}
