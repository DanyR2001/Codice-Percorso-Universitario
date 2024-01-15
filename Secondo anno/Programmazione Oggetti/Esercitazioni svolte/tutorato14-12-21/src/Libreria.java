import java.io.IOException;
import java.util.ArrayList;

public class Libreria {
	private ArrayList<Libro> list;

	public Libreria() {
		list = new ArrayList<>();
	}
	
	public void addLib(Libro x) {
		list.add(x);
	}
	
	public boolean findTitle(String title) throws IOException {
		boolean flag=false;
		for(int i=0;i<list.size()&&flag==false;i++)
			if(title.equals(list.get(i).getTitolo()))
				flag=true;
		if(flag==false)
			throw new IOException("Non trovato");
		return flag;
	}
	
	public String toString(){
		String x=null;
		for(int i=0;i<list.size();i++)
			x+=list.get(i).toString();
		return x;
	}
	
}
