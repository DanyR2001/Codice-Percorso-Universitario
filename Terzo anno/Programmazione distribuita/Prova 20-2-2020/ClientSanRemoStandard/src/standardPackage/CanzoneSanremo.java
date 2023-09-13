/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package standardPackage;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author danielerusso
 */
@Entity
@NamedQueries({
    @NamedQuery(name=CanzoneSanremo.SELECTALL,query="select c from CanzoneSanremo c "),
    @NamedQuery(name=CanzoneSanremo.SELECTBYCATEGORY,query="select c from CanzoneSanremo c where c.categoria=:categoria"),
    @NamedQuery(name=CanzoneSanremo.SELECTBYID,query="select c from CanzoneSanremo c where c.id=?1 ")
})
public class CanzoneSanremo implements Serializable {
    
    public static final String SELECTALL="CanzoneSanremo.findAll";
    public static final String SELECTBYCATEGORY="CanzoneSanremo.findByCategory";
    public static final String SELECTBYID="CanzoneSanremo.findById";


    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String nome;
    private String categoria;
    private String incipit;
    private Boolean cantato;
    private int votiRicevuti;

    public CanzoneSanremo() {
    }

    public CanzoneSanremo(int id, String nome, String categoria, String incipit, Boolean cantato, int votiRicevuti) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.incipit = incipit;
        this.cantato = cantato;
        this.votiRicevuti = votiRicevuti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIncipit() {
        return incipit;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }

    public Boolean getCantato() {
        return cantato;
    }

    public void setCantato(Boolean cantato) {
        this.cantato = cantato;
    }

    public int getVotiRicevuti() {
        return votiRicevuti;
    }

    public void setVotiRicevuti(int votiRicevuti) {
        this.votiRicevuti = votiRicevuti;
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
        if (!(object instanceof CanzoneSanremo)) {
            return false;
        }
        CanzoneSanremo other = (CanzoneSanremo) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "standardPackage.CanzoneSanremo[ id=" + id + " ]: value:[ nome = "+nome+", categoria = "+categoria+", incipit = "+incipit+", cantato = "+cantato+", voti = "+votiRicevuti+" ] \n";
    }
    
}
