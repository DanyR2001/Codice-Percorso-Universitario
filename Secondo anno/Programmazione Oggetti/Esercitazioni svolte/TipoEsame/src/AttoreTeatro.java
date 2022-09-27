import java.util.Date;
import java.util.Objects;

public class AttoreTeatro extends Attore {
	private int NumSpettacoli;
	private String CompagniaTeatrale;
	
	public AttoreTeatro(String nome, String cognome, Date dataNascita, int numSpettacoli, String compagniaTeatrale) {
		super(nome, cognome, dataNascita);
		if(NumSpettacoli<0)
			throw new NumNotPositiveException();
		NumSpettacoli = numSpettacoli;
		CompagniaTeatrale = compagniaTeatrale;
	}
	
	public AttoreTeatro(String nome, String cognome, Date dataNascita, String compagniaTeatrale) {
		super(nome, cognome, dataNascita);
		NumSpettacoli = 0;
		CompagniaTeatrale = compagniaTeatrale;
	}
	
	public void addSpettacolo() {
		NumSpettacoli++;
	}
	
	public double getCompenso(int x) {
		return NumSpettacoli*x;
	}

	public int getNumSpettacoli() {
		return NumSpettacoli;
	}

	public void setNumSpettacoli(int numSpettacoli) {
		NumSpettacoli = numSpettacoli;
	}

	public String getCompagniaTeatrale() {
		return CompagniaTeatrale;
	}

	public void setCompagniaTeatrale(String compagniaTeatrale) {
		CompagniaTeatrale = compagniaTeatrale;
	}

	public String toString() {
		return "AttoreTeatro:"+super.toString()+" NumSpettacoli=" + NumSpettacoli + ", CompagniaTeatrale=" + CompagniaTeatrale + "\n";
	}
	
	public AttoreTeatro clone() {
		return new AttoreTeatro(getNome(), getCognome(), getDataNascita(), NumSpettacoli, CompagniaTeatrale);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof AttoreTeatro)) {
			return false;
		}
		AttoreTeatro other = (AttoreTeatro) obj;
		return Objects.equals(CompagniaTeatrale, other.CompagniaTeatrale) && NumSpettacoli == other.NumSpettacoli&&super.equals(obj);
	}

}
