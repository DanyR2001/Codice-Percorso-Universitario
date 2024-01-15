import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class TesserinoPersonale extends Tesserino implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2567981277514139182L;
	private String Facolta;
	private double SommaSpesa;
	private String Categoria;
	private final static List<String> tipi=Arrays.asList("Docente","Amministrativo");

	public TesserinoPersonale(String codice, String nome, String cognome, boolean stato,String facolta,double sommaSpesa,String categoria) {
		super(codice, nome, cognome, stato);
		if(!categoria.equals(tipi.get(0))&&!categoria.equals(tipi.get(1)))
			throw new RuntimeException();
		Facolta=facolta;
		SommaSpesa=sommaSpesa;
		Categoria=categoria;
		// TODO Auto-generated constructor stub
	}
	
	public double paga() throws TesserinoNonAttivoException {
		if(!super.isActive())
			throw new TesserinoNonAttivoException();
		double docente=1.6;
		double amministrativo=4;
		if(Categoria.equals(tipi.get(0))) {
			SommaSpesa+=docente;
			return docente;
		}
		else {
			SommaSpesa+=amministrativo;
			return amministrativo;
		}
		
	}
	
	public void cambiaCategoria() {
		if(Categoria.equals(tipi.get(0)))
			Categoria=tipi.get(1);
		else
			Categoria=tipi.get(0);
	}

	public String getFacolta() {
		return Facolta;
	}

	public void setFacolta(String facolta) {
		Facolta = facolta;
	}

	public double getSommaSpesa() {
		return SommaSpesa;
	}

	public void setSommaSpesa(double sommaSpesa) {
		SommaSpesa = sommaSpesa;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

}
