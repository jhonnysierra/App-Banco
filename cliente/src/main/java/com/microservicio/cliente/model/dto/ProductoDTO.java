package com.microservicio.cliente.model.dto;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ProductoDTO
 * @date 12-05-2022
 */
@Data
@Component
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Long gestor;
    private int tiempoCompania;
    private int tiempoPermanencia;
    private int tiempoActivacion;
    private double montoMinimo;
    private double montoCompania;
    private Long ciudad;
    private String nombreCiudad;
    private String origen;
}
