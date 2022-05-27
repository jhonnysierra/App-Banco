package com.microservicio.cliente.service.mapper;

import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ClienteMapper
 * @date 07-05-2022
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    /**
     * Metodo que permite convertir un DTO en una entidad
     *
     * @param clienteDTO objeto {@link ClienteDTO}
     * @return {@link Cliente}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    @Mapping(source = "clienteDTO.ciudadId", target = "ciudad.id")
    public Cliente convertirDTOAEntidad(ClienteDTO clienteDTO);

    /**
     * Metodo que permite convertir un DTO en una entidad
     *
     * @param cliente objeto{@link Cliente}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    @Mapping(target = "contrasena", ignore = true)
    @Mapping(source = "cliente.ciudad.id", target = "ciudadId")
    public ClienteDTO convertirEntidadADTO(Cliente cliente);
}
