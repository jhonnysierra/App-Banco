package com.microservicio.gestor.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Dto para transferir datos de ciudades
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Component
public class CiudadDTO {
    private Long id;
    private String nombre;
}
