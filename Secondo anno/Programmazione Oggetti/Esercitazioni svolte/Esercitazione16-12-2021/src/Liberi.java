
public class Liberi implements Filter {
	public boolean accept(Object obj) {
		if(obj instanceof Posto) {
			Posto temp=(Posto) obj;
			return !temp.isStato();
		}
		return false;
	}
}
