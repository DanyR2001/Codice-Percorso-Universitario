package preEsame;

import java.util.ArrayList;

public class ArchivioAutomezzi {
	private ArrayList<Automezzo> lista;

	public ArchivioAutomezzi() {
		this.lista = new ArrayList<>();
	}
	
	public void addAutomezzo(Automezzo x) {
		lista.add(x);
		
	}
	
	public String FilterTarga(String x) {
		String ret="";
		for(Automezzo l : lista)
			if(l.equalsTarga(x))
				return l.toString();
		return ret;
	}
	
	private String FilterAnno(int a) {
		String ret="";
		for(Automezzo l : lista)
			if(l instanceof Motociclo)
				if(l.getAnno()==a)
					ret+=l.toString();
		return ret;
	}
	
	
	private String FilterAlimentazione(String a) {
		String ret="";
		for(Automezzo l : lista)
			if(l instanceof Autoveicolo)
				if(((Autoveicolo) l).getAlimentazione().equals(a))
					ret+=l.toString();
		return ret;
	}
	
	private String FilterNumRuote(int a) {
		String ret="";
		for(Automezzo l : lista)
			if(l instanceof Motociclo)
				if(((Motociclo) l).getNumeroRuote()==a)
					ret+=l.toString();
		return ret;
	}
	
	
	
	
	

}
