package com.microservicio.reporte.controller;

import com.microservicio.reporte.model.dto.InversionDto;
import com.microservicio.reporte.model.dto.ReporteInversionDto;
import com.microservicio.reporte.service.IClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ClienteController
 * @date 05-05-2022
 */
@RestController
@RequestMapping("/techcamp/api/1.0")
public class ClienteController {
    private final IClienteService iClienteService;

    /**
     * Metodo constructor
     *
     * @param iClienteService
     */
    public ClienteController(IClienteService iClienteService) {
        this.iClienteService = iClienteService;
    }

    /**
     * Metodo que permite generar reporte de productos del cliente
     *
     * @param idCliente idCliente
     * @return {@link ReporteInversionDto}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 06-05-2022
     */
    @GetMapping("/generar/reporte/{idCliente}")
    public List<ReporteInversionDto> generarReporteCliente(@PathVariable Long idCliente) {
        return iClienteService.generarReporteCliente(idCliente);
    }
}
