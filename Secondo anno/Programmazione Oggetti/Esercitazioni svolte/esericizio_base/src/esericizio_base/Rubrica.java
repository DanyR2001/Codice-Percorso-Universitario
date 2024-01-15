package esericizio_base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Rubrica {
	private File db=null;
	private ArrayList<Contatto> rubrica;
	
	public Rubrica() {
		rubrica=new ArrayList();
	}
	
	public void add(Contatto next) {
		rubrica.add(next);
	}
	
	public void add(String Nome,String Cognome,String numero) {
		Contatto next=new Contatto(Nome,Cognome,numero);
		//System.out.println(next.toString());
		rubrica.add(next);
	}
	
	public void readFile(String path) throws FileNotFoundException {
		db=new File(path);
		Scanner in=new Scanner(db);
		while(in.hasNextLine()) {
			String contatto[];
			String input=in.nextLine();
			contatto=input.split(",");
			this.add(contatto[0], contatto[1], contatto[2]);
		}
		in.close();
	}
	
	public void writeFile() throws FileNotFoundException {
		if(db!=null) {
			PrintStream out=new PrintStream(db);
			for(Contatto c : rubrica) {
				out.println(c.toString());
			}
			out.close();
		}
	}
	
	public void writeFile(String path) throws FileNotFoundException {
		if(rubrica.isEmpty()) {
			File x=new File(path);
			PrintStream out=new PrintStream(path);
			for(Contatto c : rubrica) {
				out.println(c.toString());
			}
			out.close();
		}
	}
	
	public void remove(Contatto rem){
		for(int i=0;i<rubrica.size();i++) {
			//System.out.print(" "+i+" ");
			//System.out.println(rubrica.get(i).equals(rem));
			if(rubrica.get(i).equals(rem)) {
				//System.out.println(" found ");
				rubrica.remove(i);
			}
		}
	}
	
	public void remove(String Nome,String Cognome){
		Contatto rem=new Contatto(Nome,Cognome);
		for(int i=0;i<rubrica.size();i++) {
			//System.out.print(" "+i+" ");
			//System.out.println(rubrica.get(i).equals(rem));
			if(rubrica.get(i).equals(rem)) {
				//System.out.println(" found ");
				rubrica.remove(i);
			}
		}
	}
	
	public String search(String nome, String Cognome) {
		for(int i=0;i<rubrica.size();i++) {
			if(rubrica.get(i).equals(nome, Cognome))
				return rubrica.get(i).getNumero();
		}
		return "not found";
	}
	
	public void aggiorna(Contatto old,Contatto nw) throws FileNotFoundException {
		for(int i=0;i<rubrica.size();i++) {
			if(rubrica.get(i).equals(old)) {
				rubrica.remove(i);
				rubrica.add(i, nw);
			}
		}
		this.refresh();
	}
	
	public void refresh() throws FileNotFoundException {
		if(db!=null) {
			PrintStream out=new PrintStream(db);
			for(Contatto c : rubrica) {
				out.println(c.toString());
			}
			out.close();
		}
	}
	
	public String StampaContatti() {
		String temp="";
		for(Contatto c : rubrica) {
			temp+=c.toString();
			temp+="\n";
		}
		return temp;
	}
	
	public void addContact(String Nome,String Cognome,String numero) throws FileNotFoundException {
		this.add(Nome, Cognome, numero);
		this.refresh();
	}
	
	public void addContact(Contatto x) throws FileNotFoundException {
		this.add(x);
		this.refresh();
	}
	
	public void removeContact(String Nome,String Cognome) throws FileNotFoundException {
		remove(Nome, Cognome);
		this.refresh();
	}
	
	public void removeContact(Contatto x) throws FileNotFoundException {
		this.remove(x);
		this.refresh();
	}
	
	public String findIn(String temp) {
		for(int i=0;i<rubrica.size();i++) {
			if(rubrica.get(i).getNome().contains(temp)||rubrica.get(i).getCognome().contains(temp))
				return rubrica.get(i).toString();
		}
		return "not found";
	}
	
	public void export(String path) throws FileNotFoundException {
		if(db!=null) {
			File x=new File(path);
			PrintStream out=new PrintStream(x);
			for(Contatto c : rubrica) {
				out.println(c.toExport());
			}
			out.close();
		}
	}
}
