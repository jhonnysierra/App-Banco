package com.microservicio.gestor.service;


import com.microservicio.gestor.model.Ciudad;
import com.microservicio.gestor.model.dto.CiudadDTO;
import com.microservicio.gestor.model.dto.DepartamentoDTO;

import java.util.List;

/**
 * Interfaz para definir metodos del servicio de ciudad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
public interface ICiudadService {
    /**
     * Metodo para obtener todos las ciudades de un departamento
     *
     * @param idDepartamento, id del departamento para consultar ciudades
     * @return lista de ciudades
     */
    List<CiudadDTO> consultarCiudadesDeDepartamento(Long idDepartamento) ;

}
