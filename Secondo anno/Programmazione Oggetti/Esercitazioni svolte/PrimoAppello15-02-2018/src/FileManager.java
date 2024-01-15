import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
	private File x;
	
	public FileManager(String y) {
		x=new File(y);
	}
	
	public boolean exists() {
		return !x.exists();
	}
	
	public ArrayList<Articolo> ReadFile() throws FileNotFoundException, IOException{
		ArrayList<Articolo> list=new ArrayList<>();
		Scanner in=new Scanner(x);
		String tmp;
		while(in.hasNextLine()) {
			tmp=in.nextLine();
			String Articolo[]=tmp.split(" ");
			int codice;
			double prezzo;
			if(Articolo.length!=4&&Articolo.length!=6)
				throw new MissingFieldException();
			try {
				codice=Integer.parseInt(Articolo[1]);
			}catch(NumberFormatException e) {
				throw new WrongTypeException();
			}
			try {
				prezzo=Double.parseDouble(Articolo[2]);
			}catch(NumberFormatException e) {
				throw new WrongTypeException();
			}
			if(Articolo.length==4) {
				Articolo y=new Articolo(Articolo[0], codice, prezzo, Articolo[3]);
				list.add(y);
			}
			else {
				ArticoloRestituito y1=new ArticoloRestituito(Articolo[0], codice, prezzo, Articolo[3],Articolo[4],Articolo[5]);
				list.add(y1);
			}
		}
		in.close();
		if(list.isEmpty())
			return null;
		return list;
	}
	
}
