package immobili;

import java.util.Objects;

public class Garadge extends Immobile {
	private int NumPost;

	public Garadge(String code, String via, String proprietario, double valore, int numPost) {
		super(code, via, proprietario, valore);
		NumPost = numPost;
	}

	public int getNumPost() {
		return NumPost;
	}

	public void setNumPost(int numPost) {
		NumPost = numPost;
	}

	@Override
	public String toString() {
		return "Garadge: NumPost=" + NumPost + ", " + super.toString() + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Garadge)) {
			return false;
		}
		Garadge other = (Garadge) obj;
		return NumPost == other.NumPost&&super.equals(obj);
	}
	
	public Garadge clone(){
		return new Garadge(getCode(), getVia(), getProprietario(), getValore(), NumPost);
	}
	
	
}
