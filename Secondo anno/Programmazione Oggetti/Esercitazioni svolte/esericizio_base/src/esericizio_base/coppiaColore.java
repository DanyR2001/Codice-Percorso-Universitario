package esericizio_base;
import java.awt.Color;

public class coppiaColore<S extends Colore, T extends Colore> {
	private S primo;
	private T secondo;
	
	public coppiaColore(S primo,T secondo) {
		this.primo=primo;
		this.secondo=secondo;
	}
	
	void coloraTutti(Color s) {
		primo.setColore(s);
		secondo.setColore(s);
	}
	
	public S getPrimo(){
		return primo;
	}
	
	public T getSecondo() {
		return secondo;
	}
	
}
