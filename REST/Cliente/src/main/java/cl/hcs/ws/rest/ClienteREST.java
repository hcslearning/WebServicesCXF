package cl.hcs.ws.rest;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClienteREST {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteREST.class);
    private Client cliente;
    private WebTarget targetBase;

    public ClienteREST(Client cliente, WebTarget targetBase) {
        this.cliente = cliente;
        this.targetBase = targetBase;
    }

    private void revisaSiHayErrores(Response respuesta) {
        int estado = respuesta.getStatus();
        if( estado < 200 || estado >= 300 ) {
            String mensajeError = respuesta.readEntity(String.class);
            LOGGER.error("Estado respuesta: {}", estado);
            LOGGER.error("Respuesta: {}", respuesta);
            LOGGER.error("Error: {}", mensajeError);
            throw new RuntimeException(mensajeError);
        }
    }

    public static void main(String[] args) {
        try(
            Client cliente = ClientBuilder.newClient()
        ) {
            WebTarget targetBase = cliente.target("http://localhost:9000/api/producto");
            ClienteREST app = new ClienteREST(cliente, targetBase);

            Producto productoNuevo = new Producto(100, "PX", 10_980);
            LOGGER.info("Creando producto: {}", productoNuevo);
            app.crearProducto( productoNuevo );

            separador();

            Long productoIdAEliminar = 3L;
            LOGGER.info("Eliminando producto con ID: {}", productoIdAEliminar);
            app.eliminarProducto(productoIdAEliminar);

            separador();

            Producto productoViejo = app.getProductoPorId(2L);
            Producto productoActualizado = new Producto(2L, "Pelota football", 34_580);
            LOGGER.info("Actualizando producto ...");
            LOGGER.info("ANTES: {}", productoViejo);
            LOGGER.info("ACTUALIZADO: {}", productoActualizado);
            app.actualizarProducto(productoActualizado);

            separador();

            LOGGER.info("Recuperando todos los productos...");
            List<Producto> productos = app.getProductos();
            for ( Producto p : productos ) {
                LOGGER.info("ID: {}, Nombre: {}, Precio: {}", p.getId(), p.getNombre(), p.getPrecio());
            }
        }
    }

    private static void separador() {
        LOGGER.info( "+".repeat(20) );
        LOGGER.info( "+".repeat(20) );
    }

    public void crearProducto(Producto producto) {
        Response respuesta = targetBase.request(MediaType.APPLICATION_JSON).post(Entity.json(producto));
        revisaSiHayErrores(respuesta);
    }

    public void actualizarProducto(Producto producto) {
        Response respuesta = targetBase.path(producto.getId()+"").request(MediaType.APPLICATION_JSON).put(Entity.json(producto));
        revisaSiHayErrores(respuesta);
    }

    public void eliminarProducto(Long productoId) {
        Response respuesta = targetBase.path(productoId.toString()).request().delete();
        revisaSiHayErrores(respuesta);
    }

    public List<Producto> getProductos() {
        Response respuesta = targetBase.request(MediaType.APPLICATION_JSON).get();
        revisaSiHayErrores(respuesta);
        return respuesta.readEntity(new GenericType<List<Producto>>() {});
    }

    public Producto getProductoPorId(Long id) {
        Response respuesta = targetBase.path(id.toString()).request(MediaType.APPLICATION_JSON).get();
        revisaSiHayErrores(respuesta);
        return respuesta.readEntity(Producto.class);
    }
}
