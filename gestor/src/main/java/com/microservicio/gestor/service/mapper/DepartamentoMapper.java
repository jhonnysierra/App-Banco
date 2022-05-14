package com.microservicio.gestor.service.mapper;

import com.microservicio.gestor.model.Departamento;
import com.microservicio.gestor.model.dto.DepartamentoDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interfaz mapper para covertir Dto en entidad y entidad en Dto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
    /**
     * Metodo para convertir un Dto a entidad
     *
     * @param departamentoDTO dto para ser convertido en entidad
     * @return entidad correspondiente
     */
    Departamento convertirDTOAEntidad(DepartamentoDTO departamentoDTO);

    /**
     * Metodo para convertir una lista de entidades a lista de Dtos
     *
     * @param listaDepartamento lista de entidades
     * @return lista de Dto
     */
    List<DepartamentoDTO> convertirListaEntidadAListaDTO(List<Departamento> listaDepartamento);

}
