
package standardpackage;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "EJBorganiBeniService", targetNamespace = "http://StandardPackage/", wsdlLocation = "http://localhost:8080/EJBorganiBeniService/EJBorganiBeni?wsdl")
public class EJBorganiBeniService
    extends Service
{

    private final static URL EJBORGANIBENISERVICE_WSDL_LOCATION;
    private final static WebServiceException EJBORGANIBENISERVICE_EXCEPTION;
    private final static QName EJBORGANIBENISERVICE_QNAME = new QName("http://StandardPackage/", "EJBorganiBeniService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/EJBorganiBeniService/EJBorganiBeni?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EJBORGANIBENISERVICE_WSDL_LOCATION = url;
        EJBORGANIBENISERVICE_EXCEPTION = e;
    }

    public EJBorganiBeniService() {
        super(__getWsdlLocation(), EJBORGANIBENISERVICE_QNAME);
    }

    public EJBorganiBeniService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EJBORGANIBENISERVICE_QNAME, features);
    }

    public EJBorganiBeniService(URL wsdlLocation) {
        super(wsdlLocation, EJBORGANIBENISERVICE_QNAME);
    }

    public EJBorganiBeniService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EJBORGANIBENISERVICE_QNAME, features);
    }

    public EJBorganiBeniService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EJBorganiBeniService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EJBorganiBeni
     */
    @WebEndpoint(name = "EJBorganiBeniPort")
    public EJBorganiBeni getEJBorganiBeniPort() {
        return super.getPort(new QName("http://StandardPackage/", "EJBorganiBeniPort"), EJBorganiBeni.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EJBorganiBeni
     */
    @WebEndpoint(name = "EJBorganiBeniPort")
    public EJBorganiBeni getEJBorganiBeniPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://StandardPackage/", "EJBorganiBeniPort"), EJBorganiBeni.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EJBORGANIBENISERVICE_EXCEPTION!= null) {
            throw EJBORGANIBENISERVICE_EXCEPTION;
        }
        return EJBORGANIBENISERVICE_WSDL_LOCATION;
    }

}
