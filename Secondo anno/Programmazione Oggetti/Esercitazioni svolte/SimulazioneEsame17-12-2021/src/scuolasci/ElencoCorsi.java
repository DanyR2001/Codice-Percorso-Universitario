package scuolasci;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ElencoCorsi {
	private ArrayList<Corso> lista;
	
	public ElencoCorsi() {
		lista=new ArrayList<>();
	}
	
	public void aggiungiCorso(Corso c) {
		if(lista.isEmpty()) {
			lista.add(c);
			System.out.print("messo il primo \n");

		}
		else {
		int i=0;
		int size=lista.size();
		do{
			//System.out.print("for "+i+"\n");
			if(c.daiData().before(lista.get(i).daiData())) {
				System.out.print("1 ");
				lista.add(i,c);
			}
			else if(i==lista.size()-1) {
				System.out.print("2 ");
				lista.add(c);
			}
			else if(i<lista.size()-1) {
				if(c.daiData().before(lista.get(i+1).daiData())){
				System.out.print("3 ");
				lista.add(i+1,c);
				}
			}
			i+=1;
			//System.out.print("for "+i+"\n siz4 "+lista.size()+" ");
		}while(i<size);
		}
	}
	
	public Corso daiCorso(int i) {
		if(i>0&&i<lista.size())
			return lista.get(i);
		return null;
	}
	
	public Corso cancellaCorso(int i) {
		if(i>0&&i<lista.size())
			return lista.remove(i);
		return null;
	}
	
	public ArrayList<Corso> dammiCorsi(String tipo){
		ArrayList<Corso> temp=new ArrayList<Corso>();
		for(int i=0;i<lista.size();i++) {
			if(tipo.equals("Sci"))
				if(lista.get(i) instanceof CorsoSci)
					temp.add(lista.get(i));
			if(tipo.equals("Snowboard"))
				if(lista.get(i) instanceof CorsoSnowboard)
					temp.add(lista.get(i));
		}
		if (temp.isEmpty())
			return null;
		else
			return temp;
	}
	
	public static void RandomCreate(ElencoCorsi list) {
		Random rand=new Random();
		for(int i=1;i<=10;i++) {
			System.out.print("i:"+i);
			if((i%2)==0){
				System.out.print("pari "+i);
				CorsoSci x= new CorsoSci(""+rand.nextInt(100000), rand.nextInt(7)+1, new Date(),rand.nextInt(15));
				System.out.print(x);
				list.aggiungiCorso(x);
			}
			else {
				System.out.print("dispari "+i);
				CorsoSnowboard y= new CorsoSnowboard(""+rand.nextInt(100000), rand.nextInt(11)+1, new Date(),rand.nextInt(15));
				System.out.print(y);
				list.aggiungiCorso(y);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String toString() {
		String ret="";
		for(int i=0;i<lista.size();i++) {
			ret+=lista.get(i).toString()+"\n";
		}
		return ret;
	}
	
}
