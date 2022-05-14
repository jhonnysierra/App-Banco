package com.microservicio.gestor.service.mapper;

import com.microservicio.gestor.model.Tasa_Producto;
import com.microservicio.gestor.model.dto.Tasa_ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interfaz mapper para covertir Dto en entidad y entidad en Dto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Mapper(componentModel = "spring")
public interface Tasa_ProductoMapper {
    /**
     * Metodo que permite convertir un Dto en entidad
     *
     * @param tasa_productoDTO Dto a convertir en entidad
     * @return entidad
     */
    @Mapping(source = "tasa_productoDTO.producto", target = "producto.id")
    Tasa_Producto convertirDTOAEntidad(Tasa_ProductoDTO tasa_productoDTO);

    /**
     * Metodo que permite convertir una entidad en Dto
     *
     * @param tasa_producto entidad a convertir
     * @return Dto de la entidad correspondiente
     */
    @Mapping(source = "tasa_producto.producto.id", target = "producto")
    Tasa_ProductoDTO convertirEntidadADTO(Tasa_Producto tasa_producto);
}
