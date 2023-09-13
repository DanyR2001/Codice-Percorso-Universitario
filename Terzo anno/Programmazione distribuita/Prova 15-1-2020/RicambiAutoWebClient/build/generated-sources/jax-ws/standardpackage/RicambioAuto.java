
package standardpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ricambioAuto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ricambioAuto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="disponibilita" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prezzo" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="venduti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ricambioAuto", propOrder = {
    "categoria",
    "disponibilita",
    "id",
    "nome",
    "prezzo",
    "venduti"
})
public class RicambioAuto {

    protected String categoria;
    protected int disponibilita;
    protected Integer id;
    protected String nome;
    protected double prezzo;
    protected int venduti;

    /**
     * Recupera il valore della proprietà categoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Imposta il valore della proprietà categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoria(String value) {
        this.categoria = value;
    }

    /**
     * Recupera il valore della proprietà disponibilita.
     * 
     */
    public int getDisponibilita() {
        return disponibilita;
    }

    /**
     * Imposta il valore della proprietà disponibilita.
     * 
     */
    public void setDisponibilita(int value) {
        this.disponibilita = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il valore della proprietà nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Recupera il valore della proprietà prezzo.
     * 
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il valore della proprietà prezzo.
     * 
     */
    public void setPrezzo(double value) {
        this.prezzo = value;
    }

    /**
     * Recupera il valore della proprietà venduti.
     * 
     */
    public int getVenduti() {
        return venduti;
    }

    /**
     * Imposta il valore della proprietà venduti.
     * 
     */
    public void setVenduti(int value) {
        this.venduti = value;
    }

}
