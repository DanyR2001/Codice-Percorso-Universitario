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
@DataSourceDefinition(className="org.apache.derby.jdbc.EmbeddedDataSource",
    name="java:global/jdbc/EsameDS",     //dimenticanza scope java:global
    user="user1",
    password="password",
    databaseName="EsameDB",             //dimenticanza attributo
    properties={"connectionAttribute=;create=true"})
public class Populator {

    @Inject private EJBCase ejb;        //scope private
    private Casa c1,c2,c3,c4;
    
    
    @PostConstruct private void create(){
        c1=new Casa(1,"Bilocale","Piazza Portanova","84121","Libero",1000f);
        c2=new Casa(2,"Trilocale","Via Posidonia","84129","Libero",800f);
        c3=new Casa(3,"Bilocale","Longomare","84128","Locato",1000f);
        c4=new Casa(4,"Monolocale","VIa fuercio","84143","Locato",600f);
        ejb.add(c1);
        ejb.add(c2);
        ejb.add(c3);
        ejb.add(c4);
    }
    
    @PreDestroy private void destroy(){
        ejb.remove(c1);
        ejb.remove(c2);
        ejb.remove(c3);
        ejb.remove(c4);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
