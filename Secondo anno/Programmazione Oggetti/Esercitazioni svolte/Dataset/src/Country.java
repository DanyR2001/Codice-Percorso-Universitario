
public class Country implements 
{
	private String name;
	private double area;
	
	public Country(String name, double area) {
		this.area=area;
		this.name=name;
	}
	
	public double getMeasure() {
		return this.area;
	}
	
	public int compare(Measurable x) {
		Country y=(Country) x;
		if(this.area>y.getMeasure())
			return 1;
		else if(this.area<y.getMeasure())
			return -1;
		else 
			return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
}
