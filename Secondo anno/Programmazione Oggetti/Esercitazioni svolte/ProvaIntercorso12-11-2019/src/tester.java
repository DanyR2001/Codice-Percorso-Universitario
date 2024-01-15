import java.time.LocalTime;

import javax.print.attribute.standard.PrinterInfo;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*- Istanzia un sistema domotico con limite di consumo 3kW e con 30 dispositivi casuali, di cui 15 con spegnimento automatico e 15 con spegnimento programmato.
		- Visualizza le informazioni dei dispositivi del sistema.
		- Visualizza il consumo totale dei dispositivi accesi.
		- Visualizza le informazioni dei dispositivi ancora accesi.
		*/
		SistemaDomotico x = new SistemaDomotico(3);
		for (int i = 1, j = 0; i <= 30; i++, j++) {
			if (j == 0) {
				LampadinaRGB lap = null;
				if (i % 2 == 0) {
					lap = new LampadinaRGB(LocalTime.now(), "Rosso");
				} else {
					lap = new LampadinaRGB(LocalTime.now(), LocalTime.now().plusHours(i), false, "rosa");
				}
				x.aggiungiDispositivo(lap);
			} else if (j == 1) {
				Climatizzatore cli = null;
				if (i % 2 == 0) {
					cli = new Climatizzatore(LocalTime.now(), i);
				} else {
					cli = new Climatizzatore(LocalTime.now(), LocalTime.now().plusHours(i), true, i);
				}
				x.aggiungiDispositivo(cli);
			} else if (j == 2) {
				Persiana per = null;
				if (i % 2 == 0) {
					per = new Persiana(LocalTime.now(), "barbabietola");
				} else {
					per = new Persiana(LocalTime.now(), LocalTime.now().plusHours(i), false, "panino");
				}
				x.aggiungiDispositivo(per);
				j = -1;
			}
		}
		System.out.print(x.toString());
		System.out.println(x.controllaConsumo() + " lista contro i " + x.getMAX_CONSUMI());
		try {
			x.control();
		} catch (MaximumLimitedExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(x.controllaConsumo() + " lista contro i " + x.getMAX_CONSUMI());

	}

}
