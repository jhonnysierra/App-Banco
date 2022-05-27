package com.microservicio.cliente.exception.excepcion_personalizada;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class BadRequestException
 * @date 09-05-2022
 */
public class BadRequestException extends RuntimeException {


    /**
     * Metodo constructor
     * @param message
     */
    public BadRequestException(String message) {
        super(message);
    }
}
