package preEsame;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				Autoveicolo x=new Autoveicolo("ciao", "runault", "LL123LL", 2000, "Benzina", 2, 2);
			} catch (TargaErrataException e) {
				// TODO Auto-generated catch block
				System.out.print("diocane");
				e.printStackTrace();
			}
			try {
				Motociclo x=new Motociclo("Duke", "KTM", "LL123H5", 2222, 2, 2);
			} catch (TargaErrataException e) {
				System.out.print("diocane2");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
