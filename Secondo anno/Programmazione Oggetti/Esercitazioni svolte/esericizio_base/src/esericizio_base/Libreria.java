package esericizio_base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
	private String name;
	private ArrayList<Libro> lista;
	
	public Libreria(String name,int i) throws FileNotFoundException {
		this.name=name;
		this.lista=new ArrayList<Libro>();
		if(i==0) {
			//System.out.println("Apertura file");
			File x=new File(name);
			Scanner src=new Scanner(x);
			while(src.hasNextLine()) {
				Libro l=Libro.leggiLibro(src);
				//l.printLib();
				//System.out.println("valore lib");
				if(l!=null) {
					//System.out.println("Libro aggiunto alla lista da file");
					lista.add(l);
				}
			}
			src.close();
		}
	}
	
	public Libreria(ArrayList x,String nome) {
		lista=x;
		this.name=nome;
	}
	
	public void addLibro(Libro x) {
		lista.add(x);
	}
	
	public void trovaLibAuto(String autore) {
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getAutore().equals(autore))
				System.out.println("	Titolo:"+lista.get(i).getTitolo());
	}
	
	public void findSubString(String SubString) {
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getTitolo().contains(SubString)) {
				System.out.println("	Titolo:"+lista.get(i).getTitolo());
			}
	}
	
	public void printLibMax() {
		if(lista.size()>0) {
		int i=0;
		Libro max=lista.get(0);
		for(i=1;i<lista.size();i++)
			if(lista.get(i).getNumCopie()>max.getNumCopie()) {
				max=lista.get(i);
			}
		
		boolean flag=false;
		for(i=1;i<lista.size();i++)
			if(lista.get(i).getNumCopie()==max.getNumCopie()) {
				flag=true;
			}
		if(flag==true) {
			System.out.println("	Titoli libri con magior numero di copie:");
			for(i=0;i<lista.size();i++)
				if(lista.get(i).getNumCopie()==max.getNumCopie()) {
					System.out.println("	Titolo:"+lista.get(i).getTitolo());
				}
		}
		else {
			System.out.println("Libro con il magior numero di pagine:");
			System.out.println("	Titolo:"+max.getTitolo());
		}
			
		}
		else
			System.out.println("Nessun libro nella libreria");
	}
	
	public ArrayList<Libro> libriSottoN(int n) {
		ArrayList<Libro> x=new ArrayList<>();
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getNumCopie()<n)
				x.add(lista.get(i));
		return x;
	}
	
	private void addNumLib(String titolo,int num) {
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getTitolo().equals(titolo))
				lista.get(i).setNumCopie(num+lista.get(i).getNumCopie());
	}
	
	public void printLib() {
		for(int i=0;i<lista.size();i++)
			System.out.println("Autore: "+lista.get(i).getAutore()+", titolo: "+lista.get(i).getTitolo()+", numero copie: "+lista.get(i).getNumCopie());
	}
	
	private void refreshFile(String fileName,String titolo,int num) throws FileNotFoundException{
		addNumLib(titolo,num);
		PrintStream out=new PrintStream(fileName);
		for(Libro lib : lista) {
			out.println(lib.getTitolo());
			out.println(lib.getAutore());
			out.println(lib.getEditore());
			out.println(lib.getNumCopie());
		}
		out.close();
		
	}
	
	public void addNumLibro(String titolo,int num) throws FileNotFoundException {
		this.refreshFile(name, titolo, num);
	}
	
}
