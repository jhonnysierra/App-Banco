package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IInversionService {
    /**
     * Metodo que permite consultar las inversiones del cliente
     *
     * @param idCliente id del cliente a consultar
     * @return lista de {@link MisProductosDTO}
     *  @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra P</a>
     * @date 12-05-2022
     */
    public List<MisProductosDTO> consultarInversionesCliente(Long idCliente);

    /**
     * Metodo que permite validar si un cliente puede realizar una recomposicion
     *
     * @param idCliente Identificador del cliente
     * @return True si puede realizar la recomposicion y false en caso contrario
     */
    public Boolean validarRecomposicion(Long idCliente);

    /**
     *  Metodo que permite consultar el saldo de un cliente teniendo en cuenta
     *  todos los productos en los que ha invertido y que estan activos
     * @param id Identificador del cliente
     * @return saldo total del cliente en el sistema
     */
    public BigDecimal consultarSaldoCliente(Long id);

    /**
     * Metodo que permite crear la inversion incial a la que se deposita el dinero
     * @param inversionDTO recibe un DTO con el id del cliente y el saldo inicial {@link InversionDTO}
     * @return DTO de Inversion con lo datos almacenados
     */
    public InversionDTO crearInversionInicial(InversionDTO inversionDTO);

    /**
     * Metodo que permite hacer la recomposicion de un cliente
     *
     * @param inversionDTOS
     * @param idCliente
     * @return
     */
    public List<InversionDTO> hacerRecomposicionCliente(List<InversionDTO> inversionDTOS, Long idCliente);

    /**
     * Metodo que permite ejecutar el procedimiento almacenado para calcular los rendimientos
     */
    public void calcularRendimientos();
}
