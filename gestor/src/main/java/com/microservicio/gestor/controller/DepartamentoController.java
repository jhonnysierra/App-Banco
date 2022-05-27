package com.microservicio.gestor.controller;

import com.microservicio.gestor.model.dto.DepartamentoDTO;
import com.microservicio.gestor.service.IDepartamentoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase controlador para manejar end points de departamento
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class DepartamentoController {
    private final IDepartamentoService iDepartamentoService;

    public DepartamentoController(IDepartamentoService iDepartamentoService) {
        this.iDepartamentoService = iDepartamentoService;
    }

    /**
     * Metodo para consultar todos los departamentos
     *
     * @return lista de departamentos
     */
    @GetMapping("consultar/departamentos")
    public List<DepartamentoDTO> consultarDepartamentos() {
        return iDepartamentoService.consultarDepartamentos();
    }
}
