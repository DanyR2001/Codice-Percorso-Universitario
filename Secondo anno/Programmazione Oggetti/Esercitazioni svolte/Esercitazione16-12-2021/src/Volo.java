import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Volo {
	private String Partenza;
	private String Arrivo;
	private String CodeVol;
	private String Compagnia;
	private static final String[] type= {"economy","business", "first class"};
	private ArrayList<Posto> lista;
	private ArrayList<Prenotazione> prenotazioni;
	private boolean Stato;
	
	public Volo(String partenza, String arrivo, String codeVol, String compagnia, ArrayList<Posto> lista, boolean stato) {
		Partenza = partenza;
		Arrivo = arrivo;
		CodeVol = codeVol;
		Compagnia = compagnia;
		this.lista = lista;
		prenotazioni=new ArrayList<>();
		Stato = stato;
	}
	
	public void acquistaPosto(String nome,String Cognome,String type,String CF,Posto p) {
		boolean flag=false;
		for (String t: this.type)
			if(t.equals(type))
				flag=true;
		for(Posto pos: lista)
			if(pos.equals(p))
				pos.setStato(true);
		prenotazioni.add(new Prenotazione(nome, Cognome, CF, this.CodeVol,type , p));
	}
	
	public String getPrenotazioni() {
		String ret="";
		for(Prenotazione p: prenotazioni)
			ret+=p.toString()+"\n";
		if(prenotazioni.isEmpty())
			return null;
		else
			return ret;
	}


	public String getPartenza() {
		return Partenza;
	}


	public void setPartenza(String partenza) {
		Partenza = partenza;
	}


	public String getArrivo() {
		return Arrivo;
	}


	public void setArrivo(String arrivo) {
		Arrivo = arrivo;
	}


	public String getCodeVol() {
		return CodeVol;
	}


	public void setCodeVol(String codeVol) {
		CodeVol = codeVol;
	}


	public String getCompagnia() {
		return Compagnia;
	}


	public void setCompagnia(String compagnia) {
		Compagnia = compagnia;
	}


	public ArrayList<Posto> getLista() {
		return lista;
	}


	public void setLista(ArrayList<Posto> lista) {
		this.lista = lista;
	}


	public boolean isStato() {
		return Stato;
	}


	public void setStato(boolean stato) {
		Stato = stato;
	}


	public ArrayList<Posto> filtraPosti(Filter f){
		return new ArrayList<Posto>(lista.stream().filter(s->f.accept(s)).collect(Collectors.toList()));
	}
	
	
	/*
	numero di fila, una lettera indicante la posizione nella fila e uno stato 
	*/
	
	public String toString() {
		String ret="";
		ret+="Il volo "+CodeVol+" della compagnia "+CodeVol+" proveniente da "+Partenza+" e deretto a "+Arrivo+" Stato:"+Stato+"\n";
		for(int i=0;i<lista.size();i++) {
			ret+=lista.get(i).toString()+"\n";
		}
		for(int i=0;i<prenotazioni.size();i++) {
			ret+=prenotazioni.get(i).toString()+"\n";
		}
		return ret;
	}
	
	
	public boolean equals(Volo obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;	
		return Objects.equals(Arrivo, obj.getArrivo()) && Objects.equals(CodeVol, obj.getCodeVol())
				&& Objects.equals(Compagnia, obj.getCompagnia()) && Objects.equals(Partenza, obj.getPartenza())
				&& Stato == obj.isStato();
	}
	
	public boolean equals(String p,String a) {
		System.out.println("p "+p+" Partenza;"+Partenza+" a "+a+" Arraivo: "+Arrivo);
		return Arrivo.equals(a) && Partenza.equals(p);
	}

	public Volo clone(){
		Volo temp=new Volo(this.Partenza,this.Arrivo,this.CodeVol,this.Compagnia,this.lista,this.Stato);
		return temp;
	}
	
	public Posto findPosto(int po,char l) {
		for(Posto p: lista)
			if(p.getLettera()==l&&p.getNumFila()==po)
				return p;
		return null;
	}
	
	public ArrayList<Posto> clonePosti(){
		ArrayList<Posto> temp=new ArrayList<>();
		for(Posto p: lista)
			temp.add(p.clone());
		return temp;
	}
	
}
