package com.microservicio.cliente.model.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class MisProductosDTO
 * @date 09-05-2022
 */
@Data
@Component
public class MisProductosDTO {
    private Long id;
    private String productoNombre;
    private BigDecimal saldoInicialProducto;
    private LocalDate fechaSolicitud;
    private LocalDate fechaActivacion;
    private LocalDate fechaFinPortafolio;
    private BigDecimal saldo;
    private String estado;


}
