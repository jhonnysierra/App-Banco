package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.ProductoDTO;

import java.util.List;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class IInversionService
 * @date 12-05-2022
 */
public interface IProductoService {
    /**
     * Metodo que permite consultar los productos en los que el cliente puede invertir
     * @param idCliente id del cliente
     * @return lista de {@link ProductoDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    public List<ProductoDTO> consultarProductosParaNuevaInversion(Long idCliente);
}
