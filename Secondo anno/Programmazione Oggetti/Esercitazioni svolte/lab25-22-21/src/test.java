
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			bankAccount x=new bankAccount("daniele",100);
			x.removeCredit(-100);
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("errore");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("errore 2");
		}
	}

}
