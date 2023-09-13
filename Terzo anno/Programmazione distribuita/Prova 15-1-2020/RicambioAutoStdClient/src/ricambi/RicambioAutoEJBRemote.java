package ricambi;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface RicambioAutoEJBRemote {
    void aggiungiRicambioAuto(RicambioAutoEntity a);
    void rimuoviRicambioAuto(RicambioAutoEntity a);
    RicambioAutoEntity aggiornaRicambioAuto(RicambioAutoEntity a);
    
    List<RicambioAutoEntity> cercaTuttiRicambioAuto();
    RicambioAutoEntity cercaPerId(Integer id);
    List<RicambioAutoEntity> cercaPerCategoria(String categoria);
    List<RicambioAutoEntity> cercaDaOrdinare();
}