package preEsame;

public class Autoveicolo extends Automezzo {
	private String alimentazione;
	private int numeroPorte;
	private int numeroPosti;

	public Autoveicolo(String modello, String marca, String targa, int anno, String alimentazione, int numeroPorte, int numeroPosti) throws TargaErrataException {
		super(modello, marca, targa, anno);
		this.alimentazione = alimentazione;
		this.numeroPorte = numeroPorte;
		this.numeroPosti = numeroPosti;
	}

	public boolean isCorrect(String x) {
		if(x.length()==7) {
			return Character.isLetter(x.charAt(0))&&Character.isLetter(x.charAt(1))&&Character.isDigit(x.charAt(2))&&Character.isDigit(x.charAt(3))&&Character.isDigit(x.charAt(4))&&Character.isLetter(x.charAt(5))&&Character.isLetter(x.charAt(6));
		}
		return false;
	}

	@Override
	public String toString() {
		return "Autoveicolo [alimentazione=" + alimentazione + ", numeroPorte=" + numeroPorte + ", numeroPosti="
				+ numeroPosti + "," + super.toString() + "]";
	}
	
	

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public int getNumeroPorte() {
		return numeroPorte;
	}

	public void setNumeroPorte(int numeroPorte) {
		this.numeroPorte = numeroPorte;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	

}
