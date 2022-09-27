import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoadOrder {
	
	private File x;
	
	public LoadOrder(String y) {
		x=new File(y);
	}
	
	public Oridinazione GetFromFile() {
		Oridinazione y=null;
		if(x.exists()) {
			//System.out.print("esosteee");
			ObjectInputStream in;
			try {
				in = new ObjectInputStream(new FileInputStream(x));
				y=(Oridinazione)in.readObject();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			//System.out.print("no esosteee");
		}
		return y;
	}
	
	public void WriteOnFile(Oridinazione y) {
		if(!x.exists()) {
			try {
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(x));
				out.writeObject(y);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
