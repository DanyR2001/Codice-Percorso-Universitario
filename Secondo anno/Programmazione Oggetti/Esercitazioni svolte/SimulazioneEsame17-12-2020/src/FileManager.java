import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileManager {
	private File name;
	
	public FileManager(String x) {
		name=new File(x);
	}
	
	public PagamentoPasti ReadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		if(name.exists()) {
			PagamentoPasti temp;
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(name));
			temp=(PagamentoPasti) in.readObject();
			in.close();
			return temp;
		}
		else {
			return null;
		}
	}
	
	public void WriteFile(PagamentoPasti temp) throws IOException {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(name));
			out.writeObject(temp);
			out.close();
	}
	
}
