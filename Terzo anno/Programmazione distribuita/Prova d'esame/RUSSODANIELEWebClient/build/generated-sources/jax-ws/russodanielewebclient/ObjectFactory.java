
package russodanielewebclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the russodanielewebclient package. 
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

    private final static QName _SelectByCap_QNAME = new QName("http://StandardPackage/", "SelectByCap");
    private final static QName _SelectByCapPrice_QNAME = new QName("http://StandardPackage/", "SelectByCapPrice");
    private final static QName _SelectByCapPriceResponse_QNAME = new QName("http://StandardPackage/", "SelectByCapPriceResponse");
    private final static QName _SelectByCapResponse_QNAME = new QName("http://StandardPackage/", "SelectByCapResponse");
    private final static QName _SelectById_QNAME = new QName("http://StandardPackage/", "SelectById");
    private final static QName _SelectByIdResponse_QNAME = new QName("http://StandardPackage/", "SelectByIdResponse");
    private final static QName _SelectByInfPrice_QNAME = new QName("http://StandardPackage/", "SelectByInfPrice");
    private final static QName _SelectByInfPriceResponse_QNAME = new QName("http://StandardPackage/", "SelectByInfPriceResponse");
    private final static QName _SelectByState_QNAME = new QName("http://StandardPackage/", "SelectByState");
    private final static QName _SelectByStateResponse_QNAME = new QName("http://StandardPackage/", "SelectByStateResponse");
    private final static QName _SelectByType_QNAME = new QName("http://StandardPackage/", "SelectByType");
    private final static QName _SelectByTypeResponse_QNAME = new QName("http://StandardPackage/", "SelectByTypeResponse");
    private final static QName _Add_QNAME = new QName("http://StandardPackage/", "add");
    private final static QName _AddResponse_QNAME = new QName("http://StandardPackage/", "addResponse");
    private final static QName _Casa_QNAME = new QName("http://StandardPackage/", "casa");
    private final static QName _Remove_QNAME = new QName("http://StandardPackage/", "remove");
    private final static QName _RemoveResponse_QNAME = new QName("http://StandardPackage/", "removeResponse");
    private final static QName _Update_QNAME = new QName("http://StandardPackage/", "update");
    private final static QName _UpdateResponse_QNAME = new QName("http://StandardPackage/", "updateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: russodanielewebclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SelectByCap }
     * 
     */
    public SelectByCap createSelectByCap() {
        return new SelectByCap();
    }

    /**
     * Create an instance of {@link SelectByCapPrice }
     * 
     */
    public SelectByCapPrice createSelectByCapPrice() {
        return new SelectByCapPrice();
    }

    /**
     * Create an instance of {@link SelectByCapPriceResponse }
     * 
     */
    public SelectByCapPriceResponse createSelectByCapPriceResponse() {
        return new SelectByCapPriceResponse();
    }

    /**
     * Create an instance of {@link SelectByCapResponse }
     * 
     */
    public SelectByCapResponse createSelectByCapResponse() {
        return new SelectByCapResponse();
    }

    /**
     * Create an instance of {@link SelectById }
     * 
     */
    public SelectById createSelectById() {
        return new SelectById();
    }

    /**
     * Create an instance of {@link SelectByIdResponse }
     * 
     */
    public SelectByIdResponse createSelectByIdResponse() {
        return new SelectByIdResponse();
    }

    /**
     * Create an instance of {@link SelectByInfPrice }
     * 
     */
    public SelectByInfPrice createSelectByInfPrice() {
        return new SelectByInfPrice();
    }

    /**
     * Create an instance of {@link SelectByInfPriceResponse }
     * 
     */
    public SelectByInfPriceResponse createSelectByInfPriceResponse() {
        return new SelectByInfPriceResponse();
    }

    /**
     * Create an instance of {@link SelectByState }
     * 
     */
    public SelectByState createSelectByState() {
        return new SelectByState();
    }

    /**
     * Create an instance of {@link SelectByStateResponse }
     * 
     */
    public SelectByStateResponse createSelectByStateResponse() {
        return new SelectByStateResponse();
    }

    /**
     * Create an instance of {@link SelectByType }
     * 
     */
    public SelectByType createSelectByType() {
        return new SelectByType();
    }

    /**
     * Create an instance of {@link SelectByTypeResponse }
     * 
     */
    public SelectByTypeResponse createSelectByTypeResponse() {
        return new SelectByTypeResponse();
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link Casa }
     * 
     */
    public Casa createCasa() {
        return new Casa();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCap }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCap }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByCap")
    public JAXBElement<SelectByCap> createSelectByCap(SelectByCap value) {
        return new JAXBElement<SelectByCap>(_SelectByCap_QNAME, SelectByCap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCapPrice }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCapPrice }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByCapPrice")
    public JAXBElement<SelectByCapPrice> createSelectByCapPrice(SelectByCapPrice value) {
        return new JAXBElement<SelectByCapPrice>(_SelectByCapPrice_QNAME, SelectByCapPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCapPriceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCapPriceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByCapPriceResponse")
    public JAXBElement<SelectByCapPriceResponse> createSelectByCapPriceResponse(SelectByCapPriceResponse value) {
        return new JAXBElement<SelectByCapPriceResponse>(_SelectByCapPriceResponse_QNAME, SelectByCapPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCapResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCapResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByCapResponse")
    public JAXBElement<SelectByCapResponse> createSelectByCapResponse(SelectByCapResponse value) {
        return new JAXBElement<SelectByCapResponse>(_SelectByCapResponse_QNAME, SelectByCapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectById }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectById")
    public JAXBElement<SelectById> createSelectById(SelectById value) {
        return new JAXBElement<SelectById>(_SelectById_QNAME, SelectById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByIdResponse")
    public JAXBElement<SelectByIdResponse> createSelectByIdResponse(SelectByIdResponse value) {
        return new JAXBElement<SelectByIdResponse>(_SelectByIdResponse_QNAME, SelectByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByInfPrice }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByInfPrice }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByInfPrice")
    public JAXBElement<SelectByInfPrice> createSelectByInfPrice(SelectByInfPrice value) {
        return new JAXBElement<SelectByInfPrice>(_SelectByInfPrice_QNAME, SelectByInfPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByInfPriceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByInfPriceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByInfPriceResponse")
    public JAXBElement<SelectByInfPriceResponse> createSelectByInfPriceResponse(SelectByInfPriceResponse value) {
        return new JAXBElement<SelectByInfPriceResponse>(_SelectByInfPriceResponse_QNAME, SelectByInfPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByState }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByState }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByState")
    public JAXBElement<SelectByState> createSelectByState(SelectByState value) {
        return new JAXBElement<SelectByState>(_SelectByState_QNAME, SelectByState.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByStateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByStateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByStateResponse")
    public JAXBElement<SelectByStateResponse> createSelectByStateResponse(SelectByStateResponse value) {
        return new JAXBElement<SelectByStateResponse>(_SelectByStateResponse_QNAME, SelectByStateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByType }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByType")
    public JAXBElement<SelectByType> createSelectByType(SelectByType value) {
        return new JAXBElement<SelectByType>(_SelectByType_QNAME, SelectByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByTypeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByTypeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "SelectByTypeResponse")
    public JAXBElement<SelectByTypeResponse> createSelectByTypeResponse(SelectByTypeResponse value) {
        return new JAXBElement<SelectByTypeResponse>(_SelectByTypeResponse_QNAME, SelectByTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Add }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Casa }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Casa }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "casa")
    public JAXBElement<Casa> createCasa(Casa value) {
        return new JAXBElement<Casa>(_Casa_QNAME, Casa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Update }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

}
