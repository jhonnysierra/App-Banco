package com.microservicio.gestor.model;


import lombok.Data;


import javax.persistence.*;

/**
 * Entidad para almacenar la ciudades
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Data
@Entity
@Table(name = "CIUDAD")
public class Ciudad {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTAMENTO_ID")
    private Departamento departamento;

}
