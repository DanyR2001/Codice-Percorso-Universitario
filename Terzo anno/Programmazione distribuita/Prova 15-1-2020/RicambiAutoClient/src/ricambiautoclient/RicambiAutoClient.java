/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ricambiautoclient;

import StandardPackage.*;
import java.util.List;
import javax.naming.*;

/**
 *
 * @author danielerusso
 */
public class RicambiAutoClient {

    /**
     * @param args the command line arguments
     */
    private static EJBStatelessRemote ricambiEJB;
    
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ctx=new InitialContext();
        
        ricambiEJB= (EJBStatelessRemote) ctx.lookup("java:global/EJBRicambiAuto/EJBStateless!StandardPackage.EJBStatelessRemote");
        
        System.out.println(ricambiEJB.selectAll());
        
        System.out.println(ricambiEJB.selectById(1));
        
        System.out.println(ricambiEJB.selectByCategory("Motore"));
        
        List<RicambioAuto> listaAuto=ricambiEJB.selectAll();
        for (RicambioAuto a: listaAuto)
            if (a.getDisponibilita()<10)
               System.out.println(a); 
        
    }
    
}
