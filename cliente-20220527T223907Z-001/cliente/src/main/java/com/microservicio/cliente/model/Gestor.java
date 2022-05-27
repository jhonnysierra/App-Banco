package com.microservicio.cliente.model;


import lombok.Data;

import javax.persistence.*;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class Gestor
 * @date 12-05-2022
 */
@Data
@Entity
@Table(name = "GESTORES")
public class Gestor {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ID_GESTORES")
    @SequenceGenerator(name = "SEC_ID_GESTORES", sequenceName = "SEC_ID_GESTORES", allocationSize = 1)
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

}
