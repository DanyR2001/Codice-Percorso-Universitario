import java.util.ArrayList;

public class LibroScolastico extends Libro{
	private String Ordine;
	private String Grado;
	private String Materia;
	private String CD_Name;
	
	public LibroScolastico(String ordine, String grado, String materia, String cD_Name) {
		super();
		Ordine = ordine;
		Grado = grado;
		Materia = materia;
		CD_Name = cD_Name;
	}
	
	public LibroScolastico(String titolo,int num_pagine,ArrayList lista,String ordine, String grado, String materia, String cD_Name) {
		super(titolo,num_pagine,lista);
		Ordine = ordine;
		Grado = grado;
		Materia = materia;
		CD_Name = cD_Name;
	}
	
	public LibroScolastico(String titolo, String autore, int num_pagine, ArrayList lista_capitoli,String ordine, String grado, String materia, String cD_Name) {
		super(titolo,autore,num_pagine,lista_capitoli);
		Ordine = ordine;
		Grado = grado;
		Materia = materia;
		CD_Name = cD_Name;
	}
	
	
	public String toStirng(){
		return " Scuola: "+Ordine+" "+Grado+", Materia: "+Materia+", Nome cd: "+CD_Name+", "+super.toString();
	}
	
	public boolean equals(LibroScolastico x) {
		if(super.equals(x)&&this.Ordine.equals(x.getOrdine())&&Grado.equals(x.getGrado())&&Materia.equals(x.getMateria())&&CD_Name.equals(x.getCD_Name()))
			return true;
		else
			return false;
	}

	public String getOrdine() {
		return Ordine;
	}

	public void setOrdine(String ordine) {
		Ordine = ordine;
	}

	public String getGrado() {
		return Grado;
	}

	public void setGrado(String grado) {
		Grado = grado;
	}

	public String getMateria() {
		return Materia;
	}

	public void setMateria(String materia) {
		Materia = materia;
	}

	public String getCD_Name() {
		return CD_Name;
	}

	public void setCD_Name(String cD_Name) {
		CD_Name = cD_Name;
	}
}
