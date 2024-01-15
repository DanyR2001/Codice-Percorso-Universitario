import java.io.Serializable;
import java.util.GregorianCalendar;

public class Prenotazione implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3239849583874806980L;
	private GregorianCalendar in;
	private GregorianCalendar out;
	private Cliente x;
	private Stanza y;
	
	public Prenotazione(GregorianCalendar in, GregorianCalendar out, Cliente x, Stanza y) {
		this.in = in;
		this.out = out;
		this.x = x;
		this.y = y;
	}
	public GregorianCalendar getIn() {
		return in;
	}
	public void setIn(GregorianCalendar in) {
		this.in = in;
	}
	public GregorianCalendar getOut() {
		return out;
	}
	public void setOut(GregorianCalendar out) {
		this.out = out;
	}
	public Cliente getX() {
		return x;
	}
	public void setX(Cliente x) {
		this.x = x;
	}
	public Stanza getY() {
		return y;
	}
	public void setY(Stanza y) {
		this.y = y;
	}
	
	public boolean equals(Prenotazione x) {
		if(this.in.equals(x.getIn())&&this.out.equals(x.getOut())&&this.y.equals(x.getY())&&this.x.equals(x.getX()))
			return true;
		else
			return false;
	}

}
