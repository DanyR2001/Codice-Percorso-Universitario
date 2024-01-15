import java.time.LocalTime;
import java.util.ArrayList;

public class SistemaDomotico {
	private ArrayList<DispositivoIoT> lista;
	private double MAX_CONSUMI;

	public SistemaDomotico(double max) {
		lista = new ArrayList<>();
		MAX_CONSUMI = max;
	}

	public void aggiungiDispositivo(DispositivoIoT d) {
		lista.add(d);
	}

	public DispositivoIoT findDisp(DispositivoIoT x) {
		DispositivoIoT ret = null;
		for (int i = 0; i < lista.size(); i++)
			if (lista.get(i).equals(x))
				ret = lista.get(i);
		return ret;
	}

	public boolean programmaAccensione(DispositivoIoT d, LocalTime oraAccensione) {
		if (this.findDisp(d) != null) {
			this.findDisp(d).setOrarioA(oraAccensione);
			return true;
		}
		return false;
	}

	public boolean programmaSpegnimento(DispositivoIoT d, LocalTime oraSpegnimento) {
		if (this.findDisp(d) != null) {
			this.findDisp(d).setOrarioS(oraSpegnimento);
			return true;
		}
		return false;
	}

	public void attivaRisparmioEnergetico() {
		for (DispositivoIoT d : lista)
			d.setPoweroffAfret2hour();
	}

	public double controllaConsumo() {
		double som = 0;
		for (DispositivoIoT d : lista)
			if (d.isActive()) {
				som += d.getConsumoH();
			}
		return som;
	}

	private int findMaxCons() {
		int temp = 0;
		double max = 0;
		for (int i = 0; i < lista.size(); i++)
			if (max < lista.get(i).getConsumoH() && lista.get(i).isActive()) {
				max = lista.get(i).getConsumoH();
				temp = i;
			}
		return temp;
	}

	public void sendExceotion() throws MaximumLimitedExceededException {
		throw new MaximumLimitedExceededException();
	}

	public void control() throws MaximumLimitedExceededException {
		while (this.controllaConsumo() > MAX_CONSUMI) {
			lista.get(this.findMaxCons()).Spegni();
		}
		sendExceotion();
	}

	public String toString() {
		String temp = "";
		for (DispositivoIoT d : lista) {
			temp += d.toString();
		}
		return temp;
	}

	public double getMAX_CONSUMI() {
		return MAX_CONSUMI;
	}

	public void setMAX_CONSUMI(double mAX_CONSUMI) {
		MAX_CONSUMI = mAX_CONSUMI;
	}

	public String returnType(int i) {
		String ret = "";
		for (DispositivoIoT d : lista) {
			if (i == 0) {
				if (d instanceof LampadinaRGB)
					if (d.isActive())
						ret += d.toString();
			}
			if (i == 1) {
				if (d instanceof Climatizzatore)
					if (d.isActive())
						ret += d.toString();
			}
			if (i == 2) {
				if (d instanceof Persiana)
					if (d.isActive())
						ret += d.toString();
			}
		}
		if (ret.length() == 0)
			return "Nessun elemento";
		return ret;

	}

	public String returnAllActive() {
		String ret = "";
		for (DispositivoIoT d : lista) {
			if (d.isActive())
				ret += d.toString();
		}
		if (ret.length() == 0)
			return "Nessun elemento";
		return ret;

	}

}
