package esericizio_base;

public class SavingAccount {
	
	private double Balance;
	private double Interest_rate;
	
	public SavingAccount(double Balance) {
		this.Balance=Balance;
		this.Interest_rate=0.1;
	}
	
	public SavingAccount(double Balance,double Interest_rate) {
		this.Balance=Balance;
		this.Interest_rate=Interest_rate;
	}

	public SavingAccount() {
		this.Balance=0;
		this.Interest_rate=0.1;
	}

	public void addInterest() {
		this.Balance+=((this.Balance*this.Interest_rate)-this.Balance)/4;
		//this.Balance+=this.Balance*this.Interest_rate/4;
	}
	
	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public double getInterest_rate() {
		return Interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		Interest_rate = interest_rate;
	}
	
	
	
}
