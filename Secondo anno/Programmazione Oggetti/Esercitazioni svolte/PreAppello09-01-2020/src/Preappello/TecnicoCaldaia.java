package Preappello;

import java.util.ArrayList;

public class TecnicoCaldaia extends Idraulico{
	private ArrayList<String> listaCase;
	private int numRip;
	private int mediaVoti;
	
	public TecnicoCaldaia(String matricola, String cognome, String nome,ArrayList<String> listaCaldaie) {
		super(matricola, cognome, nome);
		listaCase=listaCaldaie;
		numRip=1;
		mediaVoti=0;
	}
	
	public void effetuaInterv(String interv,int voto) {
		boolean flag=true;
		for(int i=0;i<listaCase.size()&&flag;i++)
			if(listaCase.get(i).equals(interv))
				flag=false;
		if(flag)
			throw new NotCertificateHydraulic();
		numRip++;
		super.setNumInterv(super.getNumInterv()+1);
		mediaVoti+=voto;
	}

	public ArrayList<String> getListaCase() {
		return listaCase;
	}

	public void setListaCase(ArrayList<String> listaCase) {
		this.listaCase = listaCase;
	}

	public int getNumRip() {
		return numRip;
	}

	public void setNumRip(int numRip) {
		this.numRip = numRip;
	}

	public double getMediaVoti() {
		return mediaVoti/numRip;
	}

	public void setMediaVoti(int mediaVoti) {
		this.mediaVoti = mediaVoti;
	} 
	
	public boolean isTecnicoPerMarca(String x) {
		boolean flag=false;
		for(int i=0;i<listaCase.size()&&flag==false;i++) {
			if(x.equals(listaCase.get(i)))
				flag=true;
		}
		return flag;
	}
	
	public String toString() {
		return ""+super.getNome()+","+super.getCognome()+"	"+numRip+"	"+this.getMediaVoti();
	}
	
	
}
