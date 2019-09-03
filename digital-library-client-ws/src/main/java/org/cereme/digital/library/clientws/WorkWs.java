
package org.cereme.digital.library.clientws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "workWs", targetNamespace = "http://webservice.cereme.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WorkWs {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.InitResponse")
    public void init();

    /**
     * 
     * @return
     *     returns java.util.List<org.cereme.digital.library.clientws.Work>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.GetAllResponse")
    public List<Work> getAll();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<org.cereme.digital.library.clientws.Work>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findWorkByAuthorContainsAndTitleContains", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.FindWorkByAuthorContainsAndTitleContains")
    @ResponseWrapper(localName = "findWorkByAuthorContainsAndTitleContainsResponse", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.FindWorkByAuthorContainsAndTitleContainsResponse")
    public List<Work> findWorkByAuthorContainsAndTitleContains(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.cereme.digital.library.clientws.Work>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findWorkByAuthor", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.FindWorkByAuthor")
    @ResponseWrapper(localName = "findWorkByAuthorResponse", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.FindWorkByAuthorResponse")
    public List<Work> findWorkByAuthor(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns org.cereme.digital.library.clientws.Work
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findWorksById", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.FindWorksById")
    @ResponseWrapper(localName = "findWorksByIdResponse", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.FindWorksByIdResponse")
    public Work findWorksById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isValidByAuthor", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.IsValidByAuthor")
    @ResponseWrapper(localName = "isValidByAuthorResponse", targetNamespace = "http://webservice.cereme.org/", className = "org.cereme.digital.library.clientws.IsValidByAuthorResponse")
    public boolean isValidByAuthor(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
