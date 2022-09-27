
public class Student extends Utente{
	private String Matricola;
	private String[][] Esami;
	private int NumEsaSup;
	
	public Student(String nome,String cognome,String login,String password,String matricola) {
		super(nome,cognome,login,password);
		if(matricola.length()<=0||matricola==null)
			throw new IllegalArgumentException("Maricola error format");
		Matricola=matricola;
		Esami=new String[20][2];
		NumEsaSup=0;
	}
	
	public void addVoto(String NomeEsame,String Voto) {
		int value=0;
		try {
			value=Integer.parseInt(Voto);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new NumberFormatException("Voto non valido");
		}
		if(value<18)
			throw new IllegalArgumentException("Valore voto non valido");
		Esami[NumEsaSup][0]=NomeEsame;
		Esami[NumEsaSup][1]=Voto;
		NumEsaSup++;
	}
	
	public double getMediaEsami() {
		if(NumEsaSup==0)
			return 0;
		else {
			double media=0;
			for(int i=0;i<NumEsaSup;i++)
				media+=Integer.parseInt(Esami[i][1]);
			media/=NumEsaSup;
			return media;
		}
	}
}
