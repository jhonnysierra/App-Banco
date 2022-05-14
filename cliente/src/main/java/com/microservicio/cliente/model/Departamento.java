package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
@Data
public class Departamento {
    @Id
    @Column(name = "ID", nullable = false)

    private Long id;
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
}
