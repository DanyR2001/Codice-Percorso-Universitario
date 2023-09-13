package ricambi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static ricambi.RicambioAutoEntity.TROVA_TUTTI;
import static ricambi.RicambioAutoEntity.TROVA_PER_CATEGORIA;
import static ricambi.RicambioAutoEntity.TROVA_PER_ID;
import static ricambi.RicambioAutoEntity.TROVA_RICAMBI_DA_ORDINARE;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT r FROM RicambioAutoEntity r"),
    @NamedQuery(name = TROVA_PER_CATEGORIA, query = "SELECT r FROM RicambioAutoEntity r WHERE r.categoria = :categoria"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT r FROM RicambioAutoEntity r WHERE r.id = ?1"),
    @NamedQuery(name = TROVA_RICAMBI_DA_ORDINARE, query = "SELECT r FROM RicambioAutoEntity r WHERE r.disponibilita < 10")
})
@XmlRootElement
public class RicambioAutoEntity implements Serializable{
    public static final String TROVA_TUTTI = "RicambioAutoEntity.trovaTutti";
    public static final String TROVA_PER_CATEGORIA = "RicambioAutoEntity.trovaPerCategoria";
    public static final String TROVA_PER_ID = "RicambioAutoEntity.trovaPerId";
    public static final String TROVA_RICAMBI_DA_ORDINARE = "RicambioAutoEntity.trovaRicambiDaOrdinare";

    @Id
    private int id;
    private String categoria;
    private String nome;
    private int disponibilita;
    private int pezziVenduti;
    private float prezzo;

    public RicambioAutoEntity() {
    }

    public RicambioAutoEntity(int id, String categoria, String nome, int disponibilita, int pezziVenduti, float prezzo) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.disponibilita = disponibilita;
        this.pezziVenduti = pezziVenduti;
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public int getPezziVenduti() {
        return pezziVenduti;
    }

    public void setPezziVenduti(int pezziVenduti) {
        this.pezziVenduti = pezziVenduti;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    
    @Override
    public String toString() {
        return "RicambioAutoEntity{" + "id=" + id + ", categoria=" + categoria + ", nome=" + nome + ", disponibilita=" + disponibilita + ", pezziVenduti=" + pezziVenduti + ", prezzo=" + prezzo + '}';
    }
}