/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielerusso
 */
@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name=Casa.SELECT_ALL,query="Select c from Casa c"),
        @NamedQuery(name=Casa.SELECT_BY_CAP,query="Select c from Casa c where c.CAP=?1"),
        @NamedQuery(name=Casa.SELECT_BY_CAP_PRI,query="Select c from Casa c where c.CAP=?1 and c.prezzo>?3 and c.prezzo<?2"),
        @NamedQuery(name=Casa.SELECT_BY_ID,query="Select c from Casa c where c.id=:id"),
        @NamedQuery(name=Casa.SELECT_BY_STAT,query="Select c from Casa c where c.stato=?1"),
        @NamedQuery(name=Casa.SELECT_BY_TYPE,query="Select c from Casa c where c.tipo=?1"),
        @NamedQuery(name=Casa.SELECT_INF_PRC,query="Select c from Casa c where c.prezzo<?1")
})
public class Casa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String tipo,indirizzo,CAP,stato;
    private float prezzo;
    
    public static final String SELECT_BY_ID="Casa.SelectById";
    public static final String SELECT_ALL="Casa.SelectAll";
    public static final String SELECT_BY_CAP="Casa.SelectByCap";
    public static final String SELECT_BY_TYPE="Casa.SelectByType";
    public static final String SELECT_INF_PRC="Casa.SelectInfPrice";
    public static final String SELECT_BY_STAT="Casa.SelectByState";
    public static final String SELECT_BY_CAP_PRI="Casa.SelectCapPrice";

    private static final List<String> STATI=Arrays.asList("Locato","Libero","Non disponibile");
    
    public Casa() {
    }

    public Casa(int id, String tipo, String indirizzo, String CAP, String stato, float prezzo) {
        this.id = id;
        this.tipo = tipo;
        this.indirizzo = indirizzo;
        this.CAP = CAP;
        this.stato = stato;
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        if(STATI.contains(stato))
            this.stato = stato;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casa)) {
            return false;
        }
        Casa other = (Casa) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id:"+id+", Tipologia:"+tipo+", Indirizzo:"+indirizzo+", CAP:"+CAP+", Prezzo:"+prezzo+", tipo:"+tipo;
    }
    
}
