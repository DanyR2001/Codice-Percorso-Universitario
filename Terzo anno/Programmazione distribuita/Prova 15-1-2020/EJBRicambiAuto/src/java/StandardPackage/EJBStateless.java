/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package StandardPackage;

import java.util.List;
import javax.ejb.*;
import javax.inject.*;
import javax.jws.WebService;
import javax.persistence.*;

/**
 *
 * @author danielerusso
 */
@Stateless
@LocalBean
@Counter
@WebService
public class EJBStateless implements EJBStatelessRemote {
    
    @Inject
    private EntityManager em;

    @Override
    public void addRicambio(RicambioAuto r) {
        em.persist(r);
    }

    @Override
    public void removeRicambio(RicambioAuto r) {
        em.remove(em.merge(r));
    }

    @Override
    public RicambioAuto updateRicambio(RicambioAuto r) {
        return em.merge(r);
    }

    @Override
    public List<RicambioAuto> selectAll() {
        TypedQuery<RicambioAuto> x=em.createNamedQuery(RicambioAuto.FINDALL, RicambioAuto.class);
        return x.getResultList();
    }

    @Override
    public RicambioAuto selectById(Integer id) {
        TypedQuery<RicambioAuto> x=em.createNamedQuery(RicambioAuto.FINDBYID, RicambioAuto.class);
        return x.setParameter(1, id).getSingleResult();
    }

    @Override
    public List<RicambioAuto> selectByCategory(String Category) {
        TypedQuery<RicambioAuto> x=em.createNamedQuery(RicambioAuto.FINDBYCATEGORY, RicambioAuto.class);
        return x.setParameter("categoria",Category).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
