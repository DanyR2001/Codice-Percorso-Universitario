package esercizio_tutorato;

public class Predicato extends Predicate{
	public boolean test(Predicate tes) {
		if(tes%2==0)
			return false;
		else
			return true;
	}
	
}
