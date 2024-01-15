import java.io.Serializable;
import java.util.InputMismatchException;

public class Motociclo extends Automezzo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6446956850013032743L;
	private int NumeroDiRuote;
	private int NumeroDiPasseggeri;
	
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
		String num=x.substring(2, x.length()-1);
		String string1=x.substring(0, 1);
		try {
			int numi=Integer.parseInt(num);
		}catch(NumberFormatException e){
			throw new TargaErrataException("Formato non valido valido");
		}
		if(testString(string1))
			return true;
		else
			return false;
		
	}
	
	public Motociclo(String modello, String marca, String targa, int anno,int numeroDiRuote, int numeroDiPasseggeri) {
		super(modello,marca,targa,anno);
		if(!checkTarga(targa))
			throw new TargaErrataException("errore");
		NumeroDiPasseggeri=numeroDiPasseggeri;
		NumeroDiRuote=numeroDiRuote;
	}

	public int getNumeroDiRuote() {
		return NumeroDiRuote;
	}

	public void setNumeroDiRuote(int numeroDiRuote) {
		NumeroDiRuote = numeroDiRuote;
	}

	public int getNumeroDiPasseggeri() {
		return NumeroDiPasseggeri;
	}

	public void setNumeroDiPasseggeri(int numeroDiPasseggeri) {
		NumeroDiPasseggeri = numeroDiPasseggeri;
	}
}
