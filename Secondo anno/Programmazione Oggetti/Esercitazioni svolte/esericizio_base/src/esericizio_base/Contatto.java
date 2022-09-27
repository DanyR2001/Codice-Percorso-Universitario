package esericizio_base;

public class Contatto {
	private String nome;
	private String cognome;
	private String numero;
	
	public Contatto(String n,String c,String t) {
		nome=n;
		cognome=c;
		numero=t;
	}
	
	public Contatto(String n,String c) {
		nome=n;
		cognome=c;
	}
	
	public String toString() {
		String temp;
		temp=nome+","+cognome+","+numero;
		return temp;
	}
	
	public String toExport() {
		String temp="{ \"nome:\":\""+this.getNome()+"\",\""+this.getCognome()+"\",\""+this.getNumero()+"\"},";
		return temp;
	}
	
	public boolean equals(Contatto conf) {
		boolean flag=true;
		if(!this.nome.equals(conf.getNome()))
			flag=false;
		if(!this.cognome.equals(conf.getCognome()))
			flag=false;
		return flag;
	}
	
	public boolean equals(String nome,String cognome) {
		boolean flag=true;
		if(!this.nome.equals(nome))
			flag=false;
		if(!this.cognome.equals(cognome))
			flag=false;
		return flag;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
