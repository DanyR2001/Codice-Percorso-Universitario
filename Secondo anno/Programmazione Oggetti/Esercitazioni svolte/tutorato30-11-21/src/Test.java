import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		File f=new File("file.dat");
		AgendaMultimediale all = null;
		System.out.println("aspe");
		
		if(f.exists()) {
			System.out.println("essite");

			try {
				ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
				all=(AgendaMultimediale) in.readObject();
				in.close();
			} catch (ClassNotFoundException e) {
				System.out.println("no trovata");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("a caso");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("No esiste");

			all=new AgendaMultimediale();
			
			all.addSMS(1,"Mario",new GregorianCalendar(),"ciao");
			all.addSMS(2,"Faro",new GregorianCalendar(),"ciao1");
			all.addSMS(3,"Calo",new GregorianCalendar(),"ciao2");
			all.addSMS(4,"Palo",new GregorianCalendar(1919,1,1),"ciao3");
			
			
			try {
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f));
				out.writeObject(all);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(all.getListBySender().toString());
		System.out.println(all.getListByDate().toString());
		all.toPrint();
	}

}
