

public class bankAccount{
	
	private String Name;
	private double Balance;
	
	public bankAccount(String name,double Balance) {
		if(Balance<0)
			throw new IllegalArgumentException("Valore negativo");
		this.Name=name;
		this.Balance=Balance;
	}
	
	public bankAccount(String name) {
		this.Name=name;
		this.Balance=0;
	}
	
	public boolean search(bankAccount x) {
		boolean flag=false;
		if(x.getName().equals(this.Name))
			flag=true;
		return flag;
	}

	
	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}
	
	public void addCredit(double x) {
		if(x<0)
			throw new IllegalArgumentException("Valore negativo");
		Balance+=x;
	}
	
	public void removeCredit(double x) throws Exception {
		if(x<0||x>this.Balance)
			throw new Exception("Valore prelievo errato");
		Balance-=x;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	
	public double getMeasure(){
		return this.Balance;
	}
	
	/*public int compare(Measurable x){
		BankAccount y=(BankAccount) x;
		if(this.Balance>y.getBalance())
			return 1;
		else if(this.Balance<y.getBalance())
			return -1;
		else 
			return 0;
	}*/
}
