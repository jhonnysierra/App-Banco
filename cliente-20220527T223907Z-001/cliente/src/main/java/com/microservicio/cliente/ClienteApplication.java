package com.microservicio.cliente;

import com.microservicio.cliente.utilities.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ClienteApplication
 * @date 07-05-2022
 */
@SpringBootApplication
@EnableScheduling
public class ClienteApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }

}
