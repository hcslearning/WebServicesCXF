package cl.hcs.ws.rest;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClienteREST {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteREST.class);

    public static void main(String[] args) {

        try(
            Client cliente = ClientBuilder.newClient()
        ) {
            WebTarget targetBase = cliente.target("http://localhost:9000/api/producto");

            Response respuesta = targetBase.request(MediaType.APPLICATION_JSON).get();

            if( respuesta.getStatus() == 200 ) {
                List<Producto> productos = respuesta.readEntity(new GenericType<List<Producto>>() {});
                for ( Producto p : productos ) {
                    LOGGER.info("ID: {}, Nombre: {}, Precio: {}", p.getId(), p.getNombre(), p.getPrecio());
                }
            } else {
                LOGGER.error("Ocurrió un error al consultar el servicio web REST con código: {}", respuesta.getStatus());
            }
        }
    }
}
