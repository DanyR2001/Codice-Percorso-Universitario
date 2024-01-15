package noleggio;

public class Film {
	private String Code;
	private String Titolo;
	
	public Film(String code,String titolo){
		Code=code;
		Titolo=titolo;
	}
	
	public String dammiCodice() {
		return Code;
	}
	
	public void setCode(String code) {
		Code = code;
	}
	
	public String dammiTitolo() {
		return Titolo;
	}
	
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	
	public double calcolaPenaleRitardo(int num) {
		return 2*num;
	}
	
	public String toString() {
		return "Titolo :"+Titolo+", Codice: "+Code+" ";
	}
	
	public boolean equals(Film x) {
		return this.Code.equals(x.dammiCodice())&&this.Titolo.equals(x.dammiTitolo());
	}
	
	public Film clone() {
		Film x=new Film(this.Code,this.Titolo);
		return x;
	}
	
}
