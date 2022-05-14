package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTES")
@Data
public class Cliente {
    @Id
    @Column(name = "ID", nullable = false)
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
    private String contrasenia;

    @Column(name = "ESTADO", nullable = false)
    private char estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CIUDAD_ID", referencedColumnName = "ID")
    private Ciudad ciudad;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDate fechaRegistro;

}
