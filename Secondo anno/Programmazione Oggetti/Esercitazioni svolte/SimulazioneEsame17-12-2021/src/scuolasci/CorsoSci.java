package scuolasci;
import java.util.Date;

public class CorsoSci implements Corso {
	private String Identificativo;
	private int NumPart;
	private Date Start;
	private int Durata;
	private final static int NumMin=4;
	private final static int NumMax=8;

	
	public CorsoSci(String identificativo,int numPart,Date start,int durata) {
		Identificativo=identificativo;
		NumPart=numPart;
		Start=start;
		if(durata<0)
			throw new BadArgumentException();
		Durata=durata;
	}
	
	public CorsoSci(String identificativo,int durata) {
		Identificativo=identificativo;
		NumPart=0;
		Start=new Date();
		if(durata<0)
			throw new BadArgumentException();
		Durata=durata;
	}
	
	public String daiNomeCorso() {
		return Identificativo;
	}
	
	public int daiNumeroMinimoPartecipanti() {
		return NumMin;
	}
	
	public int daiNumeroMassimoPartecipanti(){
		return NumMax;
	}
	
	public int daiNumeroPartecipanti() {
		return NumPart;
	}
	
	public Date daiData(){
		return Start;
	}
	
	public boolean aggiungiPartecipante() {
		if(NumPart<NumMax) {
			NumPart++;
			return true;
		}
		else
			return false;
	}
	public boolean corsoAttivato() {
		if(NumPart>NumMin)
			return true;
		return false;
	}
	
	public String toString() {
		return "CorsoSci:\n	Identificativo=" + Identificativo + ", NumPart=" + NumPart + ", Start=" + Start
				+ ", Durata=" + Durata + "";
	}
}
