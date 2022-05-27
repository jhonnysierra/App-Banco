package com.microservicio.cliente.service;

import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.dto.ClienteDTO;



/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class IClienteService
 * @date 07-05-2022
 */
public interface IClienteService {
    /**
     * Metodo que permite crear un nuevo cliente en la empresa de inversion
     *
     * @param clienteDTO objeto {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    public ClienteDTO crearCliente(ClienteDTO clienteDTO);

    /**
     * Metodo que permite consultar un cliente
     *
     * @param idCliente {idCliente}
     * @return {@link Cliente}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    public ClienteDTO consultarC(Long idCliente);

    /**
     * Metodo que valida datos de acceso de un cliente
     *
     * @param clienteDTO {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 09-05-2022
     */
    public ClienteDTO ingresarCliente(ClienteDTO clienteDTO);
}
