package com.microservicio.cliente.controller;

import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.dto.ClienteDTO;
import com.microservicio.cliente.service.IClienteService;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ClienteController
 * @date 07-05-2022
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class ClienteController {
    private final IClienteService iClienteService;

    /**
     * Metodo constructor
     *
     * @param iClienteService {@link IClienteService}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    /**
     * Metodo que permite crear un nuevo cliente en la empresa de inversion
     *
     * @param clienteDTO objeto {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    @PostMapping("/crear/cliente")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO clienteDTO) {
        return iClienteService.crearCliente(clienteDTO);
    }

    /**
     * Metodo que permite consultar un cliente
     *
     * @param idCliente {idCliente}
     * @return {@link Cliente}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    @GetMapping("/cliente/{idCliente}")
    public ClienteDTO consultarCliente(@PathVariable Long idCliente) {
        return iClienteService.consultarC(idCliente);
    }

    /**
     * Metodo que valida datos de acceso de un cliente
     *
     * @param clienteDTO {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 09-05-2022
     */
    @PostMapping("/ingresar/cliente")
    public ClienteDTO ingresarCliente(@RequestBody ClienteDTO clienteDTO) {
        return iClienteService.ingresarCliente(clienteDTO);
    }

}
