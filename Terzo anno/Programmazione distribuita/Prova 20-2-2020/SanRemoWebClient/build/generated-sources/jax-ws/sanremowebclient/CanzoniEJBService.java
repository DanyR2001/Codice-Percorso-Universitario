
package sanremowebclient;

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
@WebServiceClient(name = "CanzoniEJBService", targetNamespace = "http://standardPackage/", wsdlLocation = "http://localhost:8080/CanzoniEJBService/CanzoniEJB?wsdl")
public class CanzoniEJBService
    extends Service
{

    private final static URL CANZONIEJBSERVICE_WSDL_LOCATION;
    private final static WebServiceException CANZONIEJBSERVICE_EXCEPTION;
    private final static QName CANZONIEJBSERVICE_QNAME = new QName("http://standardPackage/", "CanzoniEJBService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/CanzoniEJBService/CanzoniEJB?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CANZONIEJBSERVICE_WSDL_LOCATION = url;
        CANZONIEJBSERVICE_EXCEPTION = e;
    }

    public CanzoniEJBService() {
        super(__getWsdlLocation(), CANZONIEJBSERVICE_QNAME);
    }

    public CanzoniEJBService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CANZONIEJBSERVICE_QNAME, features);
    }

    public CanzoniEJBService(URL wsdlLocation) {
        super(wsdlLocation, CANZONIEJBSERVICE_QNAME);
    }

    public CanzoniEJBService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CANZONIEJBSERVICE_QNAME, features);
    }

    public CanzoniEJBService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CanzoniEJBService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CanzoniEJB
     */
    @WebEndpoint(name = "CanzoniEJBPort")
    public CanzoniEJB getCanzoniEJBPort() {
        return super.getPort(new QName("http://standardPackage/", "CanzoniEJBPort"), CanzoniEJB.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CanzoniEJB
     */
    @WebEndpoint(name = "CanzoniEJBPort")
    public CanzoniEJB getCanzoniEJBPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://standardPackage/", "CanzoniEJBPort"), CanzoniEJB.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CANZONIEJBSERVICE_EXCEPTION!= null) {
            throw CANZONIEJBSERVICE_EXCEPTION;
        }
        return CANZONIEJBSERVICE_WSDL_LOCATION;
    }

}
