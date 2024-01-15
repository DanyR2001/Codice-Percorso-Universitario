import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File x=new File("automezzi.dat");
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(x));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArchivioAutomezzi temp=new ArchivioAutomezzi();
		temp.addAuto(new Autoveicolo("2m","audi", "AA123AA", 1982, "BENZINA", 3, 5));
		temp.addMoto(new Motociclo("2c","ktm", "AA12345", 1952, 2, 2));
	
		try {
			out.writeObject(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
