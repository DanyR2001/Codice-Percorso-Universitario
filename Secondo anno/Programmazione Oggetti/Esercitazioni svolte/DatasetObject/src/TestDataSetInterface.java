
public class TestDataSetInterface {

	public static void main(String[] args) {
		// Bankaccount
		
		class StringMeasurer implements Measurer{
			public double measure(Object x) {
				String o=(String) x;
				return o.length();
			}
		}
		
		Measurer m=new StringMeasurer();
		Dataset x=new Dataset(m);

		x.add("ciao");
		x.add("diocane");
		x.add("Maria");
		
		System.out.println("La media dei conti è "+x.getAverage());
		String max=(String)x.getMaximum();
		System.out.println("il conto con il massimo soldo è di "+max+" con ");
		String min=(String)x.getMinimum();
		System.out.println("il conto con il minimo soldo è di "+min+" con ");
		

		
	}

}
