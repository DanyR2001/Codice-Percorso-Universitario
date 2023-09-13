/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sanremojmsclient;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import standardPackage.MessageWrapperepper;

/**
 *
 * @author danielerusso
 */
public class SanRemoJMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ct=new InitialContext();
        ConnectionFactory fact=(ConnectionFactory) ct.lookup("jms/javaee8/SanremoFactory");
        Destination dst=(Destination) ct.lookup("jms/javaee8/TopicSanremo");
        MessageWrapperepper mw=new MessageWrapperepper("Diodato","Sai che cosa penso, Che non dovrei pensare, Che se poi penso sono un animale. Ese ti penso tu sei un'anima,");
        MessageWrapperepper bugo=new MessageWrapperepper("Morgan e Bugo","Le brutte intenzioni, la maleducazione, la tua bruttafigura di ieri sera, la tua ingratitudine, la tua arroganza, fai ciò che vuoi mettendo i piedi in testa");
        
        try(JMSContext jmsCtx=fact.createContext()){
            jmsCtx.createProducer().send(dst,mw);
            jmsCtx.createProducer().send(dst,bugo);
        }
    }
    
}
