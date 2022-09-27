import java.util.ArrayList;

public class Volume extends Libro {
	
	private String Titolo_Enciclopedia;
	private String Curatore;
	
	public Volume(String titolo_Enciclopedia, String curatore) {
		super();
		Titolo_Enciclopedia = titolo_Enciclopedia;
		Curatore = curatore;
	}

	public Volume(String titolo,int num_pagine,ArrayList lista,String titolo_Enciclopedia, String curatore) {
		super(titolo,num_pagine,lista);
		Titolo_Enciclopedia = titolo_Enciclopedia;
		Curatore = curatore;
	}
	
	public Volume(String titolo, String autore, int num_pagine, ArrayList lista_capitoli,String titolo_Enciclopedia, String curatore) {
		super(titolo,autore,num_pagine,lista_capitoli);
		Titolo_Enciclopedia = titolo_Enciclopedia;
		Curatore = curatore;
	}
	
	
}
