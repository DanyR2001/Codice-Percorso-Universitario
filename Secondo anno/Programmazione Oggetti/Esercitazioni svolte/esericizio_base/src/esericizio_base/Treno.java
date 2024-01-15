package esericizio_base;

import java.util.ArrayList;

public class Treno {
	private Stazione start;
	private ArrayList<Stazione> stop;
	private Stazione finish;
	private int posti_disponibili;
	private int posti_max;
	private double km_percorsi;
	private boolean espresso;
	private int posti_ristorante;
	private int posti_ristorante_disp;
	
	public Treno(Stazione partenza,Stazione arrivo,int max,boolean espresso,int ristorante) {
		start=partenza;
		stop=new ArrayList();
		finish=arrivo;
		posti_max=max;
		posti_disponibili=max;
		this.espresso=espresso;
		if(espresso) {
			this.posti_ristorante=ristorante;
			posti_ristorante_disp=ristorante;
		}
		km_percorsi=0;
	}
	
	public void nextStation(Stazione next,double km,int num_pers) {
		if(!cheack()) {
			stop.add(next);
			km_percorsi+=km;
			if(num_pers<this.posti_disponibili)
				this.posti_disponibili-=num_pers;
			else
				this.posti_disponibili-=posti_disponibili;
		}
	}
	
	public boolean cheack() {
		boolean flag=false;
		if(stop.get(stop.size()-1).equals(finish))
			flag=true;
		return flag;
	}
	
	public int numFermata() {
		return stop.size()+1;
	}
	
	public double ricavoTreno(double costoNormale,double costoEspresso) {
		double tot=0;
		if(espresso)
			tot+=(posti_ristorante-posti_ristorante_disp)*costoEspresso*km_percorsi;
		tot+=(posti_max-posti_disponibili)*costoNormale*km_percorsi;
		return tot;
	}
}
