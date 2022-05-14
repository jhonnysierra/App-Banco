package com.microservicio.cliente.exception.custom.exceptions;
/**
 * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class UnauthorizedException
 * @date 09-05-2022
 */
public class UnauthorizedException extends RuntimeException {
    /**
     * Metodo constructor
     * @param mensaje Mensaje
     */
    public UnauthorizedException(String mensaje) {
        super(mensaje);
    }
}
