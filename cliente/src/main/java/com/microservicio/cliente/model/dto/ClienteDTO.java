package com.microservicio.cliente.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class ClienteDTO {
    private Long id;

    private Long cedula;

    private String nombres;

    private String apellidos;

    private String correo;

    private String contrasenia;

    private char estado;

    private Long idCiudad;

    private LocalDate fechaRegistro;
}
