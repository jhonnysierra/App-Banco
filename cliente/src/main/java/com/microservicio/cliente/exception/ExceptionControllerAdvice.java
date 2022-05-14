package com.microservicio.cliente.exception;

import com.microservicio.cliente.exception.custom.exceptions.BadRequestException;
import com.microservicio.cliente.exception.custom.exceptions.ConflictException;
import com.microservicio.cliente.exception.custom.exceptions.NotFoundException;
import com.microservicio.cliente.exception.message.MessageFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<MessageFormat> conflictException(Exception ex){
        MessageFormat mensajeError = MessageFormat.builder().codigoError(HttpStatus.CONFLICT.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageFormat> badRequest(Exception ex){
        MessageFormat mensajeError = MessageFormat.builder().codigoError(HttpStatus.BAD_REQUEST.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageFormat> notFoundException(Exception ex){
        MessageFormat mensajeError = MessageFormat.builder().codigoError(HttpStatus.NOT_FOUND.value()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageFormat> internalServerErrorException(Exception ex){
        MessageFormat mensajeError = MessageFormat.builder().codigoError(HttpStatus.INTERNAL_SERVER_ERROR.value()).mensaje("Error interno del servidor").build();
        return new ResponseEntity<>(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
