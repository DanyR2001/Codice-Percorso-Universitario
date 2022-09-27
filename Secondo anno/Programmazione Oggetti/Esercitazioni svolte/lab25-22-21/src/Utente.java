public class Utente {
	private String Nome;
	private String Cognome;
	private String Login;
	private String Password;
	
	static boolean testSpace(String x) {
		boolean flag=true;
		for(int i=0;i<x.length();i++)
			if(x.charAt(i)==' ')
				flag=false;
		return flag;
	}
	
	public Utente(String nome,String cognome,String login,String password) {
		if(password.length()<5||testSpace(password)==false||password.length()<0||password==null)
			throw new IllegalArgumentException("Password error format");
		if(login.length()<5||testSpace(login)==false||login.length()<0||login==null)
			throw new IllegalArgumentException("Login error format");
		if(nome.length()<0||nome==null)
			throw new IllegalArgumentException("Nome error format");
		if(cognome.length()<0||cognome==null)
			throw new IllegalArgumentException("Cognome error format");
		Nome=nome;
		Cognome=cognome;
		Password=password;
		Login=login;
	}
}
