package esericizio_base;

public class BankAccount {
	
	private String Name;
	private double Balance;
	
	public BankAccount(String name,double Balance) {
		this.Name=name;
		this.Balance=Balance;
	}
	
	public BankAccount(String name) {
		this.Name=name;
		this.Balance=0;
	}
	
	public boolean search(BankAccount x) {
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
		Balance+=x;
	}
	
	public void removeCredit(double x) {
		Balance-=x;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	
	
}
