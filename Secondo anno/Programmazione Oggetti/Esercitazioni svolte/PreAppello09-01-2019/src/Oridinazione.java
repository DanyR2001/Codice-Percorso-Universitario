import java.io.Serializable;
import java.util.ArrayList;

public class Oridinazione implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2257913279371698010L;
	private ArrayList<Panino> lista;
	private int NumOrdinazione;

	public Oridinazione(int numOrdinazione) {
		lista=new ArrayList<>();
		NumOrdinazione=numOrdinazione;
	}
	
	public void addPanino(Panino x) {
		lista.add(x);
	}
	
	public double calcolaCosto() {
		if(lista.isEmpty())
			return 0;
		double sum=0;
		for(int i=0;i<lista.size();i++)
			sum+=lista.get(i).calcolaCosto();
		return sum;
	}
	
	public String toString() {
		String x="Lista ordine:\n";
		if(lista.isEmpty())
			return null;
		for(int i=0;i<lista.size();i++)
			if(lista.get(i) instanceof Vegano)
				x+=lista.get(i).toString();
		for(int i=0;i<lista.size();i++)
			if(lista.get(i) instanceof Vegetariano)
				x+=lista.get(i).toString();
		for(int i=0;i<lista.size();i++)
			if(lista.get(i) instanceof Onnivoro)
				x+=lista.get(i).toString();
		return x;
	}
}
