import java.util.GregorianCalendar;

public class Volto extends Biometria{
	private String Foto;// (supporre che sia una stringa di 10 caratteri)
	private final static int FotoLenght =10;
	
	public Volto(String strumentoMisurazione, String foto) {
		super(strumentoMisurazione);
		if(foto.length()!=FotoLenght)
			throw new IllegalArgumentException();
		Foto=foto;
	}
	
	public String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		Foto = foto;
	}

	public boolean verifica(Biometria b) {
		if(!(b instanceof Volto))
			return false;
		int year=b.getDataCreazione().getWeekYear();
		int year2=new GregorianCalendar().getWeekYear();
		int offset=52*5;
		if(year2-year>offset)
			return false;
		return true;
	}
	
	public double similarità(Biometria b) throws WrongTypeException {
		double sum=0;
		if(!(b instanceof Volto))
			throw new WrongTypeException();
		Volto temp=(Volto) b;
		for(int i=1;i<=FotoLenght;i++) {
			if(Foto.charAt(i-1)==temp.getFoto().charAt(i-1))
				sum+=(1+(1/i));
		}
		return sum;
	}
	
	public String toString() {
		return super.toString()+"typeVolto, codiceFoto: "+Foto;
	}
	
}
