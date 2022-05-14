package com.microservicio.reporte.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class Cliente
 * @date 05-05-2022
 * @version 1.0
 */
@Data
@Table("CLIENTES")
public class Cliente {
    @Id
    @Column("ID")
    private Long id;

    @Column("CEDULA")
    private Long cedula;

    @Column("NOMBRES")
    private String nombres;

    @Column("APELLIDOS")
    private String apellidos;

    @Column("CORREO")
    private String correo;

    @Column("CONTRASENA")
    private String contrasena;

    @Column("ESTADO")
    private String estado;

    @Column("CIUDAD")
    private Long ciudad;

    @Column("FECHA_REGISTRO")
    private LocalDate fechaRegistro;
}
