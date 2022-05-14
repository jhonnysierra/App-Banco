package com.microservicio.gestor.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Dto para transferir datos de departamentos
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Component
public class DepartamentoDTO {

    private Long id;
    private String nombre;
}
