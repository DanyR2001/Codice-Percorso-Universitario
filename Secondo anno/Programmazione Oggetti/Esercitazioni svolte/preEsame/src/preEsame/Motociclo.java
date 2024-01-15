package preEsame;

public class Motociclo extends Automezzo {
	private int numeroRuote;
	private int numeroPasseggeri;

	public Motociclo(String modello, String marca, String targa, int anno, int numeroRuote, int numeroPasseggeri) throws TargaErrataException {
		super(modello, marca, targa, anno);
		this.numeroRuote = numeroRuote;
		this.numeroPasseggeri = numeroPasseggeri;
	}

	@Override
	public boolean isCorrect(String x) {
		if(x.length()==7) {
			return Character.isLetter(x.charAt(0))&&Character.isLetter(x.charAt(1))&&Character.isDigit(x.charAt(2))&&Character.isDigit(x.charAt(3))&&Character.isDigit(x.charAt(4))&&Character.isDigit(x.charAt(5))&&Character.isDigit(x.charAt(6));
		}
		return false;
	}

	@Override
	public String toString() {
		return "Motociclo [numeroRuote=" + numeroRuote + ", numeroPasseggeri=" + numeroPasseggeri + ", "
				+ super.toString() + "]";
	}

	public int getNumeroRuote() {
		return numeroRuote;
	}

	public void setNumeroRuote(int numeroRuote) {
		this.numeroRuote = numeroRuote;
	}

	public int getNumeroPasseggeri() {
		return numeroPasseggeri;
	}

	public void setNumeroPasseggeri(int numeroPasseggeri) {
		this.numeroPasseggeri = numeroPasseggeri;
	}

}
