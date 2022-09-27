package esericizio_base;

public class Stazione {
	private String name;
	private String orario_arrivo;
	private String orario_partenza;
	
	public Stazione(String name,String arr,String par) {
		this.name=name;
		orario_arrivo=arr;
		orario_partenza=par;
	}
	
	public boolean equals(Stazione x) {
		if(x.name.equals(this.name))
			return true;
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrario_arrivo() {
		return orario_arrivo;
	}

	public void setOrario_arrivo(String orario_arrivo) {
		this.orario_arrivo = orario_arrivo;
	}

	public String getOrario_partenza() {
		return orario_partenza;
	}

	public void setOrario_partenza(String orario_partenza) {
		this.orario_partenza = orario_partenza;
	}
	
}
