/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ricambiautojmsclient;

import javax.jms.*;
import javax.naming.*;
import StandardPackage.MessageWrapper;

/**
 *
 * @author danielerusso
 */
public class RicambiAutoJMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ctx = new InitialContext();
        ConnectionFactory cf =(ConnectionFactory) ctx.lookup("jms/javaee8/ConnectionFactory");
        Destination topic= (Destination) ctx.lookup("jms/javaee8/Topic");
        
        MessageWrapper MsWr=new MessageWrapper(1,10);
        
        try(JMSContext jmsCtx=cf.createContext()){
            jmsCtx.createProducer().send(topic,MsWr);
        }
    }
    
}
