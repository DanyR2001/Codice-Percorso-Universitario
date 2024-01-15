import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class AgendaMultimediale implements Serializable{

	private static final long serialVersionUID = 8794637124022680997L;
	ArrayList<SMS> Rubrica;
	
	public AgendaMultimediale() {
		Rubrica=new <SMS>ArrayList();
	}
	
	public void addSMS(SMS x) {
		Rubrica.add(x);
	}
	
	public void addSMS(int id,String mittente,GregorianCalendar data,String text) {
		SMS x=new SMS(id,mittente,data,text);
		Rubrica.add(x);
	}
	
	public ArrayList getListByDate() {
		if(Rubrica.size()<0)
			return null;
		else {
			ArrayList<SMS> restituisci=new ArrayList(Rubrica);
			Collections.sort(restituisci,new DataComparator());
			return restituisci;
		}
	}
	
	public ArrayList getListBySender() {
		if(Rubrica.size()<0)
			return null;
		else {
			ArrayList<SMS> restituisci=new ArrayList(Rubrica);
			Collections.sort(restituisci,new SenderComparator());
			return restituisci;
		}
	}
	
	public void toPrint() {
		for(int i=0;i<Rubrica.size();i++)
			System.out.println("id "+Rubrica.get(i).getId()+" nome "+Rubrica.get(i).getSender()+" data "+/*Rubrica.get(i).getDate()+*/" text "+Rubrica.get(i).getText());
	}
}
