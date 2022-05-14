package com.microservicio.cliente.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@Data
public class InversionDTO {

	private Long id;

	private Long idCliente;

	private Long idProducto;

	private LocalDate fechaSolicitud;

	private LocalDate fechaActivacion;

	private LocalDate fechaFinPortafolio;

	private BigDecimal saldo;
}
