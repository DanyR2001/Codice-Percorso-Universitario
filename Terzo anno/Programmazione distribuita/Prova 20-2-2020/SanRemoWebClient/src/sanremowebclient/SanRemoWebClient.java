/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sanremowebclient;

import java.util.Scanner;

/**
 *
 * @author danielerusso
 */
public class SanRemoWebClient {

    /**
     * @param args the command line arguments
     */
    private static sanremowebclient.CanzoniEJBService service=new CanzoniEJBService();
    private static sanremowebclient.CanzoniEJB port=service.getCanzoniEJBPort();
        
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Insersci l'id della conzone che vuoi modificare i voti ");
        Scanner in=new Scanner(System.in);
        int id=in.nextInt();
        System.out.println("Inserisci il numero di voti ");
        int voti =in.nextInt();
        
        CanzoneSanremo song=findById(id);
        song.setVotiRicevuti(voti);
        aggiornaVoti(song);
        
    }
    
    private static CanzoneSanremo findById(int id){
        return port.findById(id);
    }

    private static void aggiornaVoti(CanzoneSanremo song) {
        port.aggiornaCanzone(song);
    }
}
