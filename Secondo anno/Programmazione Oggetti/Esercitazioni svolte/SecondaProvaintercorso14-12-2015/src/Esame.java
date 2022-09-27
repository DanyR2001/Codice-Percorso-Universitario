import java.util.Date;

public class Esame {
	private String Insegnamento;
	private int Voto;
	private Date DataEs;
	private Docente doc;
	private boolean Stato;
	private boolean lode;
	
	public Esame(String insegnamento, int voto, Date dataEs, Docente doc,boolean stato) {
		Insegnamento = insegnamento;
		Voto = voto;
		DataEs = dataEs;
		this.doc = doc;
		Stato=stato;
		this.lode=false;
	}

	public String getInsegnamento() {
		return Insegnamento;
	}


	public void setInsegnamento(String insegnamento) {
		Insegnamento = insegnamento;
	}


	public int getVoto() {
		return Voto;
	}


	public void setVoto(int voto) {
		Voto = voto;
	}


	public Date getDataEs() {
		return DataEs;
	}


	public void setDataEs(Date dataEs) {
		DataEs = dataEs;
	}


	public Docente getDoc() {
		return doc;
	}


	public void setDoc(Docente doc) {
		this.doc = doc;
	}
	
	public boolean isDato() {
		return Stato;
	}
	
	public void setAll(int voto, Docente doc,boolean stato,boolean lode) {
		Voto = voto;
		DataEs = new Date();
		this.doc = doc;
		Stato=stato;
		this.lode=lode;
	}

	@Override
	public String toString() {
		String ret="";
		
		ret="Esame [Insegnamento=" + Insegnamento + ",	Voto=";
		if(Stato=false) {
			ret +=Voto+",	DataEs=" + DataEs + ", doc=" + doc
					+", lode=" + lode ;
		}
		else {
			ret +="-,	DataEs= -,	doc= -,	lode= -";
		}
		ret+="]\n";
		return ret;
			
	}
	
	

}
