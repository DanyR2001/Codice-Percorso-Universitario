package ricambioautostdclient;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ricambi.*;

public class RicambioAutoStdClient {

    private static RicambioAutoEJBRemote ricambiEJB;
    
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        ricambiEJB = (RicambioAutoEJBRemote) ctx.lookup("java:global/RicambioAuto/RicambioAutoEJB!ricambi.RicambioAutoEJBRemote");
        
        System.out.println("Tutti i pezzi di ricambio");
        List<RicambioAutoEntity> listaAuto = ricambiEJB.cercaTuttiRicambioAuto();
        for(RicambioAutoEntity a: listaAuto)
            System.out.println(a);
        
        String categoria = "Freni";
        System.out.println("Tutti i pezzi di ricambio della categoria " + categoria);
        listaAuto = ricambiEJB.cercaPerCategoria(categoria);
        for(RicambioAutoEntity a: listaAuto)
            System.out.println(a);
        
        System.out.println("Tutti i pezzi di ricambio da ordinare");
        listaAuto = ricambiEJB.cercaDaOrdinare();
        for(RicambioAutoEntity a: listaAuto)
            System.out.println(a);
    }
    
}