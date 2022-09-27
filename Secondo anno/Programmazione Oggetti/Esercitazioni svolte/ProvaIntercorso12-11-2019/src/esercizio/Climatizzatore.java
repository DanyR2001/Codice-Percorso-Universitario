package esercizio;
import java.time.LocalTime;

public class Climatizzatore extends DispositivoIoT {
	private double IndicatoreTemp;

	public Climatizzatore(double indicatoreTemp) {
		super(0.3, 2);
		IndicatoreTemp = indicatoreTemp;
		// TODO Auto-generated constructor stub
	}

	public Climatizzatore(LocalTime orarioA, double indicatoreTemp) {
		super(orarioA, 0.3);
		IndicatoreTemp = indicatoreTemp;
		// TODO Auto-generated constructor stub
	}

	public Climatizzatore(LocalTime orarioA, LocalTime orarioS, boolean stato, double indicatoreTemp) {
		super(orarioA, orarioS, 0.3, stato);
		IndicatoreTemp = indicatoreTemp;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Climatizzatore :IndicatoreTemp=" + IndicatoreTemp + " " + super.toString();
	}

	public boolean equals(DispositivoIoT d) {
		if (d instanceof Climatizzatore) {
			Climatizzatore x = (Climatizzatore) d;
			return x.getIndicatoreTemp() == this.IndicatoreTemp && super.equals(d);
		} else
			return false;
	}

	public double getIndicatoreTemp() {
		return IndicatoreTemp;
	}

	public void setIndicatoreTemp(double indicatoreTemp) {
		IndicatoreTemp = indicatoreTemp;
	}
}
