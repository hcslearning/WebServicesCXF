package cl.hcs.ws.soap;

import jakarta.jws.WebService;

@WebService(endpointInterface = "cl.hcs.ws.soap.Servicio", serviceName = "ServicioEjemplo")
public class ServicioImpl implements Servicio {

    @Override
    public String decirHola(String nombre) {
        return "hola "+nombre;
    }
}
