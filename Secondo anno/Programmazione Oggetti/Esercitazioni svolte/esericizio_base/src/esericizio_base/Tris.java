package esericizio_base;

public class Tris {
	private char[][] Tavolo;
	private char nextplayer;
	private int maxInput;
	
	public Tris(char firstPlayer) {
		Tavolo=new char[3][3];
		nextplayer=firstPlayer;
		maxInput=9;
		inizializeTable();
	}
	
	private void switchPlayer(char x) {
		this.maxInput--;
		if(x=='X')
			nextplayer='O';
		else
			nextplayer='X';
	}
	
	public char findWinner() {
		char x='n';
		boolean flag=false;
		for(int i=0;i<3&&flag==false&&this.maxInput>0;i++) {
			if((Tavolo[i][0]=='X'&&Tavolo[i][1]=='X'&&Tavolo[i][2]=='X')||(Tavolo[0][i]=='X'&&Tavolo[1][i]=='X'&&Tavolo[2][i]=='X')) {
				flag=true;
				x='X';
			}
			if((Tavolo[i][0]=='O'&&Tavolo[i][1]=='O'&&Tavolo[i][2]=='O')||(Tavolo[0][i]=='O'&&Tavolo[1][i]=='O'&&Tavolo[2][i]=='O')) {
				flag=true;
				x='O';
			}
		}
		if((Tavolo[0][0]=='O'&&Tavolo[1][1]=='O'&&Tavolo[2][2]=='O')||(Tavolo[0][2]=='O'&&Tavolo[1][1]=='O'&&Tavolo[2][0]=='O'))
			x='O';
		if((Tavolo[0][0]=='X'&&Tavolo[1][1]=='X'&&Tavolo[2][2]=='X')||(Tavolo[0][2]=='X'&&Tavolo[1][1]=='X'&&Tavolo[2][0]=='X'))
			x='X';
		if(this.maxInput==0)
			x='p';
		return x;
	}
	
	public void printTable() {
		System.out.println("  1. 2.  3.");
		System.out.println("1. "+Tavolo[0][0]+"| "+Tavolo[0][1]+" |"+Tavolo[0][2]);
		System.out.println("------------");
		System.out.println("2. "+Tavolo[1][0]+"| "+Tavolo[1][1]+" |"+Tavolo[1][2]);
		System.out.println("------------");
		System.out.println("3. "+Tavolo[2][0]+"| "+Tavolo[2][1]+" |"+Tavolo[2][2]);
	}
	
	private void inizializeTable() {
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				Tavolo[i][j]=' ';
	}
	
	public boolean ceckPos(int x,int y) {
		if(Tavolo[x][y]==' ')
			return true;
		else
			return false;
	}
	
	public String getWinner() {
		char result=this.findWinner();
		if(result=='X')
			return "X";
		else if (result=='O')
			return "O";
		else if (this.maxInput==0)
			return "Patta";
		else
			return "In corso";
	}
	public boolean nextMove(int x,int y) {
		char result=this.findWinner();
		if(result=='n') {
			Tavolo[x][y]=nextplayer;
			switchPlayer(nextplayer);
			return true;
		}
		else
			return false;
	}

	public char getNextplayer() {
		return nextplayer;
	}

	public void setNextplayer(char nextplayer) {
		this.nextplayer = nextplayer;
	}
}
