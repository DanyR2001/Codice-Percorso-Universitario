/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package standardPackage;

import java.io.Serializable;

/**
 *
 * @author danielerusso
 */
public class MessageWrapperepper implements Serializable{
    
    private String nome;
    private String primeParole;

    public MessageWrapperepper(String nome, String primeParole) {
        this.nome = nome;
        this.primeParole = primeParole;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrimeParole() {
        return primeParole;
    }

    public void setPrimeParole(String primeParole) {
        this.primeParole = primeParole;
    }
    
    
}
