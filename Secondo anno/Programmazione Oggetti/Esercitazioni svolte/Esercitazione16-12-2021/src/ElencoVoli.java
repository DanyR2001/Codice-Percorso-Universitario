import java.util.ArrayList;

public class ElencoVoli {
	ArrayList<Volo> lista;

	public ElencoVoli() {
		this.lista = new ArrayList<>();
	}
	
	public void aggiungiVoli(Volo v) throws BadCodeException {
		for(Volo temp: lista) {
			if(temp.equals(v))
				throw new BadCodeException();
		}
		lista.add(v);
	}
	
	boolean isEmpty() {
		return lista.isEmpty();
	}
	
	public ElencoVoli cerca(String a, String p) throws BadCodeException {
		if(lista.isEmpty()) {
			System.out.println("1 ");
			return null;
		}
		ElencoVoli temp=new ElencoVoli();
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).equals(a, p))
				temp.aggiungiVoli(lista.get(i));
		if(temp.isEmpty()) {
			System.out.println("p 2");
			return null;
		}
		return temp;
	}
	
	public String[] allPlace() {
		ArrayList<String> temp=new ArrayList<>();
		boolean flag=true;
		for(Volo v: lista) {
			flag=true;
			for(int i=0;i<temp.size()&&flag;i++) {
				String mom=temp.get(i);
				if(v.getArrivo().equals(mom))
					flag=false;		
			}
			if(flag)
				temp.add(v.getArrivo());
		}
		for(Volo v: lista) {
			flag=true;
			for(int i=0;i<temp.size()&&flag;i++) {
				String mom=temp.get(i);
				if(v.getPartenza().equals(mom))
					flag=false;		
			}
			if(flag)
				temp.add(v.getPartenza());
		}
		String[] fine= new String[temp.size()];
		for(int i=0;i<temp.size();i++)
			fine[i]=temp.get(i);
		return fine;
	}
	
	public String[] getCodeNum() {
		ArrayList<String> temp=new ArrayList<>();
		for(Volo v: lista) 
				temp.add(v.getCodeVol());
		String[] fine= new String[temp.size()];
		for(int i=0;i<temp.size();i++)
			fine[i]=temp.get(i);
		return fine;
	}
	
	public Volo getCodeVolo(String code) {
		Volo ret=null;
		for(int i=0;i<lista.size();i++)
			if(lista.get(i).getCodeVol().equals(code))
				ret=lista.get(i);
		return ret;
	}
	
	public Volo getIndex(int i) {
		return lista.get(i);
	}

	@Override
	public String toString() {
		String ret="";
		for(Volo p: lista)
			ret+=p.toString();
		return ret;
	}
	
}
