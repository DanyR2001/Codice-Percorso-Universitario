import java.util.Objects;

public class Articolo {
	private String Nome;
	private int Codice;
	private double Prezzo;
	private String Provenienza;
	
	public Articolo(String nome, int codice, double prezzo, String provenienza) {
		Nome = nome;
		Codice = codice;
		Prezzo = prezzo;
		Provenienza = provenienza;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getCodice() {
		return Codice;
	}
	public void setCodice(int codice) {
		Codice = codice;
	}
	public double getPrezzo() {
		return Prezzo;
	}
	public void setPrezzo(double prezzo) {
		Prezzo = prezzo;
	}
	public String getProvenienza() {
		return Provenienza;
	}
	public void setProvenienza(String provenienza) {
		Provenienza = provenienza;
	}

	public String toString() {
		return "Articolo: Nome=" + Nome + ", Codice=" + Codice + ", Prezzo=" + Prezzo + ", Provenienza=" + Provenienza;
	}

	public boolean equals(Articolo obj) {
		if(obj==null)
			return false;
		return Nome.equals(obj.getNome())&&Codice==obj.getCodice()&&Prezzo==obj.getPrezzo()&&Provenienza.equals(obj.getProvenienza());
	}
	
	public Articolo clone(){
		Articolo x=new Articolo(Nome,Codice,Prezzo,Provenienza);
		return x;
	}
	
	
}
