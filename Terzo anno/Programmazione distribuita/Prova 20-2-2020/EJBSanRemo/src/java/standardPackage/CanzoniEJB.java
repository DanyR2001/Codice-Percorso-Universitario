/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package standardPackage;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author danielerusso
 */
@WebService
@LocalBean
@Stateless
public class CanzoniEJB implements CanzoniEJBRemote {
    
    @Inject private EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void aggiungiCanzone(CanzoneSanremo song) {
        em.persist(song);
    }

    @Override
    public CanzoneSanremo aggiornaCanzone(CanzoneSanremo song) {
        return em.merge(song);
    }

    @Override
    public void rimuoviCanzone(CanzoneSanremo song) {
        em.remove(em.merge(song));
    }

    @Override
    @Counter
    public CanzoneSanremo findById(int id) {
        TypedQuery<CanzoneSanremo> q=em.createNamedQuery(CanzoneSanremo.SELECTBYID, CanzoneSanremo.class).setParameter(1, id);
        return q.getSingleResult();
    }

    @Override
    @Counter
    public List<CanzoneSanremo> selectByCategory(String c) {
        TypedQuery<CanzoneSanremo> q=em.createNamedQuery(CanzoneSanremo.SELECTBYCATEGORY, CanzoneSanremo.class).setParameter("categoria", c);
        return q.getResultList();
    }

    @Override
    @Counter
    public List<CanzoneSanremo> selectAll() {
        TypedQuery<CanzoneSanremo> q=em.createNamedQuery(CanzoneSanremo.SELECTALL, CanzoneSanremo.class);
        return q.getResultList();
    }

    @Override
    @Counter
    public List<CanzoneSanremo> selectByVote(int vot) {
        TypedQuery<CanzoneSanremo> q=em.createNamedQuery(CanzoneSanremo.SELECTALL, CanzoneSanremo.class);
        List<CanzoneSanremo> res= q.getResultList();
        List<CanzoneSanremo> result=new ArrayList();
        for (CanzoneSanremo a: res)
            if(a.getVotiRicevuti()>vot)
                result.add(a);
        return result;
    }
}
