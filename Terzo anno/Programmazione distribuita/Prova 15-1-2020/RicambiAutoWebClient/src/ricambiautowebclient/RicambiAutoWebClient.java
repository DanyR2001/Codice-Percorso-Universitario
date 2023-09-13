/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ricambiautowebclient;

import java.util.Scanner;
import standardpackage.RicambioAuto;

/**
 *
 * @author danielerusso
 */

public class RicambiAutoWebClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Quale pezzo vuoi modificare?");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        
        System.out.print("Con quale valore?");
        Float prezzo = scanner.nextFloat();
        
        RicambioAuto a = cercaPerId(id);
        a.setPrezzo(prezzo);
        aggiornaRicambioAuto(a);
    }

    private static RicambioAuto cercaPerId(Integer arg0) {
        standardpackage.EJBStatelessService service = new standardpackage.EJBStatelessService();
        standardpackage.EJBStateless port = service.getEJBStatelessPort();
        return port.selectById(arg0);
    }

    private static RicambioAuto aggiornaRicambioAuto(standardpackage.RicambioAuto arg0) {
       standardpackage.EJBStatelessService service = new standardpackage.EJBStatelessService();
       standardpackage.EJBStateless port = service.getEJBStatelessPort();
        return port.updateRicambio(arg0);
    }
    
}
