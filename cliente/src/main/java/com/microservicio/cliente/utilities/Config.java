package com.microservicio.cliente.utilities;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
public class Config {

    private final long CIUDAD_POR_DEFECTO_PRODUCTO = 1121;
}
