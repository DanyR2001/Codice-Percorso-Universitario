import java.util.Random;
import java.util.Scanner;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaBiometrico lista=new SistemaBiometrico();
		Random rand=new Random();
		for(int i=0;i<20;i++) {
			int x=rand.nextInt(2);
			if(x==0) {
				String str=Integer.toString(rand.nextInt(1000000000)+999999999);
				//System.out.println(" lungheza"+str.length());
				Volto temp=new Volto("faceId",str);
				lista.aggiungiBiometria(temp);
			}
			else {
				x=rand.nextInt(2);
				String occhio;
				if(x==0)
					occhio="destro";
				else
					occhio="sinistro";
				String str=Integer.toString(rand.nextInt(100000)+99999);
				//System.out.println(" lungheza"+str.length());
				Iride temp=new Iride("scannerIride", occhio, str);
				lista.aggiungiBiometria(temp);
			}
		}
		Scanner in= new Scanner(System.in);
		System.out.println(lista.toString());
		System.out.print("inserisci il la biomertria codice;");
		String x=in.nextLine();
		if(lista.verificaBiometria(x)) {
			System.out.println(lista.toString(lista.indexBiometria(x)));
		}else {
			Iride y;
			Volto z;
			if(x.length()==6) {
				//System.out.println("iride");
				y=new Iride(null, "destro",x);
				try {
					System.out.print(lista.getVicino(y));
				} catch (WrongTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(x.length()==10){
				//System.out.println("volto");
				z=new Volto(null,x);
				try {
					System.out.print(lista.getVicino(z));
				} catch (WrongTypeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
				System.out.println("nisba");
		}
	}

}
