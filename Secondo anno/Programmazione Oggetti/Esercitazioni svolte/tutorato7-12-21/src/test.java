import java.util.GregorianCalendar;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar x= new GregorianCalendar();
		Bambino y=new Bambino("Daniele",10,"Ciao",x,15,"Nord");
		System.out.println(y.toString()+", Costo: "+y.calcolaCosto());
		Adulto z=new Adulto("Masimo",x,15,"Sud");
		System.out.println(z.toString()+", Costo: "+z.calcolaCosto());
	}

}
