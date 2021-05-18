package com.tdi.tienda_del_infinito.app;

import com.tdi.tienda_del_infinito.Shared.Config.ConfigurationSpring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ConfigurationSpring.class)
public class TiendaDelInfinitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaDelInfinitoApplication.class, args);
    }

}
