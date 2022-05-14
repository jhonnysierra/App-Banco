package com.microservicio.reporte.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class ReporteInversionDto
 * @date 05-05-2022
 * @version 1.0
 */
@Data
@Component
public class ReporteInversionDto {
    private String nombreProducto;
    private int diasPermancia;
    private LocalDate fechaInicioInversion;
    private LocalDate fechaFinInversion;
    private double saldoInicial;
    private double saldoActual;
    private String estado;
}
