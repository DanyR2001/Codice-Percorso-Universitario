import java.util.ArrayList;

public class ElencoArticoli {
	private ArrayList<Articolo> Catalogo;
	
	public ElencoArticoli() {
		Catalogo=new ArrayList<>();
	}
	
	public ElencoArticoli(ArrayList<Articolo> catalogo) {
		Catalogo=catalogo;
	}
	
	public void addArticolo(Articolo x) {
		Catalogo.add(x);
	}
	
	public Articolo getArticolo(double x) {
		int temp = 0;
		double tmp=0;
		double min=Math.abs(Catalogo.get(0).getPrezzo()-x);
		for(int i=0;i<Catalogo.size();i++) {
			tmp=Math.abs(Catalogo.get(i).getPrezzo()-x);
			if(min>tmp)
				temp=i;
		}
		return Catalogo.get(temp);
	}
	
	public ArrayList<Articolo> cerca(String p){
		ArrayList<Articolo> temp = new ArrayList<>();
		for(int i=0; i<Catalogo.size();i++) {
			if(Catalogo.get(i).getProvenienza().equals(p))
				temp.add(Catalogo.get(i));
		}
		if(temp.isEmpty())
			return null;
		else
			return temp;
	}
	
	public double dammiTotale() {
		double x=0;
		for(int i=0; i<Catalogo.size();i++) {
			x+=Catalogo.get(i).getPrezzo();
		}
		return x;
	}

	public ArrayList<Articolo> getCatalogo() {
		return Catalogo;
	}

	public void setCatalogo(ArrayList<Articolo> catalogo) {
		Catalogo = catalogo;
	}

	@Override
	public String toString() {
		String x= "ElencoArticoli Catalogo=\n" ;
		for(int i=0;i<Catalogo.size();i++)
			x+=Catalogo.get(i).toString()+"\n";
	return x;
	}
	
}
