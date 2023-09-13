/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StandardPackage;

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
    @NamedQuery(name=OrganizzazioneBenefica.SELECT_ALL,query="select o from OrganizzazioneBenefica o"),
    @NamedQuery(name=OrganizzazioneBenefica.SELECT_BY_BALACE,query="select o from OrganizzazioneBenefica o where o.bilancio>?1"),
    @NamedQuery(name=OrganizzazioneBenefica.SELECT_BY_ID,query="select o from OrganizzazioneBenefica o where o.id=:id"),
    @NamedQuery(name=OrganizzazioneBenefica.SELECT_BY_NUMPROG,query="select o from OrganizzazioneBenefica o where o.numProgetti=?1"),
    @NamedQuery(name=OrganizzazioneBenefica.SELECT_BY_TRASP,query="select o from OrganizzazioneBenefica o where o.Trasparenza=?1")
})
public class OrganizzazioneBenefica implements Serializable {

    
    public static final String SELECT_BY_ID ="OragnizazzioneBenefica.findById";
    public static final String SELECT_ALL ="OragnizazzioneBenefica.selectAll";
    public static final String SELECT_BY_NUMPROG ="OragnizazzioneBenefica.findByNumProg";
    public static final String SELECT_BY_BALACE ="OragnizazzioneBenefica.findByBalace";
    public static final String SELECT_BY_TRASP ="OragnizazzioneBenefica.findByTrasp";

    private static final long serialVersionUID = 1L;
    @Id
    private int id;
    private String nomeOrganizzazione;
    private String sede;
    private int numProgetti;
    private int numePaesi;
    private int numDonatori; 
    private double bilancio;
    private int Trasparenza;

    public OrganizzazioneBenefica(int id, String nomeOrganizzazione, String sede, int numProgetti, int numePaesi, int numDonatori, double bilancio, int perTrasparenza) {
        this.id = id;
        this.nomeOrganizzazione = nomeOrganizzazione;
        this.sede = sede;
        this.numProgetti = numProgetti;
        this.numePaesi = numePaesi;
        this.numDonatori = numDonatori;
        this.bilancio = bilancio;
        this.Trasparenza = perTrasparenza;
    }

    public OrganizzazioneBenefica() {
    }

    public String getNomeOrganizzazione() {
        return nomeOrganizzazione;
    }

    public void setNomeOrganizzazione(String nomeOrganizzazione) {
        this.nomeOrganizzazione = nomeOrganizzazione;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getNumProgetti() {
        return numProgetti;
    }

    public void setNumProgetti(int numProgetti) {
        this.numProgetti = numProgetti;
    }

    public int getNumePaesi() {
        return numePaesi;
    }

    public void setNumePaesi(int numePaesi) {
        this.numePaesi = numePaesi;
    }

    public int getNumDonatori() {
        return numDonatori;
    }

    public void setNumDonatori(int numDonatori) {
        this.numDonatori = numDonatori;
    }

    public double getBilancio() {
        return bilancio;
    }

    public void setBilancio(double bilancio) {
        this.bilancio = bilancio;
    }

    public int getPerTrasparenza() {
        return Trasparenza;
    }

    public void setPerTrasparenza(int perTrasparenza) {
        this.Trasparenza = perTrasparenza;
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
        if (!(object instanceof OrganizzazioneBenefica)) {
            return false;
        }
        OrganizzazioneBenefica other = (OrganizzazioneBenefica) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StandardPackage.OragnizazzioneBenefica[ id=" + id + " ]";
    }
    
}
