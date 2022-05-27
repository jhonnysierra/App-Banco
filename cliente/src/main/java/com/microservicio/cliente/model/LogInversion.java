package com.microservicio.cliente.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "LOG_INVERSIONES")
public class LogInversion {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "INVERSIONES_ID", nullable = false)
    private Inversion inversion;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "SALDO", nullable = false, precision = 38, scale = 2)
    private BigDecimal saldo;

    @Column(name = "RENDIMIENTO", nullable = false, precision = 38, scale = 2)
    private BigDecimal rendimiento;


}