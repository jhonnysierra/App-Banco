package com.microservicio.cliente.model;


import lombok.Data;

import javax.persistence.*;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class Ciudad
 * @date 07-05-2022
 */
@Data
@Entity
@Table(name = "CIUDAD")
public class Ciudad {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "ID")
    private Departamento departamento;

}
