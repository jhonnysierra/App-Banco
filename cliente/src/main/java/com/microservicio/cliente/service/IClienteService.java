package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.ClienteDTO;

/**
 * Se crea una interfaz para crear los metodos del servicio, solo se ponen los parametros. Seran sobreescritos
 * en la implementeacion del servicio. Los metodos de esta clase son publicos
 */
public interface IClienteService {

    public ClienteDTO crearCliente(ClienteDTO clienteDTO);

    public ClienteDTO consultarCliente(Long id);

    public ClienteDTO ingresarCliente(ClienteDTO clienteDTO);
}
