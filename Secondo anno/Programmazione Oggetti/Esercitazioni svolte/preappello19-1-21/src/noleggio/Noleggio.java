package noleggio;

public class Noleggio{
	private Film film;
	private int id;
	private int delay;
	
	public Noleggio(Film x,int ID,int Delay) throws BadIDException {
		if(ID<0)
			throw new BadIDException("Sono un negro");
		else {
			film=x;
			id=ID;
			delay=Delay;
		}
	}
	
	public double calcolaPenale() {
		return film.calcolaPenaleRitardo(delay);
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	public String toString() {
		return film.toString()+", ID:"+id+", ritardo:"+delay;
	}
}
