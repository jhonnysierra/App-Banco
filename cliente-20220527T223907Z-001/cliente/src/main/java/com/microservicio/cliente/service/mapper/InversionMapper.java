package com.microservicio.cliente.service.mapper;

import com.microservicio.cliente.model.Inversion;
import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface InversionMapper {

    /**
     * Metodo que permite convertir un DTO a Inversion
     *
     * @param inversionDTO
     * @return
     */
    @Mapping(source = "inversionDTO.clienteId", target = "cliente.id")
    @Mapping(source = "inversionDTO.productoId", target = "producto.id")
    public Inversion convertirDTOAEntidad(InversionDTO inversionDTO);

    // Metodo que permite convertir una Inversion a DTO
    @Mapping(source = "inversion.cliente.id", target = "clienteId")
    @Mapping(source = "inversion.producto.id", target = "productoId")
    public InversionDTO convertirEntidadADTO(Inversion inversion);

    @Mapping(target = "estado",ignore = true)
    @Mapping(source = "inversion.producto.nombre", target = "productoNombre")
    public MisProductosDTO convertirEntidadAMisproductosDTO(Inversion inversion);

    @Mapping(target = "estado",ignore = true)
    @Mapping(source = "inversion.producto.nombre", target = "productoNombre")
    public List<MisProductosDTO> convertirListaEntidadAListaMisproductosDTO(List<Inversion> listaInversion);

}
