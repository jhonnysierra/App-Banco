package com.microservicio.gestor.controller;


import com.microservicio.gestor.model.dto.CiudadDTO;
import com.microservicio.gestor.service.ICiudadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador para manejar end points de ciudad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@RestController
@RequestMapping("/techcamp/api/1.0")
public class CiudadController {
    private final ICiudadService iCiudadService;

    public CiudadController(ICiudadService iCiudadService) {
        this.iCiudadService = iCiudadService;
    }

    /**
     * Metodo get para obtener todos las ciudades de un departamento
     *
     * @param idDepartamento, id del departamento para consultar ciudades
     * @return lista de ciudades
     */
    @GetMapping("/consultar/ciudades/{idDepartamento}")
    public List<CiudadDTO> consultarCiudadesDeDepartamento(@PathVariable Long idDepartamento)  {
        return iCiudadService.consultarCiudadesDeDepartamento(idDepartamento);
    }
}
