package esericizio_base;

import java.io.FileNotFoundException;

public class TestLibr {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Libreria Feltrinelli=new Libreria("file.txt",0);
		Feltrinelli.printLib();
		System.out.println("1. done");
		Feltrinelli.trovaLibAuto("Camilleri Andrea");
		System.out.println("2. done");
		Feltrinelli.findSubString("ogni");
		System.out.println("3. done");
		Feltrinelli.printLibMax();
		System.out.println("4. done");
		Libreria temp=new Libreria(Feltrinelli.libriSottoN(30),"temp");
		temp.printLib();
		System.out.println("5. done");
		Feltrinelli.addNumLibro("Sogni rossi", 30);
		Feltrinelli.printLib();
	}

}
