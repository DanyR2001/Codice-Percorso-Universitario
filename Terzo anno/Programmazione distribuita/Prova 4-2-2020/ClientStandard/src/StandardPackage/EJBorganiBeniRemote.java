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
public interface EJBorganiBeniRemote {
    
    public void aggiungiOranizzazione(OrganizzazioneBenefica a);
    public void rimuoviOranizzazione(OrganizzazioneBenefica a);
    public OrganizzazioneBenefica aggiornaOranizzazione(OrganizzazioneBenefica a);
    
    public OrganizzazioneBenefica findById(int id);
    public List<OrganizzazioneBenefica> findByNumProg(int value);
    public List<OrganizzazioneBenefica> findByBilancio(double value);
    public List<OrganizzazioneBenefica> selectAll();
    public List<OrganizzazioneBenefica> selectTrasparenzaMax(int val);


    

    
}
