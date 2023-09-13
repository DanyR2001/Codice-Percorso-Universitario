/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package StandardPackage;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author danielerusso
 */
@Singleton
@Startup
@DataSourceDefinition(
        className="org.apache.derby.jdbc.EmbeddedDataSource",
        name="java:app/jdbc/OrganiBeneficaDS",
        user="utente",
        password="utente",
        databaseName="OrganiBeneficaDS",
        properties={"connectionAttributes=;create=true"}
        )
public class DatabasePopulator {
    
    @Inject private EJBorganiBeni ejb;
    private OrganizzazioneBenefica o1;
    private OrganizzazioneBenefica o2;
    private OrganizzazioneBenefica o3;
    private OrganizzazioneBenefica o4;
    
    
    
    @PostConstruct
    private void crea(){
        o1 = new OrganizzazioneBenefica(1, "Save the Children Italia", "Roma", 291, 53, 408830, 113169865.00, 50);
        o2 = new OrganizzazioneBenefica(2, "Medici senza Frontiere", "Roma", 50, 48, 286004, 61403682.00, 50);
        o3 = new OrganizzazioneBenefica(3, "ActionAid", "Milano", 220, 33, 131920, 68097472.00, 100);
        o4 = new OrganizzazioneBenefica(4, "Emergency", "Milano", 50, 7, 66311, 41842957.00, 100);
        ejb.aggiungiOranizzazione(o1);
        ejb.aggiungiOranizzazione(o2);
        ejb.aggiungiOranizzazione(o3);
        ejb.aggiungiOranizzazione(o4);

    }

    @PreDestroy
    private void distruggi(){
        ejb.rimuoviOranizzazione(o1);
        ejb.rimuoviOranizzazione(o2);
        ejb.rimuoviOranizzazione(o3);
        ejb.rimuoviOranizzazione(o4);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
