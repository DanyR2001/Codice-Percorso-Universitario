import java.time.LocalTime;

public class DispositivoIoT {
	private LocalTime OrarioA;
	private LocalTime OrarioS;
	private double ConsumoH;
	private boolean Stato;

	public DispositivoIoT(double consumoH) {
		OrarioA = LocalTime.now();
		OrarioS = null;
		ConsumoH = consumoH;
		Stato = true;
	}

	public DispositivoIoT(LocalTime orarioA, double consumoH) {
		OrarioA = orarioA;
		OrarioS = null;
		ConsumoH = consumoH;
		Stato = true;
	}

	public DispositivoIoT(double consumoH, int timeToPoweroff) {
		OrarioA = LocalTime.now();
		LocalTime x = LocalTime.now().plusHours(timeToPoweroff);
		OrarioS = x;
		ConsumoH = consumoH;
		Stato = true;
	}

	public DispositivoIoT(LocalTime orarioA, LocalTime orarioS, double consumoH, boolean stato) {
		OrarioA = orarioA;
		OrarioS = orarioS;
		ConsumoH = consumoH;
		Stato = stato;
	}

	public DispositivoIoT(double consumoH, LocalTime orarioS) {
		OrarioA = LocalTime.now();
		OrarioS = orarioS;
		ConsumoH = consumoH;
		Stato = true;
	}

	public boolean isActive() {
		return Stato;
	}

	public void Spegni() {
		if (this.isActive())
			Stato = false;
	}

	public void Accendi() {
		Stato = true;
	}

	@Override
	public String toString() {
		return " OrarioA=" + OrarioA + ", OrarioS=" + OrarioS + ", ConsumoH=" + ConsumoH + ", Stato=" + Stato + "\n";
	}

	public boolean equals(DispositivoIoT d) {
		if (d instanceof DispositivoIoT) {
			return d.getConsumoH() == this.ConsumoH && d.getOrarioA().equals(this.OrarioA)
					&& d.getOrarioS().equals(this.OrarioS);
		}
		return false;
	}

	public void setPoweroffAfret2hour() {
		LocalTime off = LocalTime.now();
		if (off.compareTo(OrarioA.plusHours(2)) < 0)
			this.Spegni();
	}

	public LocalTime getOrarioA() {
		return OrarioA;
	}

	public void setOrarioA(LocalTime orarioA) {
		OrarioA = orarioA;
	}

	public LocalTime getOrarioS() {
		return OrarioS;
	}

	public void setOrarioS(LocalTime orarioS) {
		OrarioS = orarioS;
	}

	public double getConsumoH() {
		return ConsumoH;
	}

	public void setConsumoH(double consumoH) {
		ConsumoH = consumoH;
	}

	public boolean isStato() {
		return Stato;
	}

	public void setStato(boolean stato) {
		Stato = stato;
	}

}
