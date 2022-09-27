import java.io.Serializable;
import java.util.GregorianCalendar;

public class SMS implements Serializable{
	private static final long serialVersionUID = 7734890676797881101L;
	private String Mittente;
	private GregorianCalendar Data;
	private int Id;
	private String Text;
	
	public SMS(int id,String mittente,GregorianCalendar data,String text){
		Mittente=mittente;
		Id=id;
		Data=data;
		Text=text;
		}
	
	public GregorianCalendar getDate() {
		return this.Data;
	}
	
	public String getSender() {
		return this.Mittente;
	}

	
	
	public int compareToSender(SMS o) {
		return this.Mittente.compareTo(o.getSender());
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String toString() {
		return "id "+Id+" data"+/*Data.toString()+*/" mittente "+Mittente+" text "+Text;
	}
	
}
