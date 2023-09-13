
package standardpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per organizzazioneBenefica complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="organizzazioneBenefica"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bilancio" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nomeOrganizzazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numDonatori" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numProgetti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numePaesi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="perTrasparenza" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sede" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "organizzazioneBenefica", propOrder = {
    "bilancio",
    "id",
    "nomeOrganizzazione",
    "numDonatori",
    "numProgetti",
    "numePaesi",
    "perTrasparenza",
    "sede"
})
public class OrganizzazioneBenefica {

    protected double bilancio;
    protected int id;
    protected String nomeOrganizzazione;
    protected int numDonatori;
    protected int numProgetti;
    protected int numePaesi;
    protected int perTrasparenza;
    protected String sede;

    /**
     * Recupera il valore della proprietà bilancio.
     * 
     */
    public double getBilancio() {
        return bilancio;
    }

    /**
     * Imposta il valore della proprietà bilancio.
     * 
     */
    public void setBilancio(double value) {
        this.bilancio = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà nomeOrganizzazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeOrganizzazione() {
        return nomeOrganizzazione;
    }

    /**
     * Imposta il valore della proprietà nomeOrganizzazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeOrganizzazione(String value) {
        this.nomeOrganizzazione = value;
    }

    /**
     * Recupera il valore della proprietà numDonatori.
     * 
     */
    public int getNumDonatori() {
        return numDonatori;
    }

    /**
     * Imposta il valore della proprietà numDonatori.
     * 
     */
    public void setNumDonatori(int value) {
        this.numDonatori = value;
    }

    /**
     * Recupera il valore della proprietà numProgetti.
     * 
     */
    public int getNumProgetti() {
        return numProgetti;
    }

    /**
     * Imposta il valore della proprietà numProgetti.
     * 
     */
    public void setNumProgetti(int value) {
        this.numProgetti = value;
    }

    /**
     * Recupera il valore della proprietà numePaesi.
     * 
     */
    public int getNumePaesi() {
        return numePaesi;
    }

    /**
     * Imposta il valore della proprietà numePaesi.
     * 
     */
    public void setNumePaesi(int value) {
        this.numePaesi = value;
    }

    /**
     * Recupera il valore della proprietà perTrasparenza.
     * 
     */
    public int getPerTrasparenza() {
        return perTrasparenza;
    }

    /**
     * Imposta il valore della proprietà perTrasparenza.
     * 
     */
    public void setPerTrasparenza(int value) {
        this.perTrasparenza = value;
    }

    /**
     * Recupera il valore della proprietà sede.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSede() {
        return sede;
    }

    /**
     * Imposta il valore della proprietà sede.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSede(String value) {
        this.sede = value;
    }

}
