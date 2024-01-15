package esericizio_base;

import java.util.Scanner;

import javax.imageio.stream.FileCacheImageInputStream;

public class TestTris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		char x;
		Scanner in=new Scanner(System.in);
		do {
			System.out.println("Inserisci il carattere (X o O) che inizia per primo:");
			input=in.next();
			x=input.charAt(0);
		}while(x!='X'&&x!='O');
		Tris first=new Tris(x);
		int asc=0,ord=0;
		do {
			first.printTable();
			do {
			do {
			System.out.println("Tocca a "+first.getNextplayer()+", inserisci la x (riga) (da 1 a 3):");
			asc=in.nextInt();
			}while(asc<1||asc>3);
			do {
			System.out.println("Insersci la y(colonna) (da 1 a 3):");
			ord=in.nextInt();
			}while(ord<1||ord>3);
			asc--;
			ord--;
			if(!first.ceckPos(asc, ord))
				System.out.println("posizione gia scritta, riprova");
			}while(!first.ceckPos(asc, ord));
		}while(first.nextMove(asc, ord)&&(!first.getWinner().equals("X")&&!first.getWinner().equals("O")&&!first.getWinner().equals("Patta")));
		if(first.getWinner().equals("X")||first.getWinner().equals("O"))
			System.out.println("Il vincitore è "+first.getWinner());
		else
			System.out.println("Il risultato è "+first.getWinner());
	}

}
