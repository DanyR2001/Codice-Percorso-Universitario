import java.util.ArrayList;

public class Unisa {
	private ArrayList<Utente> list;
	
	public Unisa() {
		list=new ArrayList<>();
	}
	
	public void addUtente(Utente x) {
		list.add(x);
	}
	
	public Utente findUser(String login,String password) {
		if(list.isEmpty())
			return null;
		for(Utente u: list) {
			if(u.equals(login, password))
				return u;
		}
		return null;
	}
	
	public String[] getAllStudent(Utente d) {
		String[] ret=new String[list.size()-1];
		if(d instanceof Docente) {
			Docente doc=(Docente) d;
			for(Utente u: list) {
				int i=0;
				if(u instanceof Studente) {
					Studente t=(Studente) u;
					if(t.getP().getEsameDoc(doc.getInsegnamento())) {
						ret[i]=t.getMatricola();
						i++;
					}
				}
			}
			return ret;
		}
		return null;
	}
	
	public void addEsame(String x,int voto,boolean lode,Docente d) {
		for(Utente u: list) {
			if(u instanceof Studente) {
				Studente t=(Studente) u;
				if(t.equals(x)) {
					t.getP().getEsame(d.getInsegnamento()).setAll(voto, d, true, lode);
				}
			}
		}
	}
	
	

}
