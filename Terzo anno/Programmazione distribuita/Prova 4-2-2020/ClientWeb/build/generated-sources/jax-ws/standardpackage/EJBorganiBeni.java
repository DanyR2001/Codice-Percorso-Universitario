
package standardpackage;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EJBorganiBeni", targetNamespace = "http://StandardPackage/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EJBorganiBeni {


    /**
     * 
     * @return
     *     returns java.util.List<standardpackage.OrganizzazioneBenefica>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "selectAll", targetNamespace = "http://StandardPackage/", className = "standardpackage.SelectAll")
    @ResponseWrapper(localName = "selectAllResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.SelectAllResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/selectAllRequest", output = "http://StandardPackage/EJBorganiBeni/selectAllResponse")
    public List<OrganizzazioneBenefica> selectAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns standardpackage.OrganizzazioneBenefica
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findById", targetNamespace = "http://StandardPackage/", className = "standardpackage.FindById")
    @ResponseWrapper(localName = "findByIdResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.FindByIdResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/findByIdRequest", output = "http://StandardPackage/EJBorganiBeni/findByIdResponse")
    public OrganizzazioneBenefica findById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<standardpackage.OrganizzazioneBenefica>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "selectTrasparenzaMax", targetNamespace = "http://StandardPackage/", className = "standardpackage.SelectTrasparenzaMax")
    @ResponseWrapper(localName = "selectTrasparenzaMaxResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.SelectTrasparenzaMaxResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/selectTrasparenzaMaxRequest", output = "http://StandardPackage/EJBorganiBeni/selectTrasparenzaMaxResponse")
    public List<OrganizzazioneBenefica> selectTrasparenzaMax(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns standardpackage.OrganizzazioneBenefica
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "aggiornaOranizzazione", targetNamespace = "http://StandardPackage/", className = "standardpackage.AggiornaOranizzazione")
    @ResponseWrapper(localName = "aggiornaOranizzazioneResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.AggiornaOranizzazioneResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/aggiornaOranizzazioneRequest", output = "http://StandardPackage/EJBorganiBeni/aggiornaOranizzazioneResponse")
    public OrganizzazioneBenefica aggiornaOranizzazione(
        @WebParam(name = "arg0", targetNamespace = "")
        OrganizzazioneBenefica arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<standardpackage.OrganizzazioneBenefica>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByNumProg", targetNamespace = "http://StandardPackage/", className = "standardpackage.FindByNumProg")
    @ResponseWrapper(localName = "findByNumProgResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.FindByNumProgResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/findByNumProgRequest", output = "http://StandardPackage/EJBorganiBeni/findByNumProgResponse")
    public List<OrganizzazioneBenefica> findByNumProg(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<standardpackage.OrganizzazioneBenefica>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByBilancio", targetNamespace = "http://StandardPackage/", className = "standardpackage.FindByBilancio")
    @ResponseWrapper(localName = "findByBilancioResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.FindByBilancioResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/findByBilancioRequest", output = "http://StandardPackage/EJBorganiBeni/findByBilancioResponse")
    public List<OrganizzazioneBenefica> findByBilancio(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "aggiungiOranizzazione", targetNamespace = "http://StandardPackage/", className = "standardpackage.AggiungiOranizzazione")
    @ResponseWrapper(localName = "aggiungiOranizzazioneResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.AggiungiOranizzazioneResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/aggiungiOranizzazioneRequest", output = "http://StandardPackage/EJBorganiBeni/aggiungiOranizzazioneResponse")
    public void aggiungiOranizzazione(
        @WebParam(name = "arg0", targetNamespace = "")
        OrganizzazioneBenefica arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "rimuoviOranizzazione", targetNamespace = "http://StandardPackage/", className = "standardpackage.RimuoviOranizzazione")
    @ResponseWrapper(localName = "rimuoviOranizzazioneResponse", targetNamespace = "http://StandardPackage/", className = "standardpackage.RimuoviOranizzazioneResponse")
    @Action(input = "http://StandardPackage/EJBorganiBeni/rimuoviOranizzazioneRequest", output = "http://StandardPackage/EJBorganiBeni/rimuoviOranizzazioneResponse")
    public void rimuoviOranizzazione(
        @WebParam(name = "arg0", targetNamespace = "")
        OrganizzazioneBenefica arg0);

}
