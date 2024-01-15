import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

public class Create_file {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Albergo x=new Albergo();
		try {
			x.addCliente("Daniele","Russo","+39 3466787026","1234567812345678");
			x.addCliente("Marco","Cracco","+39 1235644357","1234567812345678");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x.addStanza(1,1,"Singola","Aria Condizionata",11111111);
		x.addStanza(2,1,"Multipla","Aria Condizionata",11111112);
		try {
			x.addPrenotazione(x.getClienti().get(0),x.getStanze().get(0), new GregorianCalendar(), new GregorianCalendar(2021,12,15));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File create=new File("dati.dat");
		Albergo_file y=new Albergo_file(x);
		try {
			y.Save(create);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
