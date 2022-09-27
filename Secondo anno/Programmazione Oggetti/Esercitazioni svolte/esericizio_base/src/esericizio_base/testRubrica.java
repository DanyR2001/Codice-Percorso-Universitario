package esericizio_base;

import java.io.FileNotFoundException;

public class testRubrica {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String path="rubrica.txt";
		Rubrica num=new Rubrica();
		num.readFile(path);
		System.out.println(num.StampaContatti());
		num.removeContact("mario", "Citarella");
		//System.out.println(num.StampaContatti());
		//num.removeContact("mario", "Citarella");
		//System.out.println(num.StampaContatti());
		Contatto old=new Contatto("massimo","dicazzo","1234567890");
		num.addContact(old);
		num.addContact("mario", "Citarella", "1234567890");
		//num.addContact("mario", "Citarella", "1234567890");
		System.out.println(num.StampaContatti());
		//num.removeContact(old);
		Contatto nw=new Contatto("tassimo","dicazzo","1234567890");
		num.aggiorna(old, nw);
		num.addContact(nw);
		System.out.println(num.StampaContatti());
		num.removeContact(nw);
		num.removeContact("mario", "Citarella");
		System.out.println(num.StampaContatti());
		num.export("export.txt");

	}

}
