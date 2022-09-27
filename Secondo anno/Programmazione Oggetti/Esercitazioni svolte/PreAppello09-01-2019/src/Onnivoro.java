import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Onnivoro extends Panino implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5332623288010958647L;
	private final static int NumMax=5;
	private int actNum;
	
	public Onnivoro(String Nome) {
		super(Nome);
		actNum=0;
		// TODO Auto-generated constructor stub
	}
	
	public void add(Alimento x) throws IOException {
		if(actNum<NumMax) {
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
				x=super.Step3;
			else if(i==3)
				x=super.Step4;
			else if(i==4)
				x=super.Step5;
			Random random= new Random();
			this.add((Alimento) x.get(random.nextInt(3)));
		}
	}
	
}
