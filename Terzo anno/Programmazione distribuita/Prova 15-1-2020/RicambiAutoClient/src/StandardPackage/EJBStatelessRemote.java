/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package StandardPackage;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author danielerusso
 */
@Remote
public interface EJBStatelessRemote {
    
    void addRicambio(RicambioAuto r);
    void removeRicambio(RicambioAuto r);
    RicambioAuto updateRicambio(RicambioAuto r);
    
    List<RicambioAuto> selectAll();
    RicambioAuto selectById(Integer id);
    List<RicambioAuto> selectByCategory(String Category);
}
