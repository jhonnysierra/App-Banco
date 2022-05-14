package com.microservicio.gestor.model;


import lombok.Data;


import javax.persistence.*;

/**
 * Entidad para almacenar los productos de inversión creados por los gestores
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
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
    private int tiempo_compania;

    @Column(name = "TIEMPO_PERMANENCIA", nullable = true)
    private int tiempo_permanencia;

    @Column(name = "TIEMPO_ACTIVACION", nullable = false)
    private int tiempo_activacion;

    @Column(name = "MONTO_MINIMO", nullable = true)
    private double monto_minimo;

    @Column(name = "MONTO_COMPANIA", nullable = true)
    private double monto_compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CIUDAD_ID", nullable = true)
    private Ciudad ciudad;

    @Column(name = "ORIGEN", nullable = false)
    private String origen;

}
