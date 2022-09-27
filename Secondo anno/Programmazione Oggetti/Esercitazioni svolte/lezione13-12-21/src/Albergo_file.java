import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.imageio.IIOException;

public class Albergo_file {
	private Albergo oggetto;
	
	public Albergo_file() {
		oggetto=new Albergo();
	}
	
	public Albergo_file(Albergo x) {
		oggetto=x;
	}
	
	public Albergo_file(ArrayList<Cliente> clienti, ArrayList<Stanza> stanze, ArrayList<Prenotazione> prenotazioni) {
		Albergo x=new Albergo(clienti,stanze,prenotazioni);
		oggetto=x;
	}
	
	public void Load(File x) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(x.exists()) {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(x));
			oggetto=(Albergo)in.readObject();
			in.close();
		}
		else
			throw new IOException("errore caricamento");
	}
	
	public void Save(File x) throws IOException {
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(x));
		out.writeObject(oggetto);
		out.close();
	}

	public Albergo getOggetto() {
		return oggetto;
	}

	public void setOggetto(Albergo oggetto) {
		this.oggetto = oggetto;
	}
	
}
