import java.util.ArrayList;

public class Manager {
	private ArrayList<Attore> list;
	
	public Manager() {
		list=new ArrayList<>();
	}
	
	public void addActor(Attore x) {
		list.add(x);
	}
	
	public double getTotalCompenso() {
		double total=0;
		if(list.isEmpty())
			return -1;
		for(int i=1;i<=list.size();i++) {
			total+=list.get(i).getCompenso(i*10);
		}
		return total;
	}
	
	public void removeAct(Attore x) {
		list.remove(x);
	}

	public String toString() {
		String ret="";
		for(Attore a: list)
			ret+="Manager: lista:" + a.toString() + "; \n" ;
		return ret;
	}
	
	public ArrayList<Attore> Filtra(int x){
		ArrayList<Attore> ret=new ArrayList();
		for(Attore a: list) {
			if(x==0)
				if(a instanceof AttoreFilm)
					ret.add(a);
			if(x==1)
				if(a instanceof AttoreTeatro)
					ret.add(a);
		}
		if(ret.isEmpty())
			return null;
		return ret;
	}
	
	
	
	
}
