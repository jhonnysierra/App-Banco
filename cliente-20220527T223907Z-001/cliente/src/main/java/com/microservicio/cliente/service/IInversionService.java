package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;

import java.math.BigDecimal;
import java.util.List;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class IInversionService
 * @date 12-05-2022
 */
public interface IInversionService {
    /**
     * Metodo que permite consultar las inversiones del cliente
     * @param idCliente id del cliente a consultar
     * @return lista de {@link MisProductosDTO}
     *  @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
      * @date 12-05-2022
     */
    public List<MisProductosDTO> consultarInversionesCliente(Long idCliente);

    /**
     * Metodo que permite validar si un cliente ya cumplio todos los requisitos en sus productos anteriores
     * @param idCliente id del cliente
     * @return Boolean true si cumple o false si por alguna razon no puede hacer recomposicion
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    public Boolean ValidarRecomposicion(Long idCliente);

    /**
     * Metodo que permite consultar el saldo total del cliente en la empresa de inversion
     * @param idCliente id del cliente
     * @return Bigdecimal con el saldo del cliente
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    public BigDecimal ConsultarSaldoCliente(Long idCliente);


    public InversionDTO crearInversionInicial(InversionDTO inversionDTO);

    public List<InversionDTO> hacerRecomposicionCliente(List<InversionDTO> inversionDTOS, Long idCliente);


    public void calcularRendimientos();
}
