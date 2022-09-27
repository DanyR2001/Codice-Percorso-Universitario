import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Torneo Preti=new Torneo("Strozzapreti");
		Preti.addSquadra("PoggioMarinoWin", 0, 0, 1000);
		Preti.addSquadra("PoggioRealeWin", 0, 0, 1000);
		Preti.addSquadra("AgerolaWin", 0, 0, 1000);
		Preti.addSquadra("AfragolaWin", 0, 0, 1000);
		Preti.addSquadra("CavaWin", 0, 0, 1000);
		Preti.addSquadra("AcerraWin", 0, 0, 1000);
		Preti.addSquadra("SecondiglianoWin", 0, 0, 1000);
		Preti.addSquadra("CasalnuovoWin", 0, 0, 1000);
		Preti.addSquadra("SanValentinoWin", 0, 0, 1000);
		Preti.addSquadra("CasalDiPrincipeWin", 0, 0, 1000);
		try {
			Preti.playTorneo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("duce");
		System.out.print(Preti.printList());
		System.out.print(Preti.Classifica());
		
		File x=new File("Strozzapreti");
		PrintStream out;
		try {
			out = new PrintStream(x);
			out.println(Preti.Classifica());
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
