package esericizio_base;

import java.util.Scanner;

public class TestBanckAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		BankAccount giocatore=new BankAccount("Daniele",1000);
		BankAccount casino=new BankAccount("Royale",100000);
		int n=0,dado;
		double somma=0;
		String input="si";
		do {
			dado=(int) (Math.random()*5)+1;
			//System.out.println("dado: "+dado);
			do {
				System.out.println("Inserisci il numero:");
				n=in.nextInt();
				if(n<1||n>6)
					System.out.println("Il dato ha solo 6 facce");
			}while(n<1||n>6);
			do {
				System.out.println("Inserisci l'importo della scommessa:");
				somma=in.nextDouble();
				if(somma>giocatore.getBalance())
					System.out.println("Sei povero, riprova");
				if((somma*5)>casino.getBalance())
					System.out.println("il casino e povero, riprova");
			}while(somma>giocatore.getBalance()||(somma*5)>casino.getBalance());
			if(dado==n) {
				System.out.println("Hai vinto:");
				giocatore.addCredit(somma*5);;
				casino.removeCredit(somma*5);
			}
			else {
				System.out.println("Hai !vinto:");
				giocatore.removeCredit(somma);;
				casino.addCredit(somma);
			}
			//System.out.println("saldo concorrente "+giocatore.getBalance());
			//System.out.println("saldo casino "+casino.getBalance());
			System.out.println("Vuoi giocare ancora?");
			in.nextLine();
			input=in.nextLine();
		}while(input.equals("si"));
	}

}
