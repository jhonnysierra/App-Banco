package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTOS")
@Data
public class Producto {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GESTOR_ID", nullable = false)
    private Gestor gestor;

    @Column(name = "TIEMPO_COMPANIA")
    private int tiempoCompania;

    @Column(name = "TIEMPO_PERMANENCIA")
    private int tiempoPermanencia;

    @Column(name = "TIEMPO_ACTIVACION", nullable = false)
    private int tiempoActivacion;

    @Column(name = "MONTO_MINIMO", precision = 38, scale = 2)
    private BigDecimal montoMinimo;

    @Column(name = "MONTO_COMPANIA", precision = 38, scale = 2)
    private BigDecimal montoCompania;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CIUDAD_ID", nullable = false)
    private Ciudad ciudad;

    @Column(name = "ORIGEN", nullable = false, length = 20)
    private String origen;
}