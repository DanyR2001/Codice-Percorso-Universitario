package esericizio_base;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<BankAccount> database;
	
	public Bank() {
		database=new ArrayList();
	}
	
	public void addAccount(double balance,String name) {
		BankAccount newcustomer=new BankAccount(name,balance);
		database.add(newcustomer);
	}
	
	public boolean deposit(String nameAccount,double amount) {
		boolean flag=false;
		if(database.size()>0) {
			BankAccount actual=new BankAccount(nameAccount);
			for(int i=0;i<database.size()&&flag==false;i++)
				if(actual.equals(database.get(i))) {
					if(amount<database.get(i).getBalance()) {
						database.get(i).removeCredit(amount);
						flag=true;
					}
				}
			return flag;
		}
		return flag;
	}
	
	public boolean withdraw(String nameAccount,double amount) {
		boolean flag=false;
		if(database.size()>0) {
			BankAccount actual=new BankAccount(nameAccount);
			for(int i=0;i<database.size()&&flag==false;i++)
				if(actual.equals(database.get(i))) {
					database.get(i).addCredit(amount);
					flag=true;
					}
			return flag;
		}
		return flag;
	}
	
	public double getBalance(String nameAccount) {
		if(database.size()>0) {
			BankAccount actual=new BankAccount(nameAccount);
			for(int i=0;i<database.size();i++)
				if(actual.equals(database.get(i))) {
					return database.get(i).getBalance();
					}
			return -1;
		}
		return -1;
	}
	
	public boolean transfer(String fromAccount,String toAccount,double amount) {
		boolean flag1=false,flag2=false;
		if(database.size()>0) {
			BankAccount from=new BankAccount(fromAccount);
			BankAccount recever=new BankAccount(toAccount);
			for(int i=0;i<database.size()&&flag1==false;i++)
				if(from.equals(database.get(i))&&amount<database.get(i).getBalance()) {
					from=database.get(i);
					flag1=true;
					for(int j=0;j<database.size()&&flag2==false;j++)
						if(recever.equals(database.get(j))) {
							recever=database.get(j);
							from.removeCredit(amount);
							recever.addCredit(amount);
							flag2=true;
						}
					}
			return flag1&&flag2;
		}
		return flag1&&flag2;
	}
	
}
