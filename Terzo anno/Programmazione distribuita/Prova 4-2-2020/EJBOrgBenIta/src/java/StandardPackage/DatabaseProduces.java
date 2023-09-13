package StandardPackage;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danielerusso
 */

public class DatabaseProduces {
    @Produces
    @PersistenceContext(unitName="EJBOrgBenItaPU")
    private EntityManager em;
    
}
