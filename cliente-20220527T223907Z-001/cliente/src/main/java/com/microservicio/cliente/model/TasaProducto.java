package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "TASA_PRODUCTO")
public class TasaProducto {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TASA_DIARIA", nullable = false, precision = 38, scale = 2)
    private BigDecimal tasaDiaria;

    @Column(name = "FECHA_DIA", nullable = false)
    private LocalDate fechaDia;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCTO_ID", nullable = false)
    private Producto producto;

}