/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package StandardPackage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.enterprise.event.Event;


/**
 *
 * @author danielerusso
 */
@MessageDriven(mappedName="jms/javaee8/Topic")
public class MDBCase implements MessageListener {
    
    public MDBCase() {                          //mancanza costruttore vuoto 
    }
    
    @Inject private EJBCase ejb;                //scope private
    @Inject private Event<Casa> evento;         //scope private
    
    @Override
    public void onMessage(Message message) {
        try {
            MessageWrapper mw=message.getBody(MessageWrapper.class);
            Casa c=ejb.SelectById(mw.getId());
            String oldState=c.getStato();
            c.setPrezzo(mw.getPrice());
            c.setStato(mw.getStato());
            c=ejb.update(c);
            System.out.println("Aggiornamento immobile "+c.getTipo()+" in "+c.getIndirizzo());
            if(!c.getStato().equals(oldState))
                evento.fire(c);
        } catch (JMSException ex) {
            System.err.print(ex);
        }
    }
    
}
