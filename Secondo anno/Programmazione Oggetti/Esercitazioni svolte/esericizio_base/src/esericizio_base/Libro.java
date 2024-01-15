package esericizio_base;

import java.util.Scanner;

public class Libro {
	private String titolo;
	private String autore;
	private String editore;
	private int numCopie;
	
	public Libro(String titolo,String autore,String editore,int numCopie) {
		this.titolo=titolo;
		this.autore=autore;
		this.editore=editore;
		this.numCopie=numCopie;
	}

	public static Libro leggiLibro(Scanner src) {
		//System.out.println("Start");
		String titolo=src.nextLine();
		//System.out.println("titolo "+titolo);
		if(!src.hasNextLine()) return null;
		String autore=src.nextLine();
		//System.out.println("autore "+autore);
		if(!src.hasNextLine()) return null;
		String editore=src.nextLine();
		//System.out.println("editore "+editore);
		if(!src.hasNextLine()) return null;
		String y=src.nextLine();
		int numCopie=Integer.parseInt(y);
		//System.out.println("numcopie "+numCopie);
		//if(!src.hasNextLine()) return null;
		Libro x=new Libro(titolo,autore,editore,numCopie);
		//System.out.println("creato");
		return x;
		
	}
	
	public void printLib() {
		System.out.println("titolo "+this.titolo+", aturore "+this.autore+" editore "+this.editore+", num copie"+this.numCopie);
		}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public int getNumCopie() {
		return numCopie;
	}

	public void setNumCopie(int numCopie) {
		this.numCopie = numCopie;
	}
	
}
