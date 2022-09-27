import java.io.IOException;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		FileManager ob;
		do {
			System.out.print("inserisci il nome;");
			String x=in.nextLine();
			ob=new FileManager(x);
		}while(ob.exists());
		System.out.print("inserisci il duce;");
		ElencoArticoli z = null;
		try {
			z=new ElencoArticoli(ob.ReadFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(z!=null) {
			System.out.print(z.toString());
			System.out.print("Prezzo totale "+z.dammiTotale());
		}
	}

}
