package cl.hcs.ws.soap;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServidorSOAP {

    private static Logger LOGGER = LoggerFactory.getLogger(ServidorSOAP.class);

    public static void main(String[] args) {
        ServicioImpl servicio = new ServicioImpl();
        String url = "http://localhost:8080/soap/prueba";
        LoggingFeature loggingFeature = new LoggingFeature();
        LOGGER.info("Levantando servidor SOAP en {}?wsdl", url);
        Endpoint.publish(url, servicio, loggingFeature);
    }
}
