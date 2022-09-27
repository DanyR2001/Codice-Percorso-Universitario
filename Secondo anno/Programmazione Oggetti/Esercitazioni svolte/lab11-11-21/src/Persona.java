public class Persona {
	private String Nome;
	private String Cognome;
	private String Data;
	
	public Persona(String nome,String cognome,String data) {
		Nome=nome;
		Cognome=cognome;
		Data=data;
	}
	public String toString() {
		return "Nome: "+Nome+", Cognome: "+Cognome+", Data di nascita:"+Data;
	}
}
