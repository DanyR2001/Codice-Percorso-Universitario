import java.io.IOException;
import java.util.GregorianCalendar;

import javax.imageio.IIOException;

public class Partita {
	private Squadra Uno;
	private Squadra Due;
	private GregorianCalendar Date;
	private String Risultato;
	
	private boolean isWrong(String risultato1){
		if(risultato1.length()==3||risultato1.length()==4||risultato1.length()==5) {
			int x1 = 0;
			int x2 = 0;
			if(risultato1.length()==3) {
				x1=Integer.parseInt(risultato1, 0, 0, 0);
				x2=Integer.parseInt(risultato1, risultato1.length()-1, risultato1.length()-1, 0);
			}
			if(risultato1.length()==5) {
				x1=Integer.parseInt(risultato1, 0, 1, 0);
				x2=Integer.parseInt(risultato1, risultato1.length()-1, risultato1.length()-2, 0);
			}
			if(risultato1.length()==4) {
				int pivot=0;
				for(int i=0;i<risultato1.length();i++)
					if(risultato1.charAt(i)=='-')
						pivot=i;
				x1=Integer.parseInt(risultato1, 0, pivot-1, 0);
				x2=Integer.parseInt(risultato1, risultato1.length()-1, pivot+1, 0);
			}
			if(x1<0||x2<0)
				return true;
			return false;
		}
		return true;
	}
	
	public Partita(Squadra u,Squadra d,GregorianCalendar x) throws IOException {
		if(u.equals(d))
			throw new RuntimeException("Squadre uguali "+u.getNome()+" "+d.getNome());
		else {
			Uno=u;
			Due=d;
			Date=x;
		}
	}
	
	public Partita(Squadra u,Squadra d,String risutato,GregorianCalendar x) throws IOException {
		if(u.equals(d)||this.isWrong(risutato))
			throw new RuntimeException("Squadre uguali "+u.getNome()+" "+d.getNome());
		else {
			Uno=u;
			Due=d;
			Date=x;
			Risultato=risutato;
		}
	}

	public Squadra getUno() {
		return Uno;
	}

	public void setUno(Squadra uno) {
		Uno = uno;
	}

	public Squadra getDue() {
		return Due;
	}

	public void setDue(Squadra due) {
		Due = due;
	}

	public GregorianCalendar getDate() {
		return Date;
	}

	public void setDate(GregorianCalendar date) {
		Date = date;
	}

	public String getRisultato() {
		return Risultato;
	}

	public void setRisultato(String risultato) {
		Risultato = risultato;
	}
	
	
}
