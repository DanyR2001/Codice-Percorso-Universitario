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

/**
 *
 * @author danielerusso
 */
@Stateless
@LocalBean
@WebService
public class EJBCase implements EJBCaseRemote {

    @Inject private EntityManager em; //aggiunta dello scope private
    
    @Override
    public void add(Casa c) {
        em.persist(c);
    }

    @Override
    public void remove(Casa c) {
        em.remove(em.merge(c));
    }

    @Override
    public Casa update(Casa c) {
        return em.merge(c);
    }

    @Override
    public Casa SelectById(int id) {
        return em.createNamedQuery(Casa.SELECT_BY_ID, Casa.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Casa> SelectByCap(String CAP) {
        return em.createNamedQuery(Casa.SELECT_BY_CAP, Casa.class).setParameter(1,CAP).getResultList();
    }

    @Override
    public List<Casa> SelectByType(String t) {
        return em.createNamedQuery(Casa.SELECT_BY_TYPE, Casa.class).setParameter("tipo", t).getResultList();
    }

    @Override
    public List<Casa> SelectByState(String t) {
        return em.createNamedQuery(Casa.SELECT_BY_STAT, Casa.class).setParameter(1,t).getResultList();
    }

    @Override
    public List<Casa> SelectByInfPrice(float f) {
        return em.createNamedQuery(Casa.SELECT_INF_PRC, Casa.class).setParameter(1,f).getResultList();
    }

    @Override
    public List<Casa> SelectByCapPrice(String CAP, float l,float u) {
        return em.createNamedQuery(Casa.SELECT_BY_CAP_PRI, Casa.class).setParameter(1,CAP).setParameter(2, u).setParameter(3,l).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
