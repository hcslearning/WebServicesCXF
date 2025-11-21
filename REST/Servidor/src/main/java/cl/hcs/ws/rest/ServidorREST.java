package cl.hcs.ws.rest;

import jakarta.ws.rs.SeBootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServidorREST {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServidorREST.class);

    public static void main(String[] args) {
        final SeBootstrap.Configuration conf = SeBootstrap.Configuration
                .builder()
                .protocol("http")
                .host("localhost")
                .port(9000)
                .rootPath("/")
                .build()
        ;

        SeBootstrap.start(new MiAplicacionREST(), conf)
                .toCompletableFuture()
                .join()
        ;
    }
}
