package com.microservicio.gestor.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
/**
 * Dto para transferir datos de las tasas de productos de inversión
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
import java.time.LocalDate;
@Data
@Component
public class Tasa_ProductoDTO {
    private Long id;
    private double tasa_diaria;
    private LocalDate fecha_dia;
    private Long producto;
}
