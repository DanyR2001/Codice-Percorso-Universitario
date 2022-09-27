public class Dataset {
	
	private double sum;
	private Measurable minimum;
	private Measurable maximum;
	private int count;
	
	public Dataset() {
		sum = 0;
		count = 0;
		minimum = null;
		maximum = null;
		}
	
	public void add(Measurable x) {
		sum += x.getMeasure();
		if (count == 0 || minimum.compare(x)>0)
			minimum = x;
		if (count == 0 || maximum.compare(x)<0)
			maximum = x;
		count++;
		}
	
	public double getAverage() {
		if (count == 0) 
			return 0;
		else 
			return sum / count;
		}
	
	public Measurable getMaximum() {
		return maximum;
		}
	
	public Measurable getMinimum(){
		return minimum;
		}
}
