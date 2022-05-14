package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IInversionService {
    /**
     * Metodo que permite crear la inversion incial a la que se deposita el dinero
     * @param inversionDTO recibe un DTO con el id del cliente y el saldo inicial {@link InversionDTO}
     * @return DTO de Inversion con lo datos almacenados
     */
    public InversionDTO crearInversionInicial(InversionDTO inversionDTO);

    /**
     *  Metodo que permite consultar el saldo de un cliente teniendo en cuenta
     *  todos los productos en los que ha invertido y que estan activos
     * @param id Identificador del cliente
     * @return saldo total del cliente en el sistema
     */
    public BigDecimal consultarSaldoCliente(Long id);

    public List<InversionDTO> hacerRecomposicionCliente(List<InversionDTO> inversionDTOS, Long idCliente);

    /**
     * Metodo que permite consultar las inversiones del cliente
     * @param idCliente id del cliente a consultar
     * @return lista de {@link MisProductosDTO}
     *  @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    public List<MisProductosDTO> consultarInversionesCliente(Long idCliente);

    /**
     *
     * @param idCliente
     * @return
     */
    public Boolean ValidarRecomposicion(Long idCliente);
}
