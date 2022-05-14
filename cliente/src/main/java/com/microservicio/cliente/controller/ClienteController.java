package com.microservicio.cliente.controller;

import com.microservicio.cliente.model.dto.ClienteDTO;
import com.microservicio.cliente.service.IClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inversiones/api/1.0")
public class ClienteController {
    private final IClienteService iClienteService;

    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    /**
     *
     * @RequestBody -> indica que se reciba el cuerpo del mensaje
     * @param clienteDTO
     * @return
     */
    @PostMapping("/crear/cliente")
    public ClienteDTO crearCliente(@RequestBody ClienteDTO clienteDTO){
        return iClienteService.crearCliente(clienteDTO);
    }

    @GetMapping("/buscar/cliente/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id){
        return iClienteService.consultarCliente(id);
    }

    /**
     * Metodo que valida datos de acceso de un cliente
     *
     * @param clienteDTO {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra</a>
     * @date 09-05-2022
     */
    @PostMapping("/ingresar/cliente")
    public ClienteDTO ingresarCliente(@RequestBody ClienteDTO clienteDTO) {
        return iClienteService.ingresarCliente(clienteDTO);
    }
}
