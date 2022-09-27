import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

public class PartitaCalcio extends Partita {
	
	private double Costo;

	public PartitaCalcio(Squadra u, Squadra d, GregorianCalendar x,double costo) throws IOException {
		super(u, d, x);
		Costo=costo;
		// TODO Auto-generated constructor stub
	}

	public PartitaCalcio(Squadra u, Squadra d, String risutato, GregorianCalendar x,double costo) throws IOException {
		super(u, d, risutato, x);		
		Costo=costo;
		// TODO Auto-generated constructor stub
	}
	
	public void gioca() {
		Random random= new Random();
		int punteggioPrima= random.nextInt(10);
		int punteggioSeconda= random.nextInt(10);
		if(punteggioPrima==punteggioSeconda) {
			super.getDue().addPunti(1);
			super.getUno().addPunti(1);
			super.getDue().playedGame();
			super.getUno().playedGame();
			super.getUno().subBudget(Costo/2);
			super.getDue().subBudget(Costo/2);
		}
		else if(punteggioPrima<punteggioSeconda) {
			super.getDue().addPunti(3);
			super.getDue().playedGame();
			super.getUno().playedGame();
			super.getUno().subBudget((Costo/3)*2);
			super.getDue().subBudget(Costo/3);
		}
		else {
			super.getUno().addPunti(3);
			super.getDue().playedGame();
			super.getUno().playedGame();
			super.getUno().subBudget(Costo/3);
			super.getDue().subBudget((Costo/3)*2);
		}
	}

}
