package com.microservicio.cliente.model.dto;

import com.microservicio.cliente.model.Ciudad;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class ClienteDTO
 * @date 07-05-2022
 * @version 1.0
 */
@Data
@Component
public class ClienteDTO {
    private Long id;
    private Long cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private char estado;
    private Long ciudadId;
    private LocalDate fechaRegistro;
}
