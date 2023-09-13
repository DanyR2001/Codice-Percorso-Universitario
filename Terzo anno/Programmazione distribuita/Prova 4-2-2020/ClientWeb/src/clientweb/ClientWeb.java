/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientweb;

import standardpackage.OrganizzazioneBenefica;

/**
 *
 * @author danielerusso
 */
public class ClientWeb {

    /**
     * @param args the command line arguments
     */
    private static standardpackage.EJBorganiBeniService service=new standardpackage.EJBorganiBeniService();
    private static standardpackage.EJBorganiBeni port=service.getEJBorganiBeniPort();
    
    public static void main(String[] args) {
        // TODO code application logic here
        printByTrasp();
    }
    
    private static void printByTrasp(){
        for(OrganizzazioneBenefica a :port.selectTrasparenzaMax(100))
            System.out.print(a.getId()+" "+a.getNomeOrganizzazione());
    }
}
