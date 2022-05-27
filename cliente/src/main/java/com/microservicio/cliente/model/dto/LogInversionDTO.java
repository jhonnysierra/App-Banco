package com.microservicio.cliente.model.dto;

import com.microservicio.cliente.model.Inversion;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Data
public class LogInversionDTO {
    private Long id;
    private Long inversion;
    private LocalDate fecha;
    private BigDecimal saldo;
    private BigDecimal rendimiento;
}
