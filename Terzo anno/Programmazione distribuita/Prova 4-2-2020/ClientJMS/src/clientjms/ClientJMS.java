/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientjms;

import StandardPackage.MessageWrapper;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author danielerusso
 */
public class ClientJMS {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ct=new InitialContext();
        ConnectionFactory cf=(ConnectionFactory) ct.lookup("jms/javaee8/ConnectionFactory");
        Destination ds=(Destination) ct.lookup("jms/javaee8/OrganizzazioneTop");
        MessageWrapper ms=new MessageWrapper(1, 1000000000);
        try(JMSContext jms= cf.createContext()){
            jms.createProducer().send(ds, ms);
        }
    }
    
}
