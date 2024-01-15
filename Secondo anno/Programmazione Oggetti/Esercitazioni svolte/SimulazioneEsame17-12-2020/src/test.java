import java.io.IOException;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PagamentoPasti lista=new PagamentoPasti();
		lista.addTesserino(new TesserinoPersonale("123", "Mario", "Giordano", true, "Informatica", 0, "Docente"));
		lista.addTesserino(new TesserinoPersonale("125", "Andrea", "Giordano", false, "Scienza delle merendine", 0, "Docente"));
		lista.addTesserino(new TesserinoPersonale("127", "Andrea", "Ruopolo", true, "Scienza delle ambientali", 0, "Amministrativo"));
		lista.addTesserino(new TesserinoPersonale("129", "Marco", "Cappato", true, "Scienza delle terra", 0, "Amministrativo"));
		lista.addTesserino(new TesserinoStudente("520", "Mattia", "Cavaliere", true, "UNISA0000", new Date(), 10.0, 'A', true));
		lista.addTesserino(new TesserinoStudente("521", "Mario", "Rossi", true, "UNISA0001", new Date(2025,12,31), 5.0, 'B', false));
		lista.addTesserino(new TesserinoStudente("522", "Alessando", "Gallo", true, "UNISA0002", new Date(2025,12,31), 100.0, 'A', false));
		lista.addTesserino(new TesserinoStudente("523", "Alessio", "Blum", true, "UNISA0003", new Date(2025,12,31), 1000.0, 'B', true));
		FileManager file=new FileManager("dati.dat");
		try {
			file.WriteFile(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
