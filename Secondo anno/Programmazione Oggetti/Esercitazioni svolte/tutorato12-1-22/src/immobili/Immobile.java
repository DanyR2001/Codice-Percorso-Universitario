package immobili;

import java.util.Objects;

public class Immobile {
	private String code;
	private String via;
	private String proprietario;
	private double valore;
	
	public Immobile(String code, String via, String proprietario, double valore) {
		this.code = code;
		this.via = via;
		this.proprietario = proprietario;
		this.valore = valore;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public double getValore() {
		return valore;
	}
	public void setValore(double valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return " code=" + code + ", via=" + via + ", proprietario=" + proprietario + ", valore=" + valore+ " ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)	return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Immobile other = (Immobile) obj;
		return Objects.equals(code, other.code) && Objects.equals(proprietario, other.proprietario)&& this.valore==other.getValore()&& Objects.equals(via, other.via);
	}
	
	@Override
	public Immobile clone() {
		return new Immobile(code, via, proprietario, valore);
	}
	
	

	
}
