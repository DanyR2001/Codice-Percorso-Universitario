import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

public class PartitaBasket extends Partita {
	private int NumOvertime;
	
	public PartitaBasket(Squadra u, Squadra d, GregorianCalendar x) throws IOException {
		super(u, d, x);
		// TODO Auto-generated constructor stub
	}

	public PartitaBasket(Squadra u, Squadra d, String risutato, GregorianCalendar x) throws IOException {
		super(u, d, risutato, x);
		// TODO Auto-generated constructor stub
	}
	
	public void gioca() {
		Random random= new Random();
		int punteggioPrima= random.nextInt(20);
		punteggioPrima+=60;
		int punteggioSeconda= random.nextInt(20);
		punteggioSeconda+=60;
		if(punteggioPrima==punteggioSeconda) {
			while(punteggioPrima==punteggioSeconda) {
				int xPrima= random.nextInt(20);
				punteggioPrima+=xPrima;
				int xSeconda= random.nextInt(20);
				punteggioSeconda+=xSeconda;
				NumOvertime++;
			}
		}
		if(punteggioPrima<punteggioSeconda) {
			super.getDue().addPunti(2);
			super.getDue().playedGame();
			super.getUno().playedGame();
		}
		else {
			super.getUno().addPunti(2);
			super.getDue().playedGame();
			super.getUno().playedGame();
		}
	}

}
