import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Vegano extends Panino implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4523379021137126556L;
	private final static int NumMax=3;
	private int actNum;
	
	public Vegano(String Nome) {
		super(Nome);
		actNum=0;
		// TODO Auto-generated constructor stub
	}
	
	public void add(Alimento x) throws IOException {
		if(actNum<NumMax) {
			if(x.getTipo().equals("carne")||x.getTipo().equals("vegetariano"))
				throw new RuntimeException("tipo sbagliato");
			super.add(x);
			actNum++;
		}
		else
			System.out.print("fine ingredienti panino");
	}
	
	public void autoComponi() throws IOException {
		for(int i=actNum;i<NumMax;i++) {
			List x=null;
			if(i==0)
				x=super.Step1;
			else if(i==1)
				x=super.Step2;
			else if(i==2)
				x=super.Step5;
			//System.out.print("i "+i);
			Random random= new Random();
			this.add((Alimento) x.get(random.nextInt(3)));
		}
	}
	

}
