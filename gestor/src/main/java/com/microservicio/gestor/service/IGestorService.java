package com.microservicio.gestor.service;


import com.microservicio.gestor.model.dto.GestorDTO;

/**
 * Interfaz para definir metodos del servicio de gestor
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
public interface IGestorService {
    /**
     * Metodo para validar datos de acceso del gestor
     *
     * @param gestorDTO datos del gestor para validar ingreso
     * @return el gestor autorizado
     */
    public GestorDTO ingresarGestor(GestorDTO gestorDTO);

    /**
     * Metodo para registrar un gestor de inversión
     *
     * @param gestorDTO datos del gestor para ser creado
     * @return gestor que fue registrado exitosamente
     */
    public GestorDTO registrarGestor(GestorDTO gestorDTO) ;
}
