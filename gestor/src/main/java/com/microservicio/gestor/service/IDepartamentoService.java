package com.microservicio.gestor.service;

import com.microservicio.gestor.model.Departamento;
import com.microservicio.gestor.model.dto.DepartamentoDTO;

import java.util.List;
/**
 * Interfaz para definir metodos del servicio de departamento
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
public interface IDepartamentoService {
    /**
     * Metodo para consultar todos los departamentos
     *
     * @return lista de departamentos
     */
    List<DepartamentoDTO> consultarDepartamentos();
}
