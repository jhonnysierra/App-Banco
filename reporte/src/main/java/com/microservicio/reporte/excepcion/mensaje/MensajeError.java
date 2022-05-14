package com.microservicio.reporte.excepcion.mensaje;

import lombok.Builder;
import lombok.Data;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class MensajeError
 * @date 05-05-2022
 * @version 1.0
 */
@Data
@Builder
public class MensajeError {
    private int codigoEstado;
    private String mensaje;

}
