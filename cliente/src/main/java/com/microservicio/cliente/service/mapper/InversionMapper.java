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
    @Mapping(source = "inversionDTO.idCliente", target = "cliente.id")
    @Mapping(source = "inversionDTO.idProducto", target = "producto.id")
    public Inversion convertirDTOAInversion(InversionDTO inversionDTO);

    /**
     * Metodo que permite convertir una Inversion a DTO
     * @param inversion {@link Inversion}
     * @return
     */
    @Mapping(source = "inversion.cliente.id", target = "idCliente")
    @Mapping(source = "inversion.producto.id", target = "idProducto")
    public InversionDTO convertirInversionADTO(Inversion inversion);

    @Mapping(target = "estado",ignore = true)
    @Mapping(source = "inversion.producto.nombre", target = "productoNombre")
    public MisProductosDTO convertirEntidadAMisproductosDTO(Inversion inversion);

    @Mapping(target = "estado",ignore = true)
    @Mapping(source = "inversion.producto.nombre", target = "productoNombre")
    public List<MisProductosDTO> convertirListaEntidadAListaMisproductosDTO(List<Inversion> listaInversion);
}
