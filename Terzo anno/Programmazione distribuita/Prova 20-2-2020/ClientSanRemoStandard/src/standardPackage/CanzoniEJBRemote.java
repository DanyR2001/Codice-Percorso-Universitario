/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package standardPackage;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author danielerusso
 */
@Remote
public interface CanzoniEJBRemote {
    
    public void aggiungiCanzone(CanzoneSanremo song);
    
    public CanzoneSanremo aggiornaCanzone(CanzoneSanremo song);
    
    public void rimuoviCanzone(CanzoneSanremo song);
    
    public CanzoneSanremo findById(int id);
    
    public List<CanzoneSanremo> selectByCategory(String c);
    
    public List<CanzoneSanremo> selectAll();
    
    public List<CanzoneSanremo> selectByVote(int vot);

}
