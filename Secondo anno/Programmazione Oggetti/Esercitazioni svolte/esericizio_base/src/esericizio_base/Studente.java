package esericizio_base;

import java.util.Vector;

public class Studente {
	
	private Vector Esami;
	private int num_esa;
	
	public Studente() {
		Esami=new Vector();
		num_esa=0;
	}
	
	public void addEsame(int Voto) {
		Esami.insertElementAt(Voto,num_esa);
		num_esa++;
	}
	
	public double media() {
		if(num_esa>0) {
			double sum=0;
			for(int i=0;i<num_esa;i++) {
				int app=(int) Esami.elementAt(i);
				sum+=(double)app;
			}
			return sum/num_esa;
		}
		return -1;
	}
}
