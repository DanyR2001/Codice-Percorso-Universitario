/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package standardclient;

import StandardPackage.EJBCaseRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author danielerusso
 */
public class StandardClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context c=new InitialContext();
        EJBCaseRemote ejb=(EJBCaseRemote)c.lookup("java:global/RUSSODANIELEEJBCase/EJBCase!StandardPackage.EJBCaseRemote");//mancanza cast esplicito
        float soglia = 800f,up=2000f,low=800f;
        String CAP="84121";
        System.out.println("Stampa di tutti gli immobili con prezzo di affitto inferiore a "+soglia);
        System.out.println(ejb.SelectByInfPrice(soglia));
        System.out.println("Stampa di tutti gli immobili con cap = "+CAP+" e prezzo campreso tra "+low+" e "+up);
        System.out.println(ejb.SelectByCapPrice(CAP, low, up));
    }
    
}
