package esericizio_base;

public class Coin {
	private int value;
	private String name;
	
	public Coin(String name,int value) {
		this.name=name;
		this.value=value;
	}
	
	public boolean equals(Coin x) {
		boolean result=false;
		if(this.name.equals(x.getName())&&this.value==x.getValue())
			result=true;
		return result;
	}
	
	public int coinCmp(Coin x) {
		return this.value-x.getValue();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
