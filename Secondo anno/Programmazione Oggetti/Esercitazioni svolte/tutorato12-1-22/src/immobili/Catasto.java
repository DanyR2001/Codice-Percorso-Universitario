package immobili;

import java.util.ArrayList;

public class Catasto {
	private ArrayList<Immobile> lista;
	
	public Catasto() {
		lista=new ArrayList<>();
	}
	
	private boolean isInList(Immobile j) {
		if(lista.isEmpty())
			return false;
		for(Immobile i: lista)
			if(j instanceof Appartamento && i instanceof Appartamento) {
				if(((Appartamento) j).equals(i))
					return true;
			}
			else if(j instanceof Garadge && i instanceof Garadge) {
				if(((Garadge) j).equals(i))
					return true;
			}
		return false;
	}
	
	public void addImmobile(Immobile i) {
		if(!this.isInList(i)) {
			lista.add(i);
		}
	}
	
	public double calcolaValoreAppartameti() {
		double ret=0;
		if(lista.isEmpty())
			return -1;
		for(Immobile i: lista)
			ret+=i.getValore();
		return ret;
	}
	
	public void rimuoviImmobile(Immobile i) {
		lista.remove(i);
	}
	
	public ArrayList<Immobile> cercaImmobile(double x){
		ArrayList<Immobile> ret=new ArrayList<>();
		for(Immobile i: lista)
			if(i.getValore()<x)
				ret.add(i);
		if(ret.isEmpty())
			return null;
		else
			return ret;
	}
	
	public String ToString() {
		String ret="";
		for(Immobile i: lista)
			ret+=i.toString();
		return ret;
	}
}
