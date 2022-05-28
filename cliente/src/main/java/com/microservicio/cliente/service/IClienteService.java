package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.ClienteDTO;

/**
 * Se crea una interfaz para crear los metodos del servicio, solo se ponen los parametros. Seran sobreescritos
 * en la implementeacion del servicio. Los metodos de esta clase son publicos
 */
public interface IClienteService {
    /**
     * Metodo que permite crear un nuevo cliente en la empresa de inversion
     *
     * @param clienteDTO objeto {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="jhonnysierr@gmail.com"> Jhonny Sierra P</a>
     * @date 07-05-2022
     */
    public ClienteDTO crearCliente(ClienteDTO clienteDTO);

    /**
     * Metodo que permite consultar un cliente
     *
     * @param idCliente Identificador del cliente
     * @return Objeto {@link ClienteDTO} que contiene la informacion del cliente
     * @author <a href="jhonnysierr@gmail.com"> Jhonny Sierra P</a>
     * @date 07-05-2022
     */
    public ClienteDTO consultarCliente(Long idCliente);

    /**
     * Metodo que valida datos de acceso de un cliente
     *
     * @param clienteDTO {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="jhonnysierr@gmail.com"> Jhonny Sierra P</a>
     * @date 09-05-2022
     */
    public ClienteDTO ingresarCliente(ClienteDTO clienteDTO);
}
