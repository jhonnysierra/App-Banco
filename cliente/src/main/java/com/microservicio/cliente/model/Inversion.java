package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "INVERSIONES")
@Data
public class Inversion {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_ID_INVERSIONES")
    @SequenceGenerator(name = "SEC_ID_INVERSIONES", sequenceName = "SEC_ID_INVERSIONES", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCTO_ID", nullable = false)
    private Producto producto;

    @Column(name = "FECHA_SOLICITUD", nullable = false)
    private LocalDate fechaSolicitud;

    @Column(name = "FECHA_ACTIVACION", nullable = false)
    private LocalDate fechaActivacion;

    @Column(name = "FECHA_FIN_PORTAFOLIO")
    private LocalDate fechaFinPortafolio;

    @Column(name = "SALDO", nullable = false, precision = 38, scale = 2)
    private BigDecimal saldo;
}