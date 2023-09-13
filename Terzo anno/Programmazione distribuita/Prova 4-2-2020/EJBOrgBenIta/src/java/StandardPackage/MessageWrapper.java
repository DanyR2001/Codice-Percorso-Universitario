/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

import java.io.Serializable;

/**
 *
 * @author danielerusso
 */
public class MessageWrapper implements Serializable {
    
    private int id;
    private int numeroDonatori;

    public MessageWrapper(int id, int numeroDonatori) {
        this.id = id;
        this.numeroDonatori = numeroDonatori;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDonatori() {
        return numeroDonatori;
    }

    public void setNumeroDonatori(int numeroDonatori) {
        this.numeroDonatori = numeroDonatori;
    }
    
    
    
}
