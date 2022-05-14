package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GESTORES")
@Data
public class Gestor {
    @Id
    @Column(name = "ID", nullable = false)
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

    @Column(name = "ESTADO", nullable = false)
    private Boolean estado = false;
}