
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

    private final static QName _AddRicambio_QNAME = new QName("http://StandardPackage/", "addRicambio");
    private final static QName _AddRicambioResponse_QNAME = new QName("http://StandardPackage/", "addRicambioResponse");
    private final static QName _RemoveRicambio_QNAME = new QName("http://StandardPackage/", "removeRicambio");
    private final static QName _RemoveRicambioResponse_QNAME = new QName("http://StandardPackage/", "removeRicambioResponse");
    private final static QName _SelectAll_QNAME = new QName("http://StandardPackage/", "selectAll");
    private final static QName _SelectAllResponse_QNAME = new QName("http://StandardPackage/", "selectAllResponse");
    private final static QName _SelectByCategory_QNAME = new QName("http://StandardPackage/", "selectByCategory");
    private final static QName _SelectByCategoryResponse_QNAME = new QName("http://StandardPackage/", "selectByCategoryResponse");
    private final static QName _SelectById_QNAME = new QName("http://StandardPackage/", "selectById");
    private final static QName _SelectByIdResponse_QNAME = new QName("http://StandardPackage/", "selectByIdResponse");
    private final static QName _UpdateRicambio_QNAME = new QName("http://StandardPackage/", "updateRicambio");
    private final static QName _UpdateRicambioResponse_QNAME = new QName("http://StandardPackage/", "updateRicambioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: standardpackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddRicambio }
     * 
     */
    public AddRicambio createAddRicambio() {
        return new AddRicambio();
    }

    /**
     * Create an instance of {@link AddRicambioResponse }
     * 
     */
    public AddRicambioResponse createAddRicambioResponse() {
        return new AddRicambioResponse();
    }

    /**
     * Create an instance of {@link RemoveRicambio }
     * 
     */
    public RemoveRicambio createRemoveRicambio() {
        return new RemoveRicambio();
    }

    /**
     * Create an instance of {@link RemoveRicambioResponse }
     * 
     */
    public RemoveRicambioResponse createRemoveRicambioResponse() {
        return new RemoveRicambioResponse();
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
     * Create an instance of {@link UpdateRicambio }
     * 
     */
    public UpdateRicambio createUpdateRicambio() {
        return new UpdateRicambio();
    }

    /**
     * Create an instance of {@link UpdateRicambioResponse }
     * 
     */
    public UpdateRicambioResponse createUpdateRicambioResponse() {
        return new UpdateRicambioResponse();
    }

    /**
     * Create an instance of {@link RicambioAuto }
     * 
     */
    public RicambioAuto createRicambioAuto() {
        return new RicambioAuto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRicambio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRicambio }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "addRicambio")
    public JAXBElement<AddRicambio> createAddRicambio(AddRicambio value) {
        return new JAXBElement<AddRicambio>(_AddRicambio_QNAME, AddRicambio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRicambioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRicambioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "addRicambioResponse")
    public JAXBElement<AddRicambioResponse> createAddRicambioResponse(AddRicambioResponse value) {
        return new JAXBElement<AddRicambioResponse>(_AddRicambioResponse_QNAME, AddRicambioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRicambio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveRicambio }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "removeRicambio")
    public JAXBElement<RemoveRicambio> createRemoveRicambio(RemoveRicambio value) {
        return new JAXBElement<RemoveRicambio>(_RemoveRicambio_QNAME, RemoveRicambio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRicambioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveRicambioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "removeRicambioResponse")
    public JAXBElement<RemoveRicambioResponse> createRemoveRicambioResponse(RemoveRicambioResponse value) {
        return new JAXBElement<RemoveRicambioResponse>(_RemoveRicambioResponse_QNAME, RemoveRicambioResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectByCategory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectByCategory }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectByCategory")
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
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectByCategoryResponse")
    public JAXBElement<SelectByCategoryResponse> createSelectByCategoryResponse(SelectByCategoryResponse value) {
        return new JAXBElement<SelectByCategoryResponse>(_SelectByCategoryResponse_QNAME, SelectByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SelectById }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectById")
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
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "selectByIdResponse")
    public JAXBElement<SelectByIdResponse> createSelectByIdResponse(SelectByIdResponse value) {
        return new JAXBElement<SelectByIdResponse>(_SelectByIdResponse_QNAME, SelectByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRicambio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateRicambio }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "updateRicambio")
    public JAXBElement<UpdateRicambio> createUpdateRicambio(UpdateRicambio value) {
        return new JAXBElement<UpdateRicambio>(_UpdateRicambio_QNAME, UpdateRicambio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateRicambioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateRicambioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://StandardPackage/", name = "updateRicambioResponse")
    public JAXBElement<UpdateRicambioResponse> createUpdateRicambioResponse(UpdateRicambioResponse value) {
        return new JAXBElement<UpdateRicambioResponse>(_UpdateRicambioResponse_QNAME, UpdateRicambioResponse.class, null, value);
    }

}
