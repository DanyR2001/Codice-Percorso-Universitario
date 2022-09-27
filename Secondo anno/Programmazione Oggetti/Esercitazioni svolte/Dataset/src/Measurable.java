import java.util.ArrayList;

public interface Measurable {
	double getMeasure();
	int compare(Measurable x);
	
	public static Measurable smallest(ArrayList<Measurable> x) {
		Measurable small=null;
		if(x.size()>=1) {
			small=x.get(0);
			for(int i=1;i<x.size();i++)
				if(small.compare(x.get(i))<0)
					small=x.get(i);
			}
		return small;
	}
	
	public static Measurable largest(ArrayList<Measurable> x) {
		Measurable larg=null;
		if(x.size()>=1) {
			larg=x.get(0);
			for(int i=1;i<x.size();i++)
				if(larg.compare(x.get(i))>0)
					larg=x.get(i);
			}
		return larg;
	}
}
