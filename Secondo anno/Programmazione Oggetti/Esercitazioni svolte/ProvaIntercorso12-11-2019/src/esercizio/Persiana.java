package esercizio;
import java.time.LocalTime;

public class Persiana extends DispositivoIoT {
	private String Materiale;

	public Persiana(String materiale) {
		super(0.15, LocalTime.of(21, 30));
		Materiale = materiale;
		// TODO Auto-generated constructor stub
	}

	public Persiana(LocalTime orarioA, String materiale) {
		super(orarioA, LocalTime.of(21, 30), 0.15, true);
		Materiale = materiale;
		// TODO Auto-generated constructor stub
	}

	public Persiana(LocalTime orarioA, LocalTime orarioS, boolean stato, String materiale) {
		super(orarioA, orarioS, 0.15, stato);
		Materiale = materiale;
		// TODO Auto-generated constructor stub
	}

	public boolean equals(DispositivoIoT d) {
		if (d instanceof Persiana) {
			Persiana x = (Persiana) d;
			return x.getMateriale().equals(this.Materiale) && super.equals(d);
		} else
			return false;
	}

	public String getMateriale() {
		return Materiale;
	}

	public void setMateriale(String materiale) {
		Materiale = materiale;
	}

	@Override
	public String toString() {
		return "Persiana: Materiale=" + Materiale + " " + super.toString();
	}

}
