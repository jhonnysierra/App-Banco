package com.microservicio.cliente.service.mapper;

import com.microservicio.cliente.model.Producto;
import com.microservicio.cliente.model.dto.ProductoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Interfaz mapper para covertir DTO en entidad y entidad en DTO
 *
 * @author: Jhonny Sierra Parra
 * @version: v1.0
 */
@Mapper(componentModel = "spring")
public interface ProductoMapper {
    /**
     * Metodo para convertir un Dto en una entidad
     *
     * @param productoDTO dto a convertir en entidad
     * @return entidad
     */
    @Mapping(source = "productoDTO.gestor", target = "gestor.id")
    @Mapping(source = "productoDTO.ciudad", target = "ciudad.id")
    @Mapping(source = "productoDTO.nombreCiudad", target = "ciudad.nombre")
    Producto convertirDTOAEntidad(ProductoDTO productoDTO);

    /**
     * Metodo para convertir una entidad en un Dto
     *
     * @param producto entidad a ser convertida
     * @return Dto correspondiente
     */
    @Mapping(source = "producto.gestor.id", target = "gestor")
    @Mapping(source = "producto.ciudad.id", target = "ciudad")
    @Mapping(source = "producto.ciudad.nombre", target = "nombreCiudad")
    ProductoDTO convertirEntidadADTO(Producto producto);

    /**
     * Metodo para convertir lista de entidades en lista de Dtos
     *
     * @param listaProducto lista de entidades
     * @return lista de Dtos correspondiente
     */
    @Mapping(source = "producto.gestor.id", target = "gestor")
    @Mapping(source = "producto.ciudad.id", target = "ciudad")
    @Mapping(source = "producto.ciudad.nombre", target = "nombreCiudad")
    List<ProductoDTO> convertirListaEntidadAListaDTO(List<Producto> listaProducto);
}
