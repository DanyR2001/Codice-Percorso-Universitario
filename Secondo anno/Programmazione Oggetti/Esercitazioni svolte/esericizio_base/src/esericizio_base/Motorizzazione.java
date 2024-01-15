package esericizio_base;

import java.util.ArrayList;

public class Motorizzazione {
	private String identificativo;
	private String indirizzo;
	private ArrayList<Motorino> immatricolati;
	
	public Motorizzazione(String identificatore,String indirizzo){
		this.identificativo=identificatore;
		this.indirizzo=indirizzo;
		this.immatricolati=new ArrayList();
	}
	
	public void addMotorini(Motorino x) {
		this.immatricolati.add(x);
	}
	
	public void removeMotorini(Motorino x) {
		this.immatricolati.remove(x);
	}
	
	public ArrayList<Motorino> getMoto(){
		ArrayList<Motorino> Moto=new ArrayList();
		for(int i=0;i<this.immatricolati.size();i++) {
			if((this.immatricolati.get(i)).getCilindrata()>=150)
				Moto.add(this.immatricolati.get(i));
		}
		return Moto;
	}

	public ArrayList<Motorino> getCiclomotori(){
		ArrayList<Motorino> Ciclomotori=new ArrayList();
		for(int i=0;i<this.immatricolati.size();i++) {
			if((this.immatricolati.get(i)).getCilindrata()<150)
				Ciclomotori.add(this.immatricolati.get(i));
		}
		return Ciclomotori;
	}
	
	public ArrayList<Motorino> getAllarmati(){
		ArrayList<Motorino> Allarmati=new ArrayList();
		for(int i=0;i<this.immatricolati.size();i++) {
			if((this.immatricolati.get(i)).isAntifurto()==true)
				Allarmati.add(this.immatricolati.get(i));
		}
		return Allarmati;
	}
	

	
}
