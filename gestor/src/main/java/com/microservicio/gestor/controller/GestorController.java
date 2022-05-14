package com.microservicio.gestor.controller;


import com.microservicio.gestor.model.dto.GestorDTO;
import com.microservicio.gestor.service.IGestorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controlador para manejar end points de gestores de inversión
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@RestController
@RequestMapping("/techcamp/api/1.0")
public class GestorController {

    private final IGestorService iGestorService;

    /**
     * Metodo constructor
     *
     * @param iGestorService
     */
    public GestorController(IGestorService iGestorService) {
        this.iGestorService = iGestorService;
    }

    /**
     * Metodo para validar datos de acceso del gestor
     *
     * @param gestorDTO datos del gestor para validar ingreso
     * @return el gestor autorizado
     */
    @PostMapping("/ingresar/gestor")
    public GestorDTO ingresarGestor(@RequestBody GestorDTO gestorDTO)  {
        return iGestorService.ingresarGestor(gestorDTO);
    }

    /**
     * Metodo para registrar un gestor de inversión
     *
     * @param gestorDTO datos del gestor para ser creado
     * @return gestor que fue registrado exitosamente
     */
    @PostMapping("/registrar/gestor")
    public GestorDTO registarGestor(@RequestBody GestorDTO gestorDTO) {
        return iGestorService.registrarGestor(gestorDTO);
    }

}
