package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class Departamento
 * @date 07-05-2022
 */
@Data
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}
