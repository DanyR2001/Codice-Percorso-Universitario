/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientsanremostandard;


import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import standardPackage.CanzoneSanremo;
import standardPackage.CanzoniEJBRemote;

/**
 *
 * @author danielerusso
 */
public class ClientSanRemoStandard {

    /**
     * @param args the command line arguments
     */
    private static CanzoniEJBRemote EjbRemote;
    
    private static void printAll(){
        System.out.println(EjbRemote.selectAll());
    }
    
    private static void printByCategory(String c){
        System.out.println(EjbRemote.selectByCategory(c));
    }
    
    private static void printByVotes(int vote){
       List<CanzoneSanremo> lista=EjbRemote.selectByVote(vote);
       if (lista!=null)
           System.out.println(lista);
       else
           System.out.println("print by vote = null");
    }
    
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context c=new InitialContext();
        EjbRemote=(CanzoniEJBRemote) c.lookup("java:global/EJBSanRemo/CanzoniEJB!standardPackage.CanzoniEJBRemote");
        
        printAll();
        
        Scanner x =new Scanner(System.in);
        
        System.out.println("Inserisci la categoria;");
        String cat=x.nextLine();
        printByCategory(cat);
        
        System.out.println("Inserisci il numero di voti minimi;");
        int num=x.nextInt();
        printByVotes(num);
        
        System.out.println("richiamo di nuovo categoria;");

        printByCategory(cat);
        
    }
    
}
