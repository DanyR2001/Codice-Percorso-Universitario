package preEsame;

public abstract class Automezzo {
	private String modello;
	private String marca;
	private String targa;
	private int anno;
	
	public Automezzo(String modello, String marca, String targa, int anno) throws TargaErrataException {
		this.modello = modello;
		if(this.isCorrect(targa))
			this.marca = marca;
		else
			throw new TargaErrataException();
		this.targa = targa;
		this.anno = anno;
	}
	
	public abstract boolean isCorrect(String x);

	@Override
	public String toString() {
		return "Automezzo [modello=" + modello + ", marca=" + marca + ", targa=" + targa + ", anno=" + anno + "]";
	}
	
	public boolean equalsTarga(String x) {
		return x.equals(this.targa);
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
	

}
