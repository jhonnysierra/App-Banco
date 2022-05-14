package com.microservicio.cliente.service.mapper;

import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    /**
     * @mapping El source es lo que llega por parametro y el target es el campo donde se va a almacenar
     * el dato.
     * @param clienteDTO
     * @return
     */
    // Metodo que permite convertir un DTO a Cliente
    @Mapping(source = "clienteDTO.idCiudad", target = "ciudad.id")
    public Cliente convertirDTOACliente(ClienteDTO clienteDTO);

    // Metodo que permite convertir un Cliente a DTO
    @Mapping(source = "cliente.ciudad.id", target = "idCiudad")
    public ClienteDTO convertirClienteADTO(Cliente cliente);
}
