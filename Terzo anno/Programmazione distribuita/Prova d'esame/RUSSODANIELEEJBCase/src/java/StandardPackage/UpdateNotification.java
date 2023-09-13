/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

import javax.enterprise.event.Observes;

/**
 *
 * @author danielerusso
 */
public class UpdateNotification {
    
    public void print(@Observes Casa c){
        System.out.println("Aggiornamento "+c.getTipo()+" in "+c.getIndirizzo()+" ha cambiato stato in "+c.getStato());
    }
}
