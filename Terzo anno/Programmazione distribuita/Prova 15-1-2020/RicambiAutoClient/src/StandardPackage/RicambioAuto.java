/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author danielerusso
 */
@Entity
@NamedQueries({
    @NamedQuery(name=RicambioAuto.FINDALL,query="select r from RicambioAuto r "),
    @NamedQuery(name=RicambioAuto.FINDBYID,query="select r from RicambioAuto r where r.id=?1"),
    @NamedQuery(name=RicambioAuto.FINDBYCATEGORY,query="select r from RicambioAuto r where r.Categoria=:categoria")
})

public class RicambioAuto implements Serializable {
    
    private static final List<String> category = Arrays.asList("Motore", "Freni", "Filtri", "Carrozzeria", "Accensione", "Sospensioni", "ImpiantoElettrico");
    public static final String FINDALL="RicambioAuto.findAll";
    public static final String FINDBYID="RicambioAuto.findById";
    public static final String FINDBYCATEGORY="RicambioAuto.findByCategory";
             
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String Nome;
    private String Categoria;
    private double prezzo;
    private int disponibilita;
    private int venduti;
    
    
    /*nome del pezzo, 
    categoria (Motore, Freni, Filtri, Carrozzeria, Accensione, Sospensioni, ImpiantoElettrico), 
    prezzo, 
    disponibilità, 
    pezzi venduti.*/

    public RicambioAuto() {
    }

    public RicambioAuto(Integer id, String Nome, String Categoria, double prezzo, int disponibilita, int venduti) {
        this.id = id;
        this.Nome = Nome;
        this.Categoria = Categoria;
        this.prezzo = prezzo;
        this.disponibilita = disponibilita;
        this.venduti = venduti;
    }
   

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) throws IOException {
        if (!category.contains(Categoria)) {
            throw new IOException();
        } else {
            this.Categoria = Categoria;
        }
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getVenduti() {
        return venduti;
    }

    public void setVenduti(int venduti) {
        this.venduti = venduti;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RicambioAuto)) {
            return false;
        }
        RicambioAuto other = (RicambioAuto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StandardPackage.RicambioAuto[ id=" + id + " ]";
    }
    
}
