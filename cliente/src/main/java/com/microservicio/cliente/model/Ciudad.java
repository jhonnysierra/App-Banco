package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CIUDAD")
@Data
public class Ciudad {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")
    private Departamento departamento;
}
