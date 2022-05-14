package com.microservicio.gestor.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entidad para asignar tasas de ganancia y perdida a un producto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Entity
@Table(name = "TASA_PRODUCTO")
public class Tasa_Producto {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ID_TASA_PRODUCTO")
    @SequenceGenerator(name = "SEC_ID_TASA_PRODUCTO", sequenceName = "SEC_ID_TASA_PRODUCTO", allocationSize = 1)
    private Long id;

    @Column(name = "TASA_DIARIA")
    private double tasa_diaria;

    @Column(name = "FECHA_DIA")
    private LocalDate fecha_dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTO_ID", nullable = false)
    private Producto producto;
}
