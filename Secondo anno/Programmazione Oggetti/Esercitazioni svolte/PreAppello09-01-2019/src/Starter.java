import java.io.IOException;
import java.util.Random;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Oridinazione gay;
		LoadOrder test=new LoadOrder("file.dat");
		gay=test.GetFromFile();
		if(gay==null) {
			gay=new Oridinazione(1);
			do {
				Random random= new Random();
				int chose=random.nextInt(3);
				if(chose==0) {
					Onnivoro temp=new Onnivoro("Blacksbebon");
					try {
						temp.autoComponi();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gay.addPanino(temp);
				}
				else if(chose==1) {
					Vegetariano temp1=new Vegetariano("borra");
					try {
						temp1.autoComponi();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gay.addPanino(temp1);
				}
				else if(chose==2) {
					Vegano temp2= new Vegano("geay");
					try {
						temp2.autoComponi();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					gay.addPanino(temp2);
				}
			}while(gay.calcolaCosto()<200);
			System.out.print(gay.toString());
			test.WriteOnFile(gay);
		}
		else {
			System.out.print(gay.toString());
		}
	}

}
