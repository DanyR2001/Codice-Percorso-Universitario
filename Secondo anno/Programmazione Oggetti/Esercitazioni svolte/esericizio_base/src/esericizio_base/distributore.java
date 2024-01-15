package esericizio_base;

public class distributore {
	
	private int n_lattine;
	private final static int max_lattine=100;
	private int n_gettorni;
	
	void distributore(int n_lattine) {
		if(n_lattine<max_lattine)
			this.n_lattine=n_lattine;
		else
			this.n_lattine=0;
	}
	
	void distributore(int n_lattine,int n_gettoni) {
		this.n_gettorni=n_gettoni;
		if(n_lattine<max_lattine)
			this.n_lattine=n_lattine;
		else
			this.n_lattine=0;
	}
	
	public int acquisto(int gettoni) {
		if(gettoni>0||gettoni<=this.n_lattine) {
			this.n_gettorni+=gettoni;
			this.n_lattine-=gettoni;
			return 0;
		}
		return -1;
	}
	
	public void instant() {
		System.out.println("La macchina ha attualmente n "+n_lattine+" lattine, e n "+n_gettorni+" di gettoni");
	}
	
	public void refill(int unit) {
		this.n_lattine+=unit;
	}

	public int getN_lattine() {
		return n_lattine;
	}

	public void setN_lattine(int n_lattine) {
		this.n_lattine = n_lattine;
	}

	public int getN_gettorni() {
		return n_gettorni;
	}

	public void setN_gettorni(int n_gettorni) {
		this.n_gettorni = n_gettorni;
	}
	
	
}
