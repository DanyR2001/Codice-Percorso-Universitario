package esericizio_base;

public class Auto {

	private double resa;
	private double l_serbatoio;
	
	public Auto(int resa) {
		this.resa=resa;
		l_serbatoio=0;
	}
	
	public void addGass(double fuel) {
		l_serbatoio+=fuel;
	}
	
	public void printGass() {
		System.out.println("Ci sono "+this.l_serbatoio+" litri nel serbatorio.");
	}
	
	public void travel(double km) {
		this.l_serbatoio-=km/resa;
		System.out.println("Per il viaggio sono stati consumati "+km/resa+" litri.");
	}
	
}
