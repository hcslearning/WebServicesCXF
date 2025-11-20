package cl.hcs.ws.soap;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService
public interface Servicio {
    @WebResult(name = "saludo")
    String decirHola(
            @WebParam(name = "nombre") String nombre
    );
}
