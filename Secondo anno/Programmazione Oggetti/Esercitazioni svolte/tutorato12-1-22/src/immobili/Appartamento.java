package immobili;

import java.util.Objects;

public class Appartamento extends Immobile {
	private int NumStanze;
	private int NumBalconi;
	
	public Appartamento(String code, String via, String proprietario, double valore, int numStanze, int numBalconi) {
		super(code, via, proprietario, valore);
		NumStanze = numStanze;
		NumBalconi = numBalconi;
	}

	public int getNumStanze() {
		return NumStanze;
	}

	public void setNumStanze(int numStanze) {
		NumStanze = numStanze;
	}

	public int getNumBalconi() {
		return NumBalconi;
	}

	public void setNumBalconi(int numBalconi) {
		NumBalconi = numBalconi;
	}

	@Override
	public String toString() {
		return "Appartamento: NumStanze=" + NumStanze + ", NumBalconi=" + NumBalconi + ", "+ super.toString() + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appartamento other = (Appartamento) obj;
			return NumBalconi == other.NumBalconi && NumStanze == other.NumStanze&&super.equals(obj);
	}
	
	public Appartamento clone() {
		return new Appartamento(getCode(), getVia(), getProprietario(), getValore(), NumStanze, NumBalconi);
	}
	
	
	
}
