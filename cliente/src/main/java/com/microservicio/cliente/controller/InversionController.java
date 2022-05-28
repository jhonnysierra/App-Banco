package com.microservicio.cliente.controller;


import com.microservicio.cliente.model.Inversion;
import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;
import com.microservicio.cliente.service.IInversionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inversiones/api/1.0")
public class InversionController {
    private final IInversionService iInversionService;

    public InversionController(IInversionService iInversionService) {
        this.iInversionService = iInversionService;
    }

    /**
     * Metodo que permite consultar las inversiones del cliente
     *
     * @param idCliente id del cliente a consultar
     * @return lista de {@link MisProductosDTO}
     * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
     * @date 12-05-2022
     */
    @GetMapping("/consultar/inversion/cliente/{idCliente}")
    public List<MisProductosDTO> consultarInversionesCliente(@PathVariable Long idCliente) {
        return iInversionService.consultarInversionesCliente(idCliente);
    }

    /**
     * Metodo que permite validar si un cliente ya cumplio todos los requisitos en sus productos anteriores
     *
     * @param idCliente Id del cliente
     * @return Boolean true si cumple o false si por alguna razon no puede hacer recomposicion
     * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
     * @date 12-05-2022
     */
    @GetMapping("/validar/recomposicion/{idCliente}")
    public Boolean validarRecomposicion(@PathVariable Long idCliente) {
        return iInversionService.validarRecomposicion(idCliente);
    }

    /**
     * Metodo que permite consultar el saldo del cliente
     * @param id Identificador del cliente
     * @return {@link BigDecimal} Devuelve el saldo del cliente
     */
    @GetMapping("/consultar/saldo/{id}")
    public BigDecimal consultarSaldoCliente(@PathVariable Long id){
        return iInversionService.consultarSaldoCliente(id);
    }

    /**
     * Metodo que permite crear la inversion inicial
     *
     * @param inversionDTO {@link InversionDTO} Datos para crear la inversion inicial
     * @return {@link InversionDTO} Datos almacenados de la inversion
     */
    @PostMapping("/crear/inversion/inicial")
    public InversionDTO crearInversionInicial(@RequestBody InversionDTO inversionDTO){
        return iInversionService.crearInversionInicial(inversionDTO);
    }

    /**
     * Metodo que permite que un cliente haga una recomposicion
     *
     * @param inversionesDTOS {@link InversionDTO} Lista de inversiones del cliente
     * @param idCliente {@link Long} Identificador del cliente del cliente
     * @return {@link InversionDTO} Lista de inversiones en las que hizo recomposicion
     */
    @PostMapping("/crear/recomposicion/{idCliente}")
    public List<InversionDTO> hacerRecomposicionCliente(@RequestBody List<InversionDTO> inversionesDTOS, @PathVariable Long idCliente) {
        return iInversionService.hacerRecomposicionCliente(inversionesDTOS, idCliente);
    }

}
