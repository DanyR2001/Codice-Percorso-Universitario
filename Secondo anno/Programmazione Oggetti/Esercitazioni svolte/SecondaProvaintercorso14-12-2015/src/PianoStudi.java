import java.util.ArrayList;

public class PianoStudi {
	private ArrayList<Esame> Lista;
	private static final String[] type= {"Reti","Sistemi"};
	
	public PianoStudi(String Type) {
		Lista=new ArrayList<>();
		if(Type.equals(type[0])) {
			this.loadExam1();
		}
		else if(Type.equals(type[1])) {
			this.loadExam2();
		}
	}
	
	private void loadExam1() {
		Lista.add(new Esame("Architettura degli elaboratori", -1, null, null,false));
		Lista.add(new Esame("Programmazione 1", -1, null, null,false));
		Lista.add(new Esame("Programmazione 2", -1, null, null,false));
		Lista.add(new Esame("Programmazione Web", -1, null, null,false));
		Lista.add(new Esame("Reti di calcolatori", -1, null, null,false));
		Lista.add(new Esame("Sistemi Operativi", -1, null, null,false));
	}
	
	private void loadExam2() {
		Lista.add(new Esame("INTRODUZIONE AGLI ALGORITMI E ALLE STRUTTURE DATI", -1, null, null,false));
		Lista.add(new Esame("PROGRAMMAZIONE I", -1, null, null,false));
		Lista.add(new Esame("BASI DI DATI", -1, null, null,false));
		Lista.add(new Esame("PROGRAMMAZIONE II", -1, null, null,false));
		Lista.add(new Esame("INGEGNERIA DEL SOFTWARE", -1, null, null,false));
		Lista.add(new Esame("PROGRAMMAZIONE DISTRIBUITA", -1, null, null,false));
	}
	
	public int getEsamiDati() {
		if(Lista.isEmpty())
			return -1;
		int tot=0;
		for(Esame e: Lista) {
			if(e.isDato())
				tot++;
		}
		return tot;
	}
	
	public double getMedia() {
		if(Lista.isEmpty())
			return -1;
		double tot=0;
		for(Esame e: Lista) {
			if(e.isDato())
				tot+=e.getVoto();
		}
		return tot/this.getEsamiDati();
	}
	
	public Esame getEsame(String ins) {
		boolean flag=true;
		Esame ret=null;
		for(int i=0;i<Lista.size()&&flag;i++)
			if(Lista.get(i).getInsegnamento().equals(ins)) {
				flag=false;
				ret=Lista.get(i);
			}
		if(flag)
			return null;
		else
			return ret;
	}
	
	public boolean getEsameDoc(String ins) {
		boolean flag=true;
		for(int i=0;i<Lista.size()&&flag;i++)
			if(Lista.get(i).getInsegnamento().equals(ins)) {
				flag=false;
			}
		return !flag;
	}

	@Override
	public String toString() {
		return "PianoStudi :\n" + Lista + ";";
	}
	
	
	
	
}
