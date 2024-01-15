package Preappello;

import java.util.ArrayList;

public class Idraulico {
	private String matricola;
	private String cognome;
	private String nome;
	private ArrayList<String> typeInterv ; //(ad es. Scolo, Guaina, Condotta, Alimentatore, Quadro Elettrico);
	private int numInterv;
	
	public Idraulico(String matricola, String cognome, String nome) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.typeInterv = new ArrayList<>();
		this.numInterv = 1;
	}
	
	public void effetuaInterv(String interv) {
		typeInterv.add(interv);
		numInterv++;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getTypeInterv() {
		return typeInterv;
	}

	public void setTypeInterv(ArrayList<String> typeInterv) {
		this.typeInterv = typeInterv;
	}

	public int getNumInterv() {
		return numInterv;
	}

	public void setNumInterv(int numInterv) {
		this.numInterv = numInterv;
	}
	
}
