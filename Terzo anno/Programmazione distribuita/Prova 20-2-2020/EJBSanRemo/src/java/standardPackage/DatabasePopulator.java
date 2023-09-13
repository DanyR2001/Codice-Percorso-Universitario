/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package standardPackage;

import javax.annotation.*;
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
    name="java:app/jdbc/CanozoniSanremoDS",
    password="sanremoDB",
    databaseName="sanremoDB",
    properties={"connectionAttribute=;create=true"})
public class DatabasePopulator {

    @Inject private CanzoniEJB ejb;
    private CanzoneSanremo c1;
    private CanzoneSanremo c2;
    private CanzoneSanremo c3;
    
    
    /*
ID  Nome  Categoria   Incipit Cantato Voti

1   Diodato Pop Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. Ese ti penso tu sei un'anima, false 1000
2   Piero Pelù Rock Spingi forte spingi forte salta fuori da quel buio. Crescerai aprendo porte tutti igiorni stare pronti  false 13
3   Bugoe Morgan Pop    eL buone intenzioni, l'educazione. La tua foto profilo, buongiorno e buonasera. Ela gratitudine, le circostanze. Bevi se vuoi ma fallo responsabilmente false 5000
    */
    @PostConstruct 
    private void popolateDB(){
        c1=new CanzoneSanremo(1,"Diodato","Pop","Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. Ese ti penso tu sei un'anima,",false,1000);
        ejb.aggiungiCanzone(c1);
        c2=new CanzoneSanremo(2,"Piero Pelù","Rock","Spingi forte spingi forte salta fuori da quel buio. Crescerai aprendo porte tutti igiorni stare pronti",false,13);
        ejb.aggiungiCanzone(c2);
        c3=new CanzoneSanremo(3,"Morgan e Bugo", "Pop", "Le buone intenzioni, l'educazione. La tua foto profilo, buongiorno e buonasera. Ela gratitudine, le circostanze. Bevi se vuoi ma fallo responsabilmente",false,5000);
        ejb.aggiungiCanzone(c3);

    }

    @PreDestroy
    private void clear(){
        ejb.rimuoviCanzone(c1);
        ejb.rimuoviCanzone(c2);
        ejb.rimuoviCanzone(c3);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
