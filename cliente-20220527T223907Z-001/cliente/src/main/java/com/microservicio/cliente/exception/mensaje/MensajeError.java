package com.microservicio.cliente.exception.mensaje;

import lombok.Builder;
import lombok.Data;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class MensajeError
 * @date 09-05-2022
 */
@Data
@Builder
public class MensajeError {
    private int codigoEstado;
    private String mensaje;

}
