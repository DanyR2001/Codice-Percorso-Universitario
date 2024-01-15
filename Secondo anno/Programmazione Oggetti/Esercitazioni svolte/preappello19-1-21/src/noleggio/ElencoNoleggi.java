package noleggio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ElencoNoleggi {
	ArrayList<Noleggio> list;
	
	public ElencoNoleggi() {
		list= new ArrayList<>();
	}
	
	private boolean checkCode(Film x) {
		boolean flag=false;
		for(int i=0;i<list.size()&&flag==false;i++)
			if(list.get(i).getFilm().dammiCodice().equals(x.dammiCodice()))
				flag=true;
		return flag;
	}
	
	public void aggiungiNoleggio(Noleggio n) {
		if(checkCode(n.getFilm()))
			throw new BadCodeException();
		boolean flag=true;
		for(int i=0;i<list.size()&&flag;i++){
			System.out.println("scorro "+list.size()+" compare");
			if(list.get(i).getFilm().dammiCodice().compareTo(n.getFilm().dammiCodice())>0) {
				System.out.println("metto il nuovo in pos i "+i);
				list.add(i,n);
				flag=false;
				//break;
			}
		}
		if(flag) {
			System.out.println("aggiungo in coda");
			list.add(n);
		}
	}
	
	public double calcolaPenaliRitardo() {
		double x=0;
		for (int i=0;i<list.size();i++) {
			x+=list.get(i).calcolaPenale();
		}
		return x;
	}

	public ArrayList<Noleggio> cerca(String t){
		ArrayList<Noleggio> tmp=new ArrayList<>();
		for (int i=0;i<list.size();i++) {
			if(list.get(i).getFilm().dammiTitolo().equals(t))
				tmp.add(list.get(i));
		}
		if (tmp.size()>0)
			return tmp;
		else
			return null;
	}
	
	public String toString() {
		String temp = "";
		for (int i=0;i<list.size();i++) {
			temp+=list.get(i).toString()+"\n";
		}
		return temp;
	}
	
}
