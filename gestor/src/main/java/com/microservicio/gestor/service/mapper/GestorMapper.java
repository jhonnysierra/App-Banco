package com.microservicio.gestor.service.mapper;

import com.microservicio.gestor.model.Gestor;
import com.microservicio.gestor.model.dto.GestorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interfaz mapper para covertir Dto en entidad y entidad en Dto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Mapper(componentModel = "spring")
public interface GestorMapper {
    /**
     * Metodo para convertir un Dto a entidad
     *
     * @param gestorDTO dto a convertir en entidad
     * @return entidaa
     */
    Gestor convertirDTOAEntidad(GestorDTO gestorDTO);

    /**
     * Metodo para convertir entidad en Dto
     *
     * @param gestor entidad a convertir en Dto
     * @return Dto de la entidad
     */
    @Mapping(target = "contrasena", ignore = true)
    GestorDTO convertirEntidadADTO(Gestor gestor);
}
