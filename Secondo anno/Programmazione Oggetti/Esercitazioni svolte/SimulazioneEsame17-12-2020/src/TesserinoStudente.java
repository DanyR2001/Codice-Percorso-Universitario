import java.io.Serializable;
import java.util.Date;

public class TesserinoStudente extends Tesserino implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6518508949908295889L;
	private String Matricola;
	private Date Scadenza;
	private double Saldo;
	private char Fascia;
	private boolean Bonus;
	
	public TesserinoStudente(String codice, String nome, String cognome, boolean stato, String matricola,Date scadenza,double saldo,char fascia, boolean bonus) {
		super(codice, nome, cognome, stato);
		Matricola=matricola;
		Scadenza=scadenza;
		Saldo=saldo;
		Fascia=fascia;
		Bonus=bonus;
		// TODO Auto-generated constructor stub
	}
	
	public double calcolaPrezzo() throws TesserinoNonAttivoException {
		if(this.isActive()) {
			if(Fascia=='A') {
				return 2.5;
			}
			else if(Fascia=='B') {
				if(Bonus)
					return 0.5;
				else
					return 1.5;
			}
		}
		throw new TesserinoNonAttivoException();
	}
	
	public boolean isBonus() {
		return Bonus;
	}
	
	public double paga() throws TesserinoScadutoException, TesserinoNonAttivoException {
		Date now=new Date();
		if(!this.isActive())
			throw new TesserinoNonAttivoException();
		if(Scadenza.before(now)) {
			//System.out.print(" data obj"+Scadenza+", act"+now);
			throw new TesserinoScadutoException();
		}
		if(calcolaPrezzo()>Saldo)
			throw new SaldoInsufficienteException();
		Saldo-=calcolaPrezzo();
		return calcolaPrezzo();
	}
	
	public void versa(double x) {
		if(x<1) {
			throw new RuntimeException();
		}
		Saldo+=x;
	}

}
