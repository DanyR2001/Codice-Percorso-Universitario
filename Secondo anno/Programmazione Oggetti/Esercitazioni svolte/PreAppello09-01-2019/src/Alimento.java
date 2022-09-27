import java.io.Serializable;

public class Alimento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2122228459481564962L;
	private String nome;
	private double costo;
	private String tipo; //(pane, carne, pesce, formaggi, verdura, ortaggio, cereali), 
	private int step; // è un intero tra 1 e 5
	
	public Alimento(String nome, double costo, String tipo, int step) {
		this.nome = nome;
		this.costo = costo;
		this.tipo = tipo;
		this.step = step;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
}
