import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class I_O_ArchivioAutomezzi {
	private ArchivioAutomezzi archivio;
	
	public I_O_ArchivioAutomezzi() {
		archivio = new ArchivioAutomezzi();
	}
	
	public void LoadList(File x) throws IOException, ClassNotFoundException{
		if(x.exists()) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(x));
			archivio=(ArchivioAutomezzi)in.readObject();
			in.close();
		}
		else
			throw new BadDataFormatException("errore");

	}
	
	public void SaveList(File x) throws FileNotFoundException, IOException {
		if(x.exists()) {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(x));
			out.writeObject(archivio);  
			out.close();
		}
	}

	public ArchivioAutomezzi getArchivio() {
		return archivio;
	}
	

}
