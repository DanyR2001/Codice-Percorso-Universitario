
public class test_studenti_docenti {
	public static void main(String[] args) {
		boolean flag=false;
		Student x = null;
		do {
			flag=false;
			System.out.println("Inserisci i dati:");
			try {
				x=new Student("Mario","Gallo","mariogallo@gmail.com","Ciao123","123456");
			}catch(IllegalArgumentException e) {
				e.printStackTrace();
				flag=true;
			}
		}while(flag);
		try {
			x.addVoto("Cazzoligia", "20");
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
