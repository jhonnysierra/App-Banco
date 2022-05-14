package com.microservicio.gestor.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Dto para transferir datos de los gestores de inversión
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Component
public class GestorDTO {
    private Long id;
    private Long cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private char estado;
}
