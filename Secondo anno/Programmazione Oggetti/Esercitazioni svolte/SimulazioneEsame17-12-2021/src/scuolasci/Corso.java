package scuolasci;

import java.util.Date;

public interface Corso {
	String daiNomeCorso();
	int daiNumeroMinimoPartecipanti();
	int daiNumeroMassimoPartecipanti();
	int daiNumeroPartecipanti();
	Date daiData();
	boolean aggiungiPartecipante();
	boolean corsoAttivato();
}
