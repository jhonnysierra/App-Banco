package com.microservicio.cliente.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class Producto
 * @date 12-05-2022
 */
@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ID_PRODUCTOS")
    @SequenceGenerator(name = "SEC_ID_PRODUCTOS", sequenceName = "SEC_ID_PRODUCTOS", allocationSize = 1)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "GESTOR_ID", nullable = false)
    private Gestor gestor;

    @Column(name = "TIEMPO_COMPANIA", nullable = true)
    private int tiempoCompania;

    @Column(name = "TIEMPO_PERMANENCIA", nullable = true)
    private int tiempoPermanencia;

    @Column(name = "TIEMPO_ACTIVACION", nullable = false)
    private int tiempoActivacion;

    @Column(name = "MONTO_MINIMO", nullable = true)
    private BigDecimal montoMinimo;

    @Column(name = "MONTO_COMPANIA", nullable = true)
    private BigDecimal montoCompania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CIUDAD_ID", nullable = true)
    private Ciudad ciudad;

    @Column(name = "ORIGEN", nullable = false)
    private String origen;

}
