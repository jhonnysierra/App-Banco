package com.microservicio.gestor.model.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Dto para transferir datos de un producto de inversión
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Component
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Long gestor;
    private int tiempo_compania;
    private int tiempo_permanencia;
    private int tiempo_activacion;
    private double monto_minimo;
    private double monto_compania;
    private Long ciudad;
    private String origen;
}