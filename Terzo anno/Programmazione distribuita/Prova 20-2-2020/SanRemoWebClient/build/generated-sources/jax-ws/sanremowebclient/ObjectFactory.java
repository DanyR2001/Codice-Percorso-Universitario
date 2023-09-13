
package sanremowebclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sanremowebclient package. 
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

    private final static QName _AggiornaCanzone_QNAME = new QName("http://standardPackage/", "aggiornaCanzone");
    private final static QName _AggiornaCanzoneResponse_QNAME = new QName("http://standardPackage/", "aggiornaCanzoneResponse");
    private final static QName _AggiungiCanzone_QNAME = new QName("http://standardPackage/", "aggiungiCanzone");
    private final static QName _AggiungiCanzoneResponse_QNAME = new QName("http://standardPackage/", "aggiungiCanzoneResponse");
    private final static QName _FindById_QNAME = new QName("http://standardPackage/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://standardPackage/", "findByIdResponse");
    private final static QName _RimuoviCanzone_QNAME = new QName("http://standardPackage/", "rimuoviCanzone");
    private final static QName _RimuoviCanzoneResponse_QNAME = new QName("http://standardPackage/", "rimuoviCanzoneResponse");
    private final static QName _SelectAll_QNAME = new QName("http://standardPackage/", "selectAll");
    private final static QName _SelectAllResponse_QNAME = new QName("http://standardPackage/", "selectAllResponse");
    private final static QName _SelectByCategory_QNAME = new QName("http://standardPackage/", "selectByCategory");
    private final static QName _SelectByCategoryResponse_QNAME = new QName("http://standardPackage/", "selectByCategoryResponse");
    private final static QName _SelectByVote_QNAME = new QName("http://standardPackage/", "selectByVote");
    private final static QName _SelectByVoteResponse_QNAME = new QName("http://standardPackage/", "selectByVoteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sanremowebclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AggiornaCanzone }
     * 
     */
    public AggiornaCanzone createAggiornaCanzone() {
        return new AggiornaCanzone();
    }

    /**
     * Create an instance of {@link AggiornaCanzoneResponse }
     * 
     */
    public AggiornaCanzoneResponse createAggiornaCanzoneResponse() {
        return new AggiornaCanzoneResponse();
    }

    /**
     * Create an instance of {@link AggiungiCanzone }
     * 
     */
    public AggiungiCanzone createAggiungiCanzone() {
        return new AggiungiCanzone();
    }

    /**
     * Create an instance of {@link AggiungiCanzoneResponse }
     * 
     */
    public AggiungiCanzoneResponse createAggiungiCanzoneResponse() {
        return new AggiungiCanzoneResponse();
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
     * Create an instance of {@link RimuoviCanzone }
     * 
     */
    public RimuoviCanzone createRimuoviCanzone() {
        return new RimuoviCanzone();
    }

    /**
     * Create an instance of {@link RimuoviCanzoneResponse }
     * 
     */
    public RimuoviCanzoneResponse createRimuoviCanzoneResponse() {
        return new RimuoviCanzoneResponse();
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
     * Create an instance of {@link SelectByCategory }
     * 
     */
    public SelectByCategory createSelectByCategory() {
        return new SelectByCategory();
    }

    /**
     * Create an instance of {@link SelectByCategoryResponse }
     * 
     */
    public SelectByCategoryResponse createSelectByCategoryResponse() {
        return new SelectByCategoryResponse();
    }

    /**
     * Create an instance of {@link SelectByVote }
     * 
     */
    public SelectByVote createSelectByVote() {
        return new SelectByVote();
    }

    /**
     * Create an instance of {@link SelectByVoteResponse }
     * 
     */
    public SelectByVoteResponse createSelectByVoteResponse() {
        return new SelectByVoteResponse();
    }

    /**
     * Create an instance of {@link CanzoneSanremo }
     * 
     */
    public CanzoneSanremo createCanzoneSanremo() {
        return new CanzoneSanremo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaCanzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiornaCanzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "aggiornaCanzone")
    public JAXBElement<AggiornaCanzone> createAggiornaCanzone(AggiornaCanzone value) {
        return new JAXBElement<AggiornaCanzone>(_AggiornaCanzone_QNAME, AggiornaCanzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaCanzoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiornaCanzoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "aggiornaCanzoneResponse")
    public JAXBElement<AggiornaCanzoneResponse> createAggiornaCanzoneResponse(AggiornaCanzoneResponse value) {
        return new JAXBElement<AggiornaCanzoneResponse>(_AggiornaCanzoneResponse_QNAME, AggiornaCanzoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiungiCanzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiungiCanzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "aggiungiCanzone")
    public JAXBElement<AggiungiCanzone> createAggiungiCanzone(AggiungiCanzone value) {
        return new JAXBElement<AggiungiCanzone>(_AggiungiCanzone_QNAME, AggiungiCanzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiungiCanzoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiungiCanzoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "aggiungiCanzoneResponse")
    public JAXBElement<AggiungiCanzoneResponse> createAggiungiCanzoneResponse(AggiungiCanzoneResponse value) {
        return new JAXBElement<AggiungiCanzoneResponse>(_AggiungiCanzoneResponse_QNAME, AggiungiCanzoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "findById")
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
    @XmlElementDecl(namespace = "http://standardPackage/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RimuoviCanzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RimuoviCanzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "rimuoviCanzone")
    public JAXBElement<RimuoviCanzone> createRimuoviCanzone(RimuoviCanzone value) {
        return new JAXBElement<RimuoviCanzone>(_RimuoviCanzone_QNAME, RimuoviCanzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RimuoviCanzoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RimuoviCanzoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "rimuoviCanzoneResponse")
    public JAXBElement<RimuoviCanzoneResponse> createRimuoviCanzoneResponse(RimuoviCanzoneResponse value) {
        return new JAXBElement<RimuoviCanzoneResponse>(_RimuoviCanzoneResponse_QNAME, RimuoviCanzoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "selectAll")
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
    @XmlElementDecl(namespace = "http://standardPackage/", name = "selectAllResponse")
    public JAXBElement<SelectAllResponse> createSelectAllResponse(SelectAllResponse value) {
        return new JAXBElement<SelectAllResponse>(_SelectAllResponse_QNAME, SelectAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCategory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCategory }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "selectByCategory")
    public JAXBElement<SelectByCategory> createSelectByCategory(SelectByCategory value) {
        return new JAXBElement<SelectByCategory>(_SelectByCategory_QNAME, SelectByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCategoryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCategoryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "selectByCategoryResponse")
    public JAXBElement<SelectByCategoryResponse> createSelectByCategoryResponse(SelectByCategoryResponse value) {
        return new JAXBElement<SelectByCategoryResponse>(_SelectByCategoryResponse_QNAME, SelectByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByVote }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByVote }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "selectByVote")
    public JAXBElement<SelectByVote> createSelectByVote(SelectByVote value) {
        return new JAXBElement<SelectByVote>(_SelectByVote_QNAME, SelectByVote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByVoteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByVoteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://standardPackage/", name = "selectByVoteResponse")
    public JAXBElement<SelectByVoteResponse> createSelectByVoteResponse(SelectByVoteResponse value) {
        return new JAXBElement<SelectByVoteResponse>(_SelectByVoteResponse_QNAME, SelectByVoteResponse.class, null, value);
    }

}
