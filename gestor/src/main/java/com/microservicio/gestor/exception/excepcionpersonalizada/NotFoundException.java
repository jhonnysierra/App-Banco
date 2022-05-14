package com.microservicio.gestor.exception.excepcionpersonalizada;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class NotFoundException
 * @date 09-05-2022
 */
public class NotFoundException extends RuntimeException {
    /**
     * Metodo constructor
     * @param mensaje
     */
    public NotFoundException(String mensaje) {
        super(mensaje);
    }
}
