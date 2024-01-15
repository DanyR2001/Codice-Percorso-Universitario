package esericizio_base;

public class Car {
	
	private String Marca;
	private String Nome;
	private String Targa;
	private int Capacità;
	private double kml;
	
	public Car(String Marca,String Nome,String Targa,int Capacità,double kml) {
		this.Marca=Marca;
		this.Nome=Nome;
		this.Targa=Targa;
		this.Capacità=Capacità;
		this.kml=kml;
	}
	
	public double getAtonomia() {
		if(this.kml!=0&&this.Capacità!=0)
			return this.Capacità*this.kml;
		else
			return -1;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getTarga() {
		return Targa;
	}

	public void setTarga(String targa) {
		Targa = targa;
	}

	public int getCapacità() {
		return Capacità;
	}

	public void setCapacità(int capacità) {
		Capacità = capacità;
	}

	public double getKml() {
		return kml;
	}

	public void setKml(double kml) {
		this.kml = kml;
	}
	
}
