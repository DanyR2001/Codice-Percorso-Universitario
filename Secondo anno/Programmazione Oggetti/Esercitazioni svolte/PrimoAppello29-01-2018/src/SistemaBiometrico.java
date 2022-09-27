import java.util.ArrayList;

public class SistemaBiometrico {
	private ArrayList<Biometria> lista;
	
	public SistemaBiometrico() {
		lista=new ArrayList();
	}
	
	void aggiungiBiometria(Biometria b) {
		lista.add(b);
	}
	
	String daiTipoBiometria(int i) {
		Biometria temp=null;
		if(i<lista.size())
			temp=lista.get(i);//che restituisce il tipo dell’i-esima biometria (iride/volto).
		else 
			return "Elemento non pervenuto";
		if(temp instanceof Volto)
			return "Volto";
		else if (temp instanceof Iride)
			return "Iride";
		else
			return "Errore";
	}
	
	boolean verificaBiometria(String code) {
		boolean flag=false;
		if(lista.isEmpty())
			return false;
		if(code.length()==6)
			for(int i=0;i<lista.size()&&flag==false;i++) {
				Biometria temp=lista.get(i);
				if(temp instanceof Iride) {
					Iride x=(Iride)temp;
					if(x.getIrisCode().equals(code))
						flag=true;
				}
			}
		else if(code.length()==10) {
			for(int i=0;i<lista.size()&&flag==false;i++) {
				Biometria temp=lista.get(i);
				if(temp instanceof Volto) {
					Volto x=(Volto)temp;
					if(x.getFoto().equals(code))
						flag=true;
				}
		}
	}
		else 
			return false;
		return flag;
	}
	
	int indexBiometria(String code) {
		int flag=-1;
		if(lista.isEmpty())
			return -1;
		if(code.length()==6)
			for(int i=0;i<lista.size()&&flag==-1;i++) {
				Biometria temp=lista.get(i);
				if(temp instanceof Iride) {
					Iride x=(Iride)temp;
					if(x.getIrisCode().equals(code))
						flag=i;
				}
			}
		else if(code.length()==10) {
			for(int i=0;i<lista.size()&&flag==-1;i++) {
				Biometria temp=lista.get(i);
				if(temp instanceof Volto) {
					Volto x=(Volto)temp;
					if(x.getFoto().equals(code))
						flag=i;
				}
			}
		}
		else 
			return -1;
		return flag;
	}
	
	Biometria getVicino(Biometria b) throws WrongTypeException {
		Volto mom = null;
		Iride mo1 = null;
		if(b instanceof Volto) {
			mom=(Volto)b;
		}
		else if (b instanceof Iride) {
			mo1=(Iride)b;
		}
		else
			return null;
		double offset=0;
		Biometria last = null;
		for(int i=0;i<lista.size();i++) {
			Biometria temp=lista.get(i);
			if(temp instanceof Volto&&mom!=null) {
				Volto x=(Volto)temp;
				double comp=x.similarità(mom);
				if(offset<comp) {
					offset=comp;
					last=x;
				}
			}
			else if(temp instanceof Iride&&mo1!=null) {
				Iride x=(Iride)temp;
				double comp=x.similarità(mo1);
				if(offset<comp) {
					offset=comp;
					last=x;
				}
			}
		
		}
		return last;
	}
	
	ArrayList<Biometria> cerca(String tipo) throws WrongBiometryException{
		ArrayList Last=new ArrayList<>();
		if(!tipo.equals("Volto")&&!tipo.equals("Iride"))
			throw new WrongBiometryException();
		else {
			if(tipo.equals("Volto")) {
				for(int i=0;i<lista.size();i++) {
					Biometria temp=lista.get(i);
					if(temp instanceof Volto) {
						Volto x=(Volto)temp;
						Last.add(x);
						}
				}	
			}
			else if(tipo.equals("Iride")) {
				for(int i=0;i<lista.size();i++) {
					Biometria temp=lista.get(i);
					if(temp instanceof Iride) {
						Iride x=(Iride)temp;
						Last.add(x);
					}
				}
			}
		
		}
		return Last;
		}
	
	public String toString() {
		String ret="";
		for(int i=0;i<lista.size();i++) {
			ret+=lista.get(i).toString()+"\n";
		}
		return ret;
	}
	
	public String toString(int i) {
		return lista.get(i).toString();
	}

	
}
