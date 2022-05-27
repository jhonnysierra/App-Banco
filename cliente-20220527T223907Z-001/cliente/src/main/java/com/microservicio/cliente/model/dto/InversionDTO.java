package com.microservicio.cliente.model.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class InversionDTO
 * @date 09-05-2022
 */
@Component
@Data
public class InversionDTO {
    private Long id;
    private Long clienteId;
    private Long productoId;
    private LocalDate fechaSolicitud;
    private LocalDate fechaFinPortafolio;
    private LocalDate fechaActivacion;
    private BigDecimal saldo;
}
