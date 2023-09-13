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
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author danielerusso
 */
@MessageDriven(mappedName="jms/javaee8/Topic")
public class RicambiAutoMDB implements MessageListener {

    @Inject private EJBStateless ejb;
    @Inject Event<RicambioAuto> evento;
    
    @Override
    public void onMessage(Message message) {
        try{
            MessageWrapper MessContent= message.getBody(MessageWrapper.class);
            
            Integer id=MessContent.getId();
            Integer pezziVend=MessContent.getVendite();
            
            RicambioAuto a=ejb.selectById(id);
            a.setVenduti(a.getVenduti()+pezziVend);
            a=ejb.updateRicambio(a);
            
            evento.fire(a);
        }catch (JMSException e){
            Logger.getLogger(RicambiAutoMDB.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
}
