/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package StandardPackage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author danielerusso
 */
@MessageDriven(mappedName="jms/javaee8/OrganizzazioneTop")
public class MDBOrganizzazione implements MessageListener {
    
    public MDBOrganizzazione() {
    }
    
    @Inject EJBorganiBeni ejb;
    @Inject Event<OrganizzazioneBenefica> evento;
    
    @Override
    public void onMessage(Message message) {
        try {
            MessageWrapper ms=message.getBody(MessageWrapper.class);
            OrganizzazioneBenefica org=ejb.findById(ms.getId());
            org.setNumDonatori(ms.getNumeroDonatori());
            ejb.aggiornaOranizzazione(org);
            evento.fire(org);
            
        } catch (JMSException ex) {
            Logger.getLogger(MDBOrganizzazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
