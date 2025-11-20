
package cl.hcs.ws.soap.generado;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.hcs.ws.soap.generado package. 
 * <p>An ObjectFactory allows you to programmatically 
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

    private static final QName _DecirHola_QNAME = new QName("http://soap.ws.hcs.cl/", "decirHola");
    private static final QName _DecirHolaResponse_QNAME = new QName("http://soap.ws.hcs.cl/", "decirHolaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.hcs.ws.soap.generado
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DecirHola }
     * 
     * @return
     *     the new instance of {@link DecirHola }
     */
    public DecirHola createDecirHola() {
        return new DecirHola();
    }

    /**
     * Create an instance of {@link DecirHolaResponse }
     * 
     * @return
     *     the new instance of {@link DecirHolaResponse }
     */
    public DecirHolaResponse createDecirHolaResponse() {
        return new DecirHolaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecirHola }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DecirHola }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.ws.hcs.cl/", name = "decirHola")
    public JAXBElement<DecirHola> createDecirHola(DecirHola value) {
        return new JAXBElement<>(_DecirHola_QNAME, DecirHola.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecirHolaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DecirHolaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.ws.hcs.cl/", name = "decirHolaResponse")
    public JAXBElement<DecirHolaResponse> createDecirHolaResponse(DecirHolaResponse value) {
        return new JAXBElement<>(_DecirHolaResponse_QNAME, DecirHolaResponse.class, null, value);
    }

}
