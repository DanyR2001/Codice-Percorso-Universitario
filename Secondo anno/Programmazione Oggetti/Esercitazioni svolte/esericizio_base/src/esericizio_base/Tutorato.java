package esericizio_base;

import java.util.ArrayList;

public class Tutorato {
	public static void main(String[] args) {
		Motorizzazione Salerno=new Motorizzazione("CIAO","Via pane azimo 25");
		Motorino y=new Motorino("alpaca",150,130,false,"rosso");
		Motorino y1=new Motorino("alpachi",50,130,true,"blue");
		Salerno.addMotorini(y);
		Salerno.addMotorini(y1);
		ArrayList<Motorino> Ciclomotori=Salerno.getCiclomotori();
		ArrayList<Motorino> Moto=Salerno.getMoto();
		for(int i=0;i<Ciclomotori.size();i++)
			System.out.println(""+(Ciclomotori.get(i)).getModello());
		for(int i=0;i<Moto.size();i++)
			System.out.print(""+(Moto.get(i)).getModello());
	}
}
