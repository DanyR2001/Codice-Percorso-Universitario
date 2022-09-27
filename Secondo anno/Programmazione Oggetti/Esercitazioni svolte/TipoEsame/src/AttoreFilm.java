import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AttoreFilm extends Attore {
	private int NumFilm;
	private ArrayList<String> listFilm;
	
	public AttoreFilm(String nome, String cognome, Date dataNascita, int numFilm, ArrayList<String> listFilm) {
		super(nome, cognome, dataNascita);
		if(numFilm<0)
			throw new NumNotPositiveException();
		NumFilm = numFilm;
		this.listFilm = listFilm;
	}
	
	public AttoreFilm(String nome, String cognome, Date dataNascita) {
		super(nome, cognome, dataNascita);
		NumFilm = 0;
		this.listFilm = new ArrayList<>();
	}
	
	public int getNumFilm() {
		return NumFilm;
	}

	public void setNumFilm(int numFilm) {
		NumFilm = numFilm;
	}

	public ArrayList<String> getListFilm() {
		return listFilm;
	}

	public void setListFilm(ArrayList<String> listFilm) {
		this.listFilm = listFilm;
	}
	
	public void addFilm(String film) {
		listFilm.add(film);
		NumFilm++;
	}
	
	public double getCompenso(int x) {
		return x*NumFilm;
	}

	public String toString() {
		return "AttoreFilm: "+super.toString()+" NumFilm=" + NumFilm + ", listFilm=" + listFilm + ", \n";
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof AttoreFilm)) {
			return false;
		}
		AttoreFilm other = (AttoreFilm) obj;
		return NumFilm == other.NumFilm && listFilm.equals(other.getListFilm())&&equals(obj);
	}
	
	public AttoreFilm clone() {
		return new AttoreFilm(getNome(), getCognome(), getDataNascita(),NumFilm,(ArrayList<String>)listFilm.clone());
	}
	
	

}
