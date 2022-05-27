package com.microservicio.cliente.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class Cliente
 * @date 07-05-2022
 */
@Data
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ID_CLIENTES")
    @SequenceGenerator(name = "SEC_ID_CLIENTES", sequenceName = "SEC_ID_CLIENTES", allocationSize = 1)
    private Long id;
    @Column(name = "CEDULA", nullable = false)
    private Long cedula;

    @Column(name = "NOMBRES", nullable = false, length = 50)
    private String nombres;

    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "CORREO", nullable = false, length = 50)
    private String correo;

    @Column(name = "CONTRASENA", nullable = false, length = 100)
    private String contrasena;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CIUDAD_ID", referencedColumnName = "ID")
    private Ciudad ciudad;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDate fechaRegistro;

}
