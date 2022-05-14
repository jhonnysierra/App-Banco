package com.microservicio.reporte.service;

import com.microservicio.reporte.model.dto.InversionDto;
import com.microservicio.reporte.model.dto.ReporteInversionDto;

import java.util.List;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class IClienteService
 * @date 05-05-2022
 * @version 1.0
 */
public interface IClienteService {
    /**
     * Metodo que permite generar reporte de productos del cliente
     * @param idCliente idCliente
     * @return {@link ReporteInversionDto}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 06-05-2022
     */
    List<ReporteInversionDto> generarReporteCliente(Long idCliente);
}
