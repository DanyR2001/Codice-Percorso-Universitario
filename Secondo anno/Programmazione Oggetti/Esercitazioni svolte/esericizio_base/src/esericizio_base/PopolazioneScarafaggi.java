package esericizio_base;

public class PopolazioneScarafaggi {
	
	private int num_sca;
	
	public PopolazioneScarafaggi(int start) {
		num_sca=start;
		}
	
	public void moltiply() {
		num_sca*=2;
	}
	
	public void ten_percent() {
		num_sca=num_sca-num_sca/10;
	}
	
	public int print_num_sca() {
		return num_sca;
	}
}
