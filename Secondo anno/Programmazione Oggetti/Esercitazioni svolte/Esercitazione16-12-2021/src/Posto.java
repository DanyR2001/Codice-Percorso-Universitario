import java.util.Objects;

public class Posto {
	private int NumFila;
	private char Lettera;
	private boolean Stato;
	
	public Posto(int numFila, char lettera, boolean stato) {
		NumFila = numFila;
		Lettera = lettera;
		Stato = stato;
	}

	public int getNumFila() {
		return NumFila;
	}

	public void setNumFila(int numFila) {
		NumFila = numFila;
	}

	public char getLettera() {
		return Lettera;
	}

	public void setLettera(char lettera) {
		Lettera = lettera;
	}

	public boolean isStato() {
		return Stato;
	}

	public void setStato(boolean stato) {
		Stato = stato;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Posto other = (Posto) obj;
		return Lettera == other.Lettera && NumFila == other.NumFila && Stato == other.Stato;
	}

	@Override
	public String toString() {
		return "	Posto: " + NumFila + " " + Lettera ;
	}
	
	public Posto clone() {
		return new Posto(this.NumFila,this.Lettera,this.Stato);
	}
	
	
	/*
	numero di fila, una lettera indicante la posizione nella fila e uno stato 
	*/
}
