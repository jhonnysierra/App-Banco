package com.microservicio.reporte.excepcion;

import com.microservicio.reporte.excepcion.excepcionpersonalizada.BadRequestException;
import com.microservicio.reporte.excepcion.mensaje.MensajeError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ExceptionControllerAdvise
 * @date 05-05-2022
 */
@ControllerAdvice
public class ExceptionControllerAdvise {
    /**
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MensajeError> badRequest(BadRequestException ex) {
        MensajeError mensajeError = MensajeError.builder().codigoEstado(HttpStatus.BAD_REQUEST.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ResponseEntity<MensajeError> internalServerError(Exception ex) {
        MensajeError mensajeError = MensajeError.builder().codigoEstado(HttpStatus.INTERNAL_SERVER_ERROR.value()).mensaje("Error interno del sistema").build();
        return new ResponseEntity<>(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
