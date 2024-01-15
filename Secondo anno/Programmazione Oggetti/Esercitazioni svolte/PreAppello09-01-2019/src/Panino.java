import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Panino implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4255609564133796811L;
	final List<Alimento> Step1 = Arrays.asList(new Alimento("classic bun", 10, "pane", 1),new Alimento("italian bun", 15, "pane", 1),new Alimento("duce bun", 69, "pane", 1));
	final List<Alimento> Step2 = Arrays.asList(new Alimento("pollo", 10, "carne", 2),new Alimento("geyvegetariano", 15, "vegetariano", 2),new Alimento("geyvegano", 15, "vegano", 2));
	final List<Alimento> Step3 = Arrays.asList(new Alimento("pecorino", 40, "formaggi", 3),new Alimento("parmigino", 55, "formaggi", 3),new Alimento("feta", 5, "formaggi", 3));
	final List<Alimento> Step4 = Arrays.asList(new Alimento("melanzane", 10, "farciture", 4),new Alimento("zicchine", 15, "farciture", 4),new Alimento("uovo", 15, "farciture", 4));
	final List<Alimento> Step5 = Arrays.asList(new Alimento("funghi", 10, "verdure", 5),new Alimento("pomodori", 15, "verdure", 5),new Alimento("anelli di cipolla", 15, "verdure", 5));
	private String Nome;
	private ArrayList<Alimento> lista;
	
	public Panino(String Nome) {
		this.Nome=Nome;
		lista=new ArrayList<>();
	}
	
	public void add(Alimento x) throws IOException {
		if(lista.isEmpty())
			lista.add(x);
		else {
			for(int i=0;i<lista.size();i++) {
				if(lista.get(i).getStep()==x.getStep())
					throw new IOException("Panini");
			}
			lista.add(x);
		}
	}
	
	public String toString() {
		String x="";
		x+=Nome;
		if(lista.isEmpty())
			x+="\n	Panino vuoto.\n";
		else{
			x+="	Lista degli ingredienti:\n";
			for(int i=0;i<lista.size();i++) 
				x+="		"+lista.get(i).getNome()+",\n";
		}
		return x;
	}
	
	public double calcolaCosto() {
		double x=0;
		if(!lista.isEmpty()) {
			for(int i=0;i<lista.size();i++)
				x+=lista.get(i).getCosto();
			return x;
		}
		return 0;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public ArrayList<Alimento> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Alimento> lista) {
		this.lista = lista;
	}
	
}
