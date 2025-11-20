package cl.hcs.ws.soap;

import cl.hcs.ws.soap.generado.Servicio;
import cl.hcs.ws.soap.generado.ServicioEjemplo;

public class ClienteSOAP {

    public static void main(String[] args) {
        ServicioEjemplo servicioEjemplo = new ServicioEjemplo();
        Servicio servicioImplPort = servicioEjemplo.getServicioImplPort();
        String saludo = servicioImplPort.decirHola("Juan");
        System.out.println("Saludo: "+saludo);
    }
}
