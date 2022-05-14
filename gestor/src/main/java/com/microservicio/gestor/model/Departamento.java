package com.microservicio.gestor.model;

import lombok.Data;


import javax.persistence.*;

/**
 * Entidad para almacenar los departamentos
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {

    @Id
    @Column(name = "ID")
   // @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
}
