package com.microservicio.gestor.exception;


import com.microservicio.gestor.exception.excepcionpersonalizada.BadRequestException;
import com.microservicio.gestor.exception.excepcionpersonalizada.ConflictExcepcion;
import com.microservicio.gestor.exception.excepcionpersonalizada.NotFoundException;
import com.microservicio.gestor.exception.excepcionpersonalizada.UnauthorizedException;
import com.microservicio.gestor.exception.mensaje.MensajeError;
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
 * @date 09-05-2022
 */
@ControllerAdvice
public class ExceptionControllerAdvise {
    /**
     * Metodo
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MensajeError> badRequest(Exception ex) {
        MensajeError mensajeError = MensajeError.builder().codigoEstado(HttpStatus.BAD_REQUEST.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MensajeError> notFound(Exception ex) {
        MensajeError mensajeError = MensajeError.builder().codigoEstado(HttpStatus.NOT_FOUND.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictExcepcion.class)
    public ResponseEntity<MensajeError> conflict(Exception ex) {
        MensajeError mensajeError = MensajeError.builder().codigoEstado(HttpStatus.CONFLICT.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.CONFLICT);
    }

    /**
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<MensajeError> unauthorized(Exception ex) {
        MensajeError mensajeError = MensajeError.builder().codigoEstado(HttpStatus.UNAUTHORIZED.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.UNAUTHORIZED);
    }

    /**
     *
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
