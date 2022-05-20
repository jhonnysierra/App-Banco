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


    /**
     * Metodo que permite convertir una entidad {@link Inversion} en un objeto de la clase {@link MisProductosDTO}
     * La etiqueta ignore es para que no devuelva campos
     *
     * @param inversion Entidad de tipo {@link Inversion}
     * @return Entidad de tipo {@link MisProductosDTO}
     */
    @Mapping(target = "estado",ignore = true)
    @Mapping(source = "inversion.producto.nombre", target = "productoNombre")
    public MisProductosDTO convertirEntidadAMisproductosDTO(Inversion inversion);

    /**
     * Metodo que permite convertir entidades de tipo Inversion a Mis productos DTO
     * --- Cuando se trata de listas se debe crear el metodo que convierta una sola entidad. Para este caso
     * --- existe el metodo convertirEntidadAMisproductosDTO() declarado en esta clase.
     *
     * @param listaInversion Lista de entidades de tipo {@link Inversion}
     * @return Lista de {@link MisProductosDTO}
     */
    @Mapping(target = "estado",ignore = true)
    @Mapping(source = "inversion.producto.nombre", target = "productoNombre")
    public List<MisProductosDTO> convertirListaEntidadAListaMisproductosDTO(List<Inversion> listaInversion);
}
