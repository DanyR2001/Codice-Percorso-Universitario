import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ArchivioAutomezzi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7791338703157289542L;
	private ArrayList<Automezzo> lista;
	
	public ArchivioAutomezzi() {
		lista=new ArrayList();
	}
	
	public void addMoto(Motociclo x) {
		lista.add(x);
	}
	
	public void addAuto(Autoveicolo x) {
		lista.add(x);
	}

	public ArrayList<Automezzo> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Automezzo> lista) {
		this.lista = lista;
	}
	
	public String toString() {
		String x = "";
		for(int i=0;i<lista.size();i++) {
			x+=" marca: "+lista.get(i).getMarca()+" modello:"+lista.get(i).getModello()+" anno:"+lista.get(i).getAnno();
			if(lista.get(i) instanceof Autoveicolo) {
				Autoveicolo temp=(Autoveicolo)lista.get(i);
				x+=" alimentazine:"+temp.getAlimentazione()+" numero posti:"+temp.getNumeroPosti()+" numero porte:"+temp.getNumeroPorte()+" \n";
			}
			else if(lista.get(i) instanceof Motociclo) {
				Motociclo temp2=(Motociclo) lista.get(i);
				x+=" numero di passeggeri:"+temp2.getNumeroDiPasseggeri()+" numero di ruote:"+temp2.getNumeroDiRuote()+" \n";
			}	
		}
		return x;
	}
	
}
