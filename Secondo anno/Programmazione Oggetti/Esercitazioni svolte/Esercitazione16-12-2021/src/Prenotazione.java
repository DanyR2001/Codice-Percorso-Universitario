
public class Prenotazione {
	private String Nome;
	private String Cognome;
	private String CodFis;
	private String CodeVol;
	private String Type;
	private Posto Acq;
	
	public Prenotazione(String nome, String cognome, String codFis, String codeVol, String type, Posto acq) {
		Nome = nome;
		Cognome = cognome;
		CodFis = codFis;
		CodeVol = codeVol;
		Type = type;
		Acq = acq;
	}

	@Override
	public String toString() {
		return "		Prenotazione:\n 			Nome=" + Nome + ", Cognome=" + Cognome + ", CodFis=" + CodFis + ", CodeVol=" + CodeVol
				+ ", Type=" + Type + ", Acq=" + Acq + "";
	}
	
	
	
}
