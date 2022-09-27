import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Albergo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5232086162930702892L;
	private ArrayList<Cliente> Clienti;
	private ArrayList<Stanza> Stanze;
	private ArrayList<Prenotazione> Prenotazioni;
	
	
	public Albergo(ArrayList<Cliente> clienti, ArrayList<Stanza> stanze, ArrayList<Prenotazione> prenotazioni) {
		Clienti = clienti;
		Stanze = stanze;
		Prenotazioni = prenotazioni;
	}
	
	public Albergo() {
		Clienti = new ArrayList<>();
		Stanze =  new ArrayList<>();
		Prenotazioni =  new ArrayList<>();
	}
	
	public void addCliente(Cliente x) {
		Clienti.add(x);
	}
	
	public void addCliente(String nome, String cognome, String telefono, String num_carta) throws IOException {
		Cliente x=new Cliente(nome,cognome,telefono,num_carta);
		Clienti.add(x);
	}
	
	public void addStanza(Stanza x) {
		Stanze.add(x);
	}
	
	public void addStanza(int numero, int piano, String tipologia, String servizi, int telefono) {
		Stanza x=new Stanza(numero,piano,tipologia,servizi,telefono);
		Stanze.add(x);
	}
	
	public void addPrenotazione(Cliente x,Stanza y,GregorianCalendar in,GregorianCalendar out) throws IOException {
		Prenotazione pre=new Prenotazione(in, out, x, y);
		if(this.isPrenotabile(y)!=true)
			throw new IOException("non preotabile stanza");
		else
			Prenotazioni.add(pre);
	}

	public ArrayList<Cliente> getClienti() {
		return Clienti;
	}

	public ArrayList<Stanza> getStanze() {
		return Stanze;
	}
	
	public ArrayList<Stanza> getFreeStanze() {
		ArrayList<Stanza> x=new ArrayList<>();
		boolean flag;
		for(int i=0;i<Stanze.size();i++) {
			flag=true;
			for(int j=0;j<this.Prenotazioni.size()&&flag;j++)
				if(Prenotazioni.get(i).getY().equals(Stanze.get(j)))
					flag=false;
			if(flag)
				x.add(Stanze.get(i));
		}
		return x;
	}
	
	public boolean isPrenotabile(Stanza x){
		boolean flag=true;
		for(int j=0;j<this.Prenotazioni.size()&&flag;j++)
			if(Prenotazioni.get(j).getY().equals(x))
				flag=false;
		return flag;
	}
	
	public void removeOdiern() {
		for(int i=0;i<Prenotazioni.size();i++)
			if(Prenotazioni.get(i).getOut().before(new GregorianCalendar()))
				Prenotazioni.remove(i);
	}
	
	public void removePre(Prenotazione x) {
		for(int i=0;i<Prenotazioni.size();i++)
			if(Prenotazioni.get(i).equals(x))
				Prenotazioni.remove(i);
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return Prenotazioni;
	}
	
	
	
	
	
}
