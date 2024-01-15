import java.util.ArrayList;

public class Libro {
	private String Titolo;
	private String Autore;
	private int Num_pagine;
	private ArrayList Lista_capitoli;
	private int ID_obj;
	
	private static int Id=1;
	
	public Libro() {
		Titolo="Sconosciuto";
		Autore="Sconosciuto";
		Num_pagine=0;
		ID_obj=0;
		Lista_capitoli=null;	
	}
	
	public Libro(String titolo,int num_pagine,ArrayList lista) {
		Titolo=titolo;
		Autore="Sconosciuto";
		Num_pagine=num_pagine;
		Lista_capitoli=lista;
		ID_obj=Id;
		Id++;
	}
	
	public Libro(String titolo, String autore, int num_pagine, ArrayList lista_capitoli) {
		Titolo=titolo;
		Autore = autore;
		Num_pagine = num_pagine;
		Lista_capitoli = lista_capitoli;
		ID_obj=Id;
		Id++;
	}
	
	public boolean equals(Libro x) {
		if(this.Autore.equals(x.getAutore())&&this.Titolo.equals(x.getTitolo())&&this.Num_pagine==x.getNum_pagine()&&Lista_capitoli.equals(x.getLista_capitoli()))
			return true;
		else
			return false;
		
	}
	
	public String toString() {
		return "Autore: "+Autore+", Titolo: "+Titolo+", Numero pagine: "+Num_pagine+", "+Lista_capitoli.toString()+", ID: "+ID_obj+"; \n";
	}
	
	public String getInitials() {
		String x=null;
		if(!Autore.equals(null)&&!Autore.equals("Sconosciuto")) {
			String Part[]=Autore.split(" ");
			for(int i=0;i<Part.length;i++)
				x+=Part[i].indent(0);
		}
		return x;
	}

	public String getTitolo() {
		return Titolo;
	}

	public void setTitolo(String titolo) {
		Titolo = titolo;
	}

	public String getAutore() {
		return Autore;
	}

	public void setAutore(String autore) {
		Autore = autore;
	}

	public int getNum_pagine() {
		return Num_pagine;
	}

	public void setNum_pagine(int num_pagine) {
		Num_pagine = num_pagine;
	}

	public ArrayList getLista_capitoli() {
		return Lista_capitoli;
	}

	public void setLista_capitoli(ArrayList lista_capitoli) {
		Lista_capitoli = lista_capitoli;
	}

	public int getID_obj() {
		return ID_obj;
	}

	public void setID_obj(int iD_obj) {
		ID_obj = iD_obj;
	}

	public static int getId() {
		return Id;
	}

	public static void setId(int id) {
		Id = id;
	}
	
}
