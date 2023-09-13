
package standardpackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the standardpackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AggiornaOranizzazione_QNAME = new QName("http://StandardPackage/", "aggiornaOranizzazione");
    private final static QName _AggiornaOranizzazioneResponse_QNAME = new QName("http://StandardPackage/", "aggiornaOranizzazioneResponse");
    private final static QName _AggiungiOranizzazione_QNAME = new QName("http://StandardPackage/", "aggiungiOranizzazione");
    private final static QName _AggiungiOranizzazioneResponse_QNAME = new QName("http://StandardPackage/", "aggiungiOranizzazioneResponse");
    private final static QName _FindByBilancio_QNAME = new QName("http://StandardPackage/", "findByBilancio");
    private final static QName _FindByBilancioResponse_QNAME = new QName("http://StandardPackage/", "findByBilancioResponse");
    private final static QName _FindById_QNAME = new QName("http://StandardPackage/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://StandardPackage/", "findByIdResponse");
    private final static QName _FindByNumProg_QNAME = new QName("http://StandardPackage/", "findByNumProg");
    private final static QName _FindByNumProgResponse_QNAME = new QName("http://StandardPackage/", "findByNumProgResponse");
    private final static QName _RimuoviOranizzazione_QNAME = new QName("http://StandardPackage/", "rimuoviOranizzazione");
    private final static QName _RimuoviOranizzazioneResponse_QNAME = new QName("http://StandardPackage/", "rimuoviOranizzazioneResponse");
    private final static QName _SelectAll_QNAME = new QName("http://StandardPackage/", "selectAll");
    private final static QName _SelectAllResponse_QNAME = new QName("http://StandardPackage/", "selectAllResponse");
    private final static QName _SelectTrasparenzaMax_QNAME = new QName("http://StandardPackage/", "selectTrasparenzaMax");
    private final static QName _SelectTrasparenzaMaxResponse_QNAME = new QName("http://StandardPackage/", "selectTrasparenzaMaxResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: standardpackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AggiornaOranizzazione }
     * 
     */
    public AggiornaOranizzazione createAggiornaOranizzazione() {
        return new AggiornaOranizzazione();
    }

    /**
     * Create an instance of {@link AggiornaOranizzazioneResponse }
     * 
     */
    public AggiornaOranizzazioneResponse createAggiornaOranizzazioneResponse() {
        return new AggiornaOranizzazioneResponse();
    }

    /**
     * Create an instance of {@link AggiungiOranizzazione }
     * 
     */
    public AggiungiOranizzazione createAggiungiOranizzazione() {
        return new AggiungiOranizzazione();
    }

    /**
     * Create an instance of {@link AggiungiOranizzazioneResponse }
     * 
     */
    public AggiungiOranizzazioneResponse createAggiungiOranizzazioneResponse() {
        return new AggiungiOranizzazioneResponse();
    }

    /**
     * Create an instance of {@link FindByBilancio }
     * 
     */
    public FindByBilancio createFindByBilancio() {
        return new FindByBilancio();
    }

    /**
     * Create an instance of {@link FindByBilancioResponse }
     * 
     */
    public FindByBilancioResponse createFindByBilancioResponse() {
        return new FindByBilancioResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindByNumProg }
     * 
     */
    public FindByNumProg createFindByNumProg() {
        return new FindByNumProg();
    }

    /**
     * Create an instance of {@link FindByNumProgResponse }
     * 
     */
    public FindByNumProgResponse createFindByNumProgResponse() {
        return new FindByNumProgResponse();
    }

    /**
     * Create an instance of {@link RimuoviOranizzazione }
     * 
     */
    public RimuoviOranizzazione createRimuoviOranizzazione() {
        return new RimuoviOranizzazione();
    }

    /**
     * Create an instance of {@link RimuoviOranizzazioneResponse }
     * 
     */
    public RimuoviOranizzazioneResponse createRimuoviOranizzazioneResponse() {
        return new RimuoviOranizzazioneResponse();
    }

    /**
     * Create an instance of {@link SelectAll }
     * 
     */
    public SelectAll createSelectAll() {
        return new SelectAll();
    }

    /**
     * Create an instance of {@link SelectAllResponse }
     * 
     */
    public SelectAllResponse createSelectAllResponse() {
        return new SelectAllResponse();
    }

    /**
     * Create an instance of {@link SelectTrasparenzaMax }
     * 
     */
    public SelectTrasparenzaMax createSelectTrasparenzaMax() {
        return new SelectTrasparenzaMax();
    }

    /**
     * Create an instance of {@link SelectTrasparenzaMaxResponse }
     * 
     */
    public SelectTrasparenzaMaxResponse createSelectTrasparenzaMaxResponse() {
        return new SelectTrasparenzaMaxResponse();
    }

    /**
     * Create an instance of {@link OrganizzazioneBenefica }
     * 
     */
    public OrganizzazioneBenefica createOrganizzazioneBenefica() {
        return new OrganizzazioneBenefica();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaOranizzazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiornaOranizzazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "aggiornaOranizzazione")
    public JAXBElement<AggiornaOranizzazione> createAggiornaOranizzazione(AggiornaOranizzazione value) {
        return new JAXBElement<AggiornaOranizzazione>(_AggiornaOranizzazione_QNAME, AggiornaOranizzazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaOranizzazioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiornaOranizzazioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "aggiornaOranizzazioneResponse")
    public JAXBElement<AggiornaOranizzazioneResponse> createAggiornaOranizzazioneResponse(AggiornaOranizzazioneResponse value) {
        return new JAXBElement<AggiornaOranizzazioneResponse>(_AggiornaOranizzazioneResponse_QNAME, AggiornaOranizzazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiungiOranizzazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiungiOranizzazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "aggiungiOranizzazione")
    public JAXBElement<AggiungiOranizzazione> createAggiungiOranizzazione(AggiungiOranizzazione value) {
        return new JAXBElement<AggiungiOranizzazione>(_AggiungiOranizzazione_QNAME, AggiungiOranizzazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiungiOranizzazioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiungiOranizzazioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "aggiungiOranizzazioneResponse")
    public JAXBElement<AggiungiOranizzazioneResponse> createAggiungiOranizzazioneResponse(AggiungiOranizzazioneResponse value) {
        return new JAXBElement<AggiungiOranizzazioneResponse>(_AggiungiOranizzazioneResponse_QNAME, AggiungiOranizzazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByBilancio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByBilancio }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "findByBilancio")
    public JAXBElement<FindByBilancio> createFindByBilancio(FindByBilancio value) {
        return new JAXBElement<FindByBilancio>(_FindByBilancio_QNAME, FindByBilancio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByBilancioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByBilancioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "findByBilancioResponse")
    public JAXBElement<FindByBilancioResponse> createFindByBilancioResponse(FindByBilancioResponse value) {
        return new JAXBElement<FindByBilancioResponse>(_FindByBilancioResponse_QNAME, FindByBilancioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNumProg }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByNumProg }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "findByNumProg")
    public JAXBElement<FindByNumProg> createFindByNumProg(FindByNumProg value) {
        return new JAXBElement<FindByNumProg>(_FindByNumProg_QNAME, FindByNumProg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNumProgResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByNumProgResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "findByNumProgResponse")
    public JAXBElement<FindByNumProgResponse> createFindByNumProgResponse(FindByNumProgResponse value) {
        return new JAXBElement<FindByNumProgResponse>(_FindByNumProgResponse_QNAME, FindByNumProgResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RimuoviOranizzazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RimuoviOranizzazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "rimuoviOranizzazione")
    public JAXBElement<RimuoviOranizzazione> createRimuoviOranizzazione(RimuoviOranizzazione value) {
        return new JAXBElement<RimuoviOranizzazione>(_RimuoviOranizzazione_QNAME, RimuoviOranizzazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RimuoviOranizzazioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RimuoviOranizzazioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "rimuoviOranizzazioneResponse")
    public JAXBElement<RimuoviOranizzazioneResponse> createRimuoviOranizzazioneResponse(RimuoviOranizzazioneResponse value) {
        return new JAXBElement<RimuoviOranizzazioneResponse>(_RimuoviOranizzazioneResponse_QNAME, RimuoviOranizzazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectAll")
    public JAXBElement<SelectAll> createSelectAll(SelectAll value) {
        return new JAXBElement<SelectAll>(_SelectAll_QNAME, SelectAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectAllResponse")
    public JAXBElement<SelectAllResponse> createSelectAllResponse(SelectAllResponse value) {
        return new JAXBElement<SelectAllResponse>(_SelectAllResponse_QNAME, SelectAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectTrasparenzaMax }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectTrasparenzaMax }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectTrasparenzaMax")
    public JAXBElement<SelectTrasparenzaMax> createSelectTrasparenzaMax(SelectTrasparenzaMax value) {
        return new JAXBElement<SelectTrasparenzaMax>(_SelectTrasparenzaMax_QNAME, SelectTrasparenzaMax.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectTrasparenzaMaxResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectTrasparenzaMaxResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectTrasparenzaMaxResponse")
    public JAXBElement<SelectTrasparenzaMaxResponse> createSelectTrasparenzaMaxResponse(SelectTrasparenzaMaxResponse value) {
        return new JAXBElement<SelectTrasparenzaMaxResponse>(_SelectTrasparenzaMaxResponse_QNAME, SelectTrasparenzaMaxResponse.class, null, value);
    }

}
