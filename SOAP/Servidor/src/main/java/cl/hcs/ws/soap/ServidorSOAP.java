package cl.hcs.ws.soap;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.ext.logging.LoggingFeature;

public class ServidorSOAP {

    public static void main(String[] args) {
        ServicioImpl servicio = new ServicioImpl();
        String url = "http://localhost:8080/soap/prueba";
        LoggingFeature loggingFeature = new LoggingFeature();
        Endpoint.publish(url, servicio, loggingFeature);
    }
}
