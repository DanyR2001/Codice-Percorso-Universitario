import java.io.Serializable;
import java.util.InputMismatchException;

public class Autoveicolo extends Automezzo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1240271785517967100L;
	private String Alimentazione;
	private int NumeroPorte;
	private int NumeroPosti;

	
	private boolean testCarattere(char x){
		String test="ABCDEFGHILMNOPQRSTUVZ";
		boolean flag=false;
		for(int i=0;i<test.length()&&!flag;i++)
			if(x==test.charAt(i))
				flag=true;
		return flag;
	}
	
	private boolean testString(String x) {
		boolean flag=true;
		for(int i=0;i<x.length();i++)
			if(!testCarattere(x.charAt(i)))
				flag=false;
		return flag;
	}
	
	public boolean checkTarga(String x) {
		String num=x.substring(2, x.length()-3);
		String string1=x.substring(0, 1);
		String string2=x.substring(x.length()-2, x.length()-1);
		try {
			int numi=Integer.parseInt(num);
		}catch(NumberFormatException e){
			throw new TargaErrataException("Formato non valido valido");
		}
		if(testString(string1)&&testString(string2))
			return true;
		else
			return false;
		
	}
	
	public Autoveicolo(String modello, String marca, String targa, int anno,String alimentazione,int numeroPorte, int numeroPosti) {
		super(modello,marca,targa,anno);
		if(!checkTarga(targa))
			throw new TargaErrataException("errore");
		Alimentazione=alimentazione;
		NumeroPorte=numeroPorte;
		NumeroPosti=numeroPosti;
	}

	public String getAlimentazione() {
		return Alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		Alimentazione = alimentazione;
	}

	public int getNumeroPorte() {
		return NumeroPorte;
	}

	public void setNumeroPorte(int numeroPorte) {
		NumeroPorte = numeroPorte;
	}

	public int getNumeroPosti() {
		return NumeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		NumeroPosti = numeroPosti;
	}
	
	
	
}
