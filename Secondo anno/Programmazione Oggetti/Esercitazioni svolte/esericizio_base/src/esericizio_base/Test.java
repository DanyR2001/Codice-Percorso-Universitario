package esericizio_base;

public class Test {

	public static void main(String[] args) {
		/*Car first=new Car("Mercedes","GLA","DVC3",160,13.6);
		Car second=new Car("Fiat","tipo","MARC3",180,23.8);
		
		System.out.println(first.getAtonomia()+" km");
		System.out.println(second.getAtonomia()+" km");
		SavingAccount x=new SavingAccount(1000,1.5);
		x.addInterest();
		System.out.print("saldo + interessi trimestrali "+x.getBalance());*/
		
		Studente y=new Studente();
		y.addEsame(27);
		System.out.println(""+y.media());
		y.addEsame(30);
		System.out.println(""+y.media());
	}

}
