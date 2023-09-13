/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package StandardPackage;

import javax.annotation.*;
import javax.annotation.sql.*;
import javax.ejb.*;
import javax.inject.Inject;

/**
 *
 * @author danielerusso
 */
@Singleton
@Startup
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.EmbeddedDataSource",
    name="java:app/jdbc/RicambioAutoDB",
    user="RADB",
    password="RADB",
    databaseName="RicambioAuto",
    properties = {"connectionAttributes=;create=true"}
)

public class EJBSingleton_DBPopulator {
    @Inject
    private EJBStateless EJB;
    
    private RicambioAuto p1,p2,p3;
    
    @PostConstruct
    private void inizializzazione(){
        p1=new RicambioAuto(1,"Sensore Temperatura","Motore",18.22,100,1000);
        EJB.addRicambio(p1);
        p2=new RicambioAuto(2,"FAP","Filtri",188.47,9,1);
        EJB.addRicambio(p2);
        p3=new RicambioAuto(3,"Dischi Freni","Freni",18.15,2000,5000);
        EJB.addRicambio(p3);
    }
    
    @PreDestroy
    private void spengimento(){
        EJB.removeRicambio(p1);
        EJB.removeRicambio(p2);
        EJB.removeRicambio(p3);
    }
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
