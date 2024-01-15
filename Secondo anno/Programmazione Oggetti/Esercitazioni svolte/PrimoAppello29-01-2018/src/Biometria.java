import java.util.GregorianCalendar;

public class Biometria {
	private GregorianCalendar DataCreazione;
	private String StrumentoMisurazione;
	
	public Biometria(String strumentoMisurazione) {
		DataCreazione=new GregorianCalendar();
		StrumentoMisurazione=strumentoMisurazione;
	}
	
	public Biometria(GregorianCalendar data, String strumentoMisurazione) {
		if(data.after(new GregorianCalendar()))
			throw new IllegalArgumentException();
		DataCreazione=new GregorianCalendar();
		StrumentoMisurazione=strumentoMisurazione;
	}

	public GregorianCalendar getDataCreazione() {
		return DataCreazione;
	}

	public String getStrumentoMisurazione() {
		return StrumentoMisurazione;
	}

	public void setStrumentoMisurazione(String strumentoMisurazione) {
		StrumentoMisurazione = strumentoMisurazione;
	}

	@Override
	public String toString() {
		return "Biometria: [DataCreazione=" + ", StrumentoMisurazione=" + StrumentoMisurazione + " ";
	}
	
}
