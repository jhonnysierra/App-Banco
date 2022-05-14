package com.microservicio.cliente.exception.message;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageFormat {
    private int codigoError;
    private String mensaje;
}
