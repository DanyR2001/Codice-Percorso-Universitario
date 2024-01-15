public class Dataset {
	
	private double sum;
	private Object minimum;
	private Object maximum;
	private int count;
	private Measurer app;
	
	
	public Dataset(Measurer x) {
		sum = 0;
		count = 0;
		minimum = null;
		maximum = null;
		app=x;
		}
	
	public void add(Object x) {
		sum += app.measure(x);
		if (count == 0 ||app.measure(x)<app.measure(minimum))
			minimum = x;
		if (count == 0 || app.measure(maximum)<app.measure(x))
			maximum = x;
		count++;
		}
	
	public double getAverage() {
		if (count == 0) 
			return 0;
		else 
			return sum / count;
		}
	
	public Object getMaximum() {
		return maximum;
		}
	
	public Object getMinimum(){
		return minimum;
		}
}
