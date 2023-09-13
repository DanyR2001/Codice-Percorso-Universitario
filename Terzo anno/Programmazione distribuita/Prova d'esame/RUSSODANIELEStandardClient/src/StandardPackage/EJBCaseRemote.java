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
public interface EJBCaseRemote {
     
    void add(Casa c);
    void remove (Casa c);
    Casa update(Casa c);
    Casa SelectById(int id);
    List<Casa> SelectByCap (String CAP);
    List<Casa> SelectByType(String t);
    List<Casa> SelectByState(String t);
    List<Casa> SelectByInfPrice(float f);
    List<Casa> SelectByCapPrice(String CAP,float u,float l);
    
}
