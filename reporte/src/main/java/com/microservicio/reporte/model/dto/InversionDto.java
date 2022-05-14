package com.microservicio.reporte.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class InversionDto
 * @date 05-05-2022
 * @version 1.0
 */
@Data
@Component
public class InversionDto {
    private  Long idinversion;
    private String productonombre;
    private double saldoactualproducto;
    private LocalDate fechaactivacion;
    private LocalDate fechafinportafolio;

}
