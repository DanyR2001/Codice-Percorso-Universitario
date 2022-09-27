import java.io.Serializable;
import java.util.InputMismatchException;

public class Automezzo implements Serializable{
	public Automezzo(String modello, String marca, String targa, int anno) {
		if(!checkTarga(targa))
			throw new InputMismatchException("errore");
		Modello = modello;
		Marca = marca;
		Targa = targa;
		Anno = anno;
	}
	
	public boolean checkTarga(String x) {
		if(x.length()!=7) {
			throw new TargaErrataException("Formato non valido valido");
		}
		return true;
	}
	
	public String getModello() {
		return Modello;
	}
	public void setModello(String modello) {
		Modello = modello;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getTarga() {
		return Targa;
	}
	public void setTarga(String targa) {
		Targa = targa;
	}
	public int getAnno() {
		return Anno;
	}
	public void setAnno(int anno) {
		Anno = anno;
	}
	private String Modello;
	private String Marca;
	private String Targa;
	private int Anno;
}
