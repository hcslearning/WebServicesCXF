package cl.hcs.ws.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Set;

@ApplicationPath("/api")
public class MiAplicacionREST extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Set.of( ProductoService.class );
    }
}
