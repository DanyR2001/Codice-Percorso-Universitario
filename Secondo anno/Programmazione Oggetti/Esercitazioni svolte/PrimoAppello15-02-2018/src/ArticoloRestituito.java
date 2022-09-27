import java.util.GregorianCalendar;

public class ArticoloRestituito extends Articolo {
	private String Data;
	private String Motivo;
	
	public ArticoloRestituito(String nome, int codice, double prezzo, String provenienza,String data,String motivo) {
		super(nome, codice, prezzo, provenienza);
		Data=data;
		Motivo=motivo;
		}
		
	public double getPrezzo() {
		if(Motivo.equals("danneggiato"))
			return 0;
		return super.getPrezzo();
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getMotivo() {
		return Motivo;
	}

	public void setMotivo(String motivo) {
		Motivo = motivo;
	}

	@Override
	public String toString() {
		return super.toString()+", Data=" + Data + ", Motivo=" + Motivo + " ";
	}
	
	public ArticoloRestituito clone() {
		ArticoloRestituito x=new ArticoloRestituito(super.getNome(), getCodice(), getPrezzo(), getProvenienza(), Data, Motivo);
		return x;
	}
	
	public boolean equals(ArticoloRestituito x) {
		if(x instanceof Articolo)
			return false;
		return super.equals(x)&&Data.equals(x.getData())&&Motivo.equals(x.getMotivo());
	}
}
