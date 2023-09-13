/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package russodanielewebclient;

/**
 *
 * @author danielerusso
 */
public class WebClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EJBCaseService service=new EJBCaseService();
        EJBCase port = service.getEJBCasePort();
        for(Casa c: port.selectByState("Libero")){
            System.out.println("id:"+c.getId()+", Tipologia:"+c.getTipo()+", Indirizzo:"+c.getIndirizzo()+", CAP:"+c.getCAP()+", Prezzo:"+c.getPrezzo()+", tipo:"+c.getStato());

        }
    }
    
}
