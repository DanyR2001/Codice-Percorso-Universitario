
public class TestDataSetInterface {

	public static void main(String[] args) {
		// Bankaccount
		Dataset x=new Dataset();
		BankAccount q1=new BankAccount("daniele", 1000);
		BankAccount q2=new BankAccount("mario", 10000);
		BankAccount q3=new BankAccount("maronno", 50);

		x.add(q1);
		x.add(q2);
		x.add(q3);
		
		System.out.println("La media dei conti è "+x.getAverage());
		BankAccount max=(BankAccount)x.getMaximum();
		System.out.println("il conto con il massimo soldo è di "+max.getName()+" con "+max.getBalance()+"€");
		BankAccount min=(BankAccount)x.getMinimum();
		System.out.println("il conto con il minimo soldo è di "+min.getName()+" con "+min.getBalance()+"€");
		
		//Country
		Dataset y=new Dataset();
		Country r1=new Country("italia", 1000);
		Country r2=new Country("russia", 100000);
		Country r3=new Country("vaticano", 50);

		y.add(r1);
		y.add(r2);
		y.add(r3);
		
		System.out.println("La media delle aree dei paesi è "+y.getAverage());
		Country max1=(Country)y.getMaximum();
		System.out.println("il paese con il massimo area è "+max1.getName()+" con "+max1.getArea()+"mq");
		Country min1=(Country)y.getMinimum();
		System.out.println("il paese con il minimo area è "+min1.getName()+" con "+min1.getArea()+"mq");
		
	}

}
