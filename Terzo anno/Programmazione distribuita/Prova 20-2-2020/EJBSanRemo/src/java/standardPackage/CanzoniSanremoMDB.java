/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package standardPackage;

import java.util.List;
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
@MessageDriven(mappedName="jms/javaee8/TopicSanremo")
public class CanzoniSanremoMDB implements MessageListener {
    
    @Inject private CanzoniEJB ejb;
    @Inject Event<CanzoneSanremo> evento;
    @Inject Event<String> evento1;
    
    public CanzoniSanremoMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            MessageWrapperepper msg= message.getBody(MessageWrapperepper.class);
            String Nome=msg.getNome();
            String PrimeParole=msg.getPrimeParole();
            
            System.out.println(Nome+" mdb "+PrimeParole);
            
            List<CanzoneSanremo> all=ejb.selectAll();
            CanzoneSanremo cantante = null;
            for (CanzoneSanremo c: all)
                if (c.getNome().equals(Nome))
                    cantante=c;
            
            if (cantante!=null){
                if (cantante.getNome().equals(Nome)&&cantante.getIncipit().equals(PrimeParole))
                    cantante.setCantato(Boolean.TRUE);
                else if (Nome.equals("Morgan e Bugo")&&cantante.getNome().equals(Nome)&&PrimeParole.equals("Le brutte intenzioni, la maleducazione, la tua bruttafigura di ieri sera, la tua ingratitudine, la tua arroganza, fai ciò che vuoi mettendo i piedi in testa")){
                    cantante.setNome("Morgan");
                    evento1.fire(cantante.getNome());
                }
                ejb.aggiornaCanzone(cantante);
                evento.fire(cantante);
            }
        } catch (JMSException ex) {
            Logger.getLogger(CanzoniSanremoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
