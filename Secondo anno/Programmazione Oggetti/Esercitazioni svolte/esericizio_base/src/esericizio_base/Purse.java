package esericizio_base;

import java.util.ArrayList;

public class Purse {
	private String name;
	private ArrayList<Coin> collect;
	
	public Purse(String name) {
		this.name=name;
		collect=new ArrayList<Coin>();
	}
	
	public void addCoin(int value) {
		Coin x=new Coin(name,value);
		collect.add(x);
	}
	
	public void removeCoin(Coin x) {
		collect.remove(x);
	}
	
	public boolean search(Coin x) {
		boolean result=false;
		for(int i=0;i<collect.size()&&result==false;i++) {
			result=collect.get(i).equals(x);
		}
		return result;
	}
	
	public int conteggio() {
		return collect.size();
	}
	
	public Coin min() {
		if(collect.size()>0) {
			Coin min=collect.get(0);
			for(int i=1;i<collect.size();i++) {
				if(min.coinCmp(collect.get(i))>0)
					min=collect.get(i);
			return min;
			}
		}
		return null;
	}
	
	public Coin max(){
		if(collect.size()>0) {
			Coin max=collect.get(0);
			for(int i=1;i<collect.size();i++) {
				if(max.coinCmp(collect.get(i))<0)
					max=collect.get(i);
			return max;
			}
		}
		return null;
	}
	
	public int getTotal(){
		int sum=0;
		for(int i=0;i<collect.size();i++) 
			sum+=collect.get(i).getValue();
		return sum;
	}
	
	public boolean hasCoin(Coin x) {
		boolean flag=false;
		for(int i=0;i<collect.size()&&flag==false;i++) {
			flag=collect.get(i).equals(x);
		}
		return flag;
	}
}
