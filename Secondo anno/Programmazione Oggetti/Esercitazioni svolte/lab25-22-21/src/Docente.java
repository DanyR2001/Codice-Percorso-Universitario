
public class Docente extends Utente{
	private int NumStudio;
	private String Dipartimento;
	
	public Docente(String nome,String cognome,String login,String password,int numStudio,String dipartimento) {
		super(nome,cognome,login,password);
		if(numStudio<=0)
			throw new IllegalArgumentException("Numero dello studio del docente error");
		if(dipartimento.length()==0||dipartimento==null)
			throw new IllegalArgumentException("Dipartimento error");
		NumStudio=numStudio;
		Dipartimento=dipartimento;
	}
	
}
