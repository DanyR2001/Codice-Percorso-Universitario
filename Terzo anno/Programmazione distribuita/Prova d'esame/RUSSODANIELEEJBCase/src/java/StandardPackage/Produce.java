/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.inject.Produces;
/**
 *
 * @author danielerusso
 */
public class Produce {
    @Produces
    @PersistenceContext(unitName="EsamePU")
    private EntityManager em;
}
