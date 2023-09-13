/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientstandard;

import StandardPackage.EJBorganiBeniRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author danielerusso
 */
public class ClientStandard {

    /**
     * @param args the command line arguments
     */
    private static EJBorganiBeniRemote ejb;
    
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ct= new InitialContext();
        ejb=(EJBorganiBeniRemote) ct.lookup("java:global/EJBOrgBenIta/EJBorganiBeni!StandardPackage.EJBorganiBeniRemote");
        StampaPerBilancio(50000000.00);
        StampaTutte();
    }
    
    private static void StampaPerBilancio(double value){
        System.out.println(ejb.findByBilancio(value));
    }
    
    private static void StampaTutte(){
        System.out.println(ejb.selectAll());
    }
    
}
