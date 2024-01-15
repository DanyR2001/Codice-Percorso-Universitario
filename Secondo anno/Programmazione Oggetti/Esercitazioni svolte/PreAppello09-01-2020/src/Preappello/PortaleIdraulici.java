package Preappello;

import java.util.ArrayList;

public class PortaleIdraulici {
	private ArrayList<Idraulico> lista;
	
	public PortaleIdraulici() {
		lista = new ArrayList<>();
	}
	
	public void add(Idraulico x) {
		lista.add(x);
	}
	
	public Idraulico MaxRepair() {
		int max=0,index=0;
		for(int i=0;i<lista.size();i++)
			if(max<lista.get(i).getNumInterv()) {
				max=lista.get(i).getNumInterv();
				index=i;
			}
		return lista.get(index);
	}
	
	public void addInterv(String mat,String marca,int voto) throws IdraulicoNonAbilitatoException{
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getMatricola().equals(mat)) {
				if(lista.get(i) instanceof TecnicoCaldaia) {
					TecnicoCaldaia x=(TecnicoCaldaia) lista.get(i);
					x.effetuaInterv(marca, voto);
				}
				else
					throw new IdraulicoNonAbilitatoException();
			}
	}
	
	public ArrayList<Idraulico> getIdrauliciPerMarche(String x){
		ArrayList<Idraulico> temp=new ArrayList<>();
		for(int i=0;i<lista.size();i++) {
			if(lista.get(i) instanceof TecnicoCaldaia) {
				TecnicoCaldaia y=(TecnicoCaldaia) lista.get(i);
				if(y.isTecnicoPerMarca(x))
					temp.add(y);
			}
		}
		if(temp.isEmpty())
			return null;
		return temp;
	}
	
	/*
	 • aggiungere un idraulico al portale.
• effettuare un intervento su un impianto o caldaia da parte di un idraulico presente sul portale data la
sua matricola. Lanciare l’eccezione controllata IdraulicoNonAbilitatoException se viene
chiesto di effettuare un intervento su una caldaia ad un idraulico che non è un tecnico di caldaia. 
• recuperare l’idraulico che ha effettuato più interventi.
	 * */
}
