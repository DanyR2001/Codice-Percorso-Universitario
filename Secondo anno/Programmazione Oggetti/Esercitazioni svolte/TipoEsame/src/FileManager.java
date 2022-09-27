import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {
	private File x;
	
	public FileManager(File y) {
		x= y;
	}
	
	public FileManager(String y) {
		x= new File(y);
	}
	
	public boolean exsist() {
		return x.exists();
	}
	
	public Manager loadFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		if(x.exists()) {
			ObjectInputStream z=new ObjectInputStream(new FileInputStream(x));
			Object ret=z.readObject();
			if(ret instanceof Manager) {
				Manager d=(Manager) ret;
				return d;
			}
			return null;
		}
		return null;
	}
	
	public void WriteOnFile(Manager m) throws FileNotFoundException, IOException {
		if(x.exists()) {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(x));
			out.writeObject(m);
		}
		else {
			x= new File("dati.dat");
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(x));
			out.writeObject(m);
		}
	}
	
	

}
