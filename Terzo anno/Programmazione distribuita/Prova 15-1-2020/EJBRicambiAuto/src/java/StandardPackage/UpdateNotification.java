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
    public void notifiy(@Observes RicambioAuto pezzo ){
        System.out.println(pezzo.getId()+" è stato aggiornato, value: "+pezzo);
    }
}
