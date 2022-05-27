package com.microservicio.cliente.controller;

import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;
import com.microservicio.cliente.service.IInversionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class InversionController
 * @date 12-05-2022
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class InversionController {
    private final IInversionService iInversionService;

    /**
     * Metodo constructor
     * @param iInversionService
     */
    public InversionController(IInversionService iInversionService) {
        this.iInversionService = iInversionService;
    }
    /**
     * Metodo que permite consultar las inversiones del cliente
     * @param idCliente id del cliente a consultar
     * @return lista de {@link MisProductosDTO}
     *  @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    @GetMapping("/consultar/inversion/cliente/{idCliente}")
    public List<MisProductosDTO> consultarInversionesCliente(@PathVariable Long idCliente) {
        return iInversionService.consultarInversionesCliente(idCliente);
    }
    /**
     * Metodo que permite validar si un cliente ya cumplio todos los requisitos en sus productos anteriores
     * @param idCliente id del cliente
     * @return Boolean true si cumple o false si por alguna razon no puede hacer recomposicion
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    @GetMapping("/validar/recomposicion/{idCliente}")
    public Boolean validarRecomposicion(@PathVariable Long idCliente) {
        return iInversionService.ValidarRecomposicion(idCliente);
    }
    /**
     * Metodo que permite consultar el saldo total del cliente en la empresa de inversion
     * @param idCliente id del cliente
     * @return Bigdecimal con el saldo del cliente
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    @GetMapping("/consultar/saldo/cliente/{idCliente}")
    public BigDecimal ConsultarSaldoCliente(@PathVariable Long idCliente) {
        return iInversionService.ConsultarSaldoCliente(idCliente);
    }

    /**
     *
     * @param inversionDTO
     * @return
     */
    @PostMapping("/crear/inversion/inicial")
    public InversionDTO crearInversionInicial(@RequestBody InversionDTO inversionDTO){
        return iInversionService.crearInversionInicial(inversionDTO);
    }

    /**
     *
     * @param inversionesDTOS
     * @param idCliente
     * @return
     */
    @PostMapping("/crear/recomposicion/{idCliente}")
    public List<InversionDTO> hacerRecomposicionCliente(@RequestBody List<InversionDTO> inversionesDTOS, @PathVariable Long idCliente) {
        return iInversionService.hacerRecomposicionCliente(inversionesDTOS, idCliente);
    }
}
