/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package StandardPackage;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author danielerusso
 */
@Stateless
@LocalBean
@WebService
public class EJBorganiBeni implements EJBorganiBeniRemote {
    
    @Inject private EntityManager em;

    @Override
    public void aggiungiOranizzazione(OrganizzazioneBenefica a) {
        em.persist(a);
    }

    @Override
    public void rimuoviOranizzazione(OrganizzazioneBenefica a) {
        em.remove(em.merge(a));
    }

    @Override
    public OrganizzazioneBenefica aggiornaOranizzazione(OrganizzazioneBenefica a) {
        return em.merge(a);
    }

    @Override
    public OrganizzazioneBenefica findById(int id) {
        //TypedQuery<OrganizazzioneBenefica> res=em.createNamedQuery(OrganizazzioneBenefica.SELECT_BY_ID,OrganizazzioneBenefica.class);
        //return res.setParameter("id", id).getSingleResult();
        return em.createNamedQuery(OrganizzazioneBenefica.SELECT_BY_ID,OrganizzazioneBenefica.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<OrganizzazioneBenefica> findByNumProg(int value) {
        return em.createNamedQuery(OrganizzazioneBenefica.SELECT_BY_NUMPROG,OrganizzazioneBenefica.class).setParameter(1, value).getResultList();
    }

    @Override
    public List<OrganizzazioneBenefica> selectAll() {
        return em.createNamedQuery(OrganizzazioneBenefica.SELECT_ALL,OrganizzazioneBenefica.class).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    @Counter
    public List<OrganizzazioneBenefica> findByBilancio(double value) {
        return em.createNamedQuery(OrganizzazioneBenefica.SELECT_BY_BALACE,OrganizzazioneBenefica.class).setParameter(1, value).getResultList();
    }

    @Override
    public List<OrganizzazioneBenefica> selectTrasparenzaMax(int val) {
        return em.createNamedQuery(OrganizzazioneBenefica.SELECT_BY_TRASP, OrganizzazioneBenefica.class).setParameter(1, val).getResultList();
    }
}
