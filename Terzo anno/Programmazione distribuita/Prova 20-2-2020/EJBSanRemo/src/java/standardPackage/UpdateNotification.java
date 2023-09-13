/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package standardPackage;

import javax.enterprise.event.Observes;

/**
 *
 * @author danielerusso
 */
public class UpdateNotification {
    public void notify(@Observes CanzoneSanremo song){
        System.out.println(song.getNome()+" sta cantando ...");
    }
    
    public void notify(@Observes String x){
        if (x.equals("Morgan"))
            System.out.println("Dove buogo?");
    }
    
}
