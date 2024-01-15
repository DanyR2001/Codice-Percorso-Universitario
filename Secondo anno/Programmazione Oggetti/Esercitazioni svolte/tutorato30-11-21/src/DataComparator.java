import java.util.Comparator;

public class DataComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		SMS x=(SMS) o1;
		SMS y=(SMS) o2;
		return x.getDate().compareTo(y.getDate());
	}

}
