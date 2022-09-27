
public class Iride extends Biometria {
	private String Occhio; // (destro o sinistro), 
	private String IrisCode; // (codice stringa di 6 caratteri
	private final static int IrisCodeLenght=6;
	
	public Iride(String strumentoMisurazione,String occhio,String irisCode) {
		super(strumentoMisurazione);
		if(!occhio.equals("destro")&&!occhio.equals("sinistro")&&irisCode.length()!=IrisCodeLenght)
			throw new IllegalArgumentException();
		Occhio=occhio;
		IrisCode=irisCode;
	}
	
	public String getOcchio() {
		return Occhio;
	}

	public void setOcchio(String occhio) {
		Occhio = occhio;
	}

	public String getIrisCode() {
		return IrisCode;
	}

	public void setIrisCode(String irisCode) {
		IrisCode = irisCode;
	}

	public boolean verifica(Biometria b) {
		if(!(b instanceof Iride))
			return false;
		Iride temp=(Iride) b;
		return Occhio.equals(temp.getOcchio())&&IrisCode.equals(temp.getIrisCode());
	}
	
	public int similarità(Biometria b) throws WrongTypeException {
		int count=0;
		if(!(b instanceof Iride))
			throw new WrongTypeException();
		Iride temp=(Iride) b;
		for(int i=0;i<IrisCodeLenght;i++) {
			if(IrisCode.charAt(i)==temp.getIrisCode().charAt(i))
				count++;
		}
		return count;
	}

	public String toString() {
		return super.toString()+"typeIride Occhio=" + Occhio + ", IrisCode=" + IrisCode + " ";
	}
	
}
