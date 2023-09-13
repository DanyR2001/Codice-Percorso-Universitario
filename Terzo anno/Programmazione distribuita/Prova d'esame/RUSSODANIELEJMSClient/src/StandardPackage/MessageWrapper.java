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
    private float price;
    private String stato;

    public MessageWrapper(int id, float price, String stato) {
        this.id = id;
        this.price = price;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    
    
}
