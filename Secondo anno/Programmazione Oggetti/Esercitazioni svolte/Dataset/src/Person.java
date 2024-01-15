public class Person implements Comparable{
	String nome;
	
	public int compareTo(Object x) {
		Person y=(Person) x;
		return this.nome.compareTo(y.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
