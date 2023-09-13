/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jmsclient;

import StandardPackage.MessageWrapper;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.Destination;


/**
 *
 * @author danielerusso
 */
public class JMSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context c= new InitialContext();
        ConnectionFactory cf=(ConnectionFactory)c.lookup("jms/javaee8/ConnectionFactory");  //mancanza cast esplicito e inserito scope inutile
        Destination d=(Destination) c.lookup("jms/javaee8/Topic");                          //mancanza cast esplicito e inserito scope inutile
        MessageWrapper mw=new MessageWrapper(1,1500f,"Locato");                     //confuso il campo "stato" con "tipo"
        
        try(JMSContext ct=cf.createContext()){
            ct.createProducer().send(d, mw);
        }
        
    }
    
}
