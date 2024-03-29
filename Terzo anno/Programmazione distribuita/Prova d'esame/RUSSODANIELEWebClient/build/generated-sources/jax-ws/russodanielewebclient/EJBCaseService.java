
package russodanielewebclient;

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
@WebServiceClient(name = "EJBCaseService", targetNamespace = "http://StandardPackage/", wsdlLocation = "http://localhost:8080/EJBCaseService/EJBCase?wsdl")
public class EJBCaseService
    extends Service
{

    private final static URL EJBCASESERVICE_WSDL_LOCATION;
    private final static WebServiceException EJBCASESERVICE_EXCEPTION;
    private final static QName EJBCASESERVICE_QNAME = new QName("http://StandardPackage/", "EJBCaseService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/EJBCaseService/EJBCase?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        EJBCASESERVICE_WSDL_LOCATION = url;
        EJBCASESERVICE_EXCEPTION = e;
    }

    public EJBCaseService() {
        super(__getWsdlLocation(), EJBCASESERVICE_QNAME);
    }

    public EJBCaseService(WebServiceFeature... features) {
        super(__getWsdlLocation(), EJBCASESERVICE_QNAME, features);
    }

    public EJBCaseService(URL wsdlLocation) {
        super(wsdlLocation, EJBCASESERVICE_QNAME);
    }

    public EJBCaseService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, EJBCASESERVICE_QNAME, features);
    }

    public EJBCaseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EJBCaseService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns EJBCase
     */
    @WebEndpoint(name = "EJBCasePort")
    public EJBCase getEJBCasePort() {
        return super.getPort(new QName("http://StandardPackage/", "EJBCasePort"), EJBCase.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EJBCase
     */
    @WebEndpoint(name = "EJBCasePort")
    public EJBCase getEJBCasePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://StandardPackage/", "EJBCasePort"), EJBCase.class, features);
    }

    private static URL __getWsdlLocation() {
        if (EJBCASESERVICE_EXCEPTION!= null) {
            throw EJBCASESERVICE_EXCEPTION;
        }
        return EJBCASESERVICE_WSDL_LOCATION;
    }

}
