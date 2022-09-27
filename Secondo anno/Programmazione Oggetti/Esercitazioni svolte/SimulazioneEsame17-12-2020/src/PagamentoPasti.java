import java.io.Serializable;
import java.util.ArrayList;

public class PagamentoPasti implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3568308992193566125L;
	private ArrayList<Tesserino> list;
	private double SommaStudenti; 
	
	public PagamentoPasti() {
		list= new  ArrayList<>();
		SommaStudenti=0;
	}
	
	public void addTesserino(Tesserino t){
		list.add(t);
	}
	
	boolean usaTesserino(String code) throws TesserinoNonAttivoException, TesserinoScadutoException {
		if(list.isEmpty())
			return false;
		boolean flag=true;
		for(int i=0;i<list.size()&&flag;i++) {
			Tesserino t=list.get(i);
			if(t.equals(code)) {
				flag=false;
				if(t instanceof TesserinoPersonale) {
					TesserinoPersonale x=(TesserinoPersonale) t;
					x.paga();
				}
				else if(t instanceof TesserinoStudente) {
					TesserinoStudente x=(TesserinoStudente) t;
					SommaStudenti+=x.calcolaPrezzo();
					x.paga();
				}
				else
					return false;
			}
		}
		if(flag)
			return false;
		return true;
	}
	
	public double calcolaTotale() {
		double somma=0;
		for(int i=0;i<list.size();i++) {
			Tesserino t=list.get(i);
				if(t instanceof TesserinoPersonale) {
					TesserinoPersonale x=(TesserinoPersonale) t;
					somma+= x.getSommaSpesa();
				}
			}
		return somma+SommaStudenti;
	}
	
	
}
