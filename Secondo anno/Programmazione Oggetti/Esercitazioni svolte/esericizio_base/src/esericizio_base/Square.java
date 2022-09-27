package esericizio_base;

public class Square {
	private int[][] Square;
	int nexti,nextj,n;
	
	public Square(int n) {
		Square=new int[n][n];
		nextj=0;
		nexti=0;
		this.n=n;
	}
	
	private boolean isPresent(int x) {
		boolean flag=false;
		for(int i=0;i<nexti&&flag==false;i++)
			for(int j=0;j<nextj&&flag==false;j++)
				if(Square[i][j]==x)
					flag=true;
		return flag;
	}
	
	public void add(int x){
		Square[nexti][nextj]=x;
		if(this.nexti>n) {
			nexti=0;
			nextj++;
		}
		else
			nexti++;
	}
	
	/*public boolean isMagic() {
		int diagonaleM=0;
		int diagonalem=0;
		int sumr=0,sumc=0,cont=0;
		int array[][]=new int[2][n];
		for(int i=0;i<n;i++) {
			sumr=0;
			sumc=0;
			for(int j=0;j<n;j++) {
				sumr+=Square[i][j];
				sumc+=Square[j][j];
				if(i==j)
					diagonaleM+=Square[i][j];
				if(i==n-1) {
					array[cont][0]=sumr;
					array[cont][1]=sumc;
					cont++;
				}
			}
		}
		
	}*/
}
