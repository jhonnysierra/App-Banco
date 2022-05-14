package com.microservicio.gestor.service.mapper;

import com.microservicio.gestor.model.Ciudad;
import com.microservicio.gestor.model.dto.CiudadDTO;
import org.mapstruct.Mapper;

import java.util.List;
/**
 * Interfaz mapper para covertir Dto en entidad y entidad en Dto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Mapper(componentModel = "spring")
public interface CiudadMapper {
    /**
     * Metodo para convertir una lista de entidades en lista de Dtos
     * @param listaCiudad lista a convertir en Dto
     * @return lista de Dtos
     */
    List<CiudadDTO> convertirListaEntidadAListaDTO(List<Ciudad> listaCiudad);
}
