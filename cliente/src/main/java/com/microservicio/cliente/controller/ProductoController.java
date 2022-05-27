package com.microservicio.cliente.controller;

import com.microservicio.cliente.model.dto.ProductoDTO;
import com.microservicio.cliente.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra P</a>
 * @version 1.0
 * @class ProductoController
 * @date 12-05-2022
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class ProductoController {
    private final IProductoService iProductoService;

    /**
     * Metodo constructor
     * @param iProductoService
     */
    public ProductoController(IProductoService iProductoService) {
        this.iProductoService = iProductoService;
    }

    /**
     * Metodo que permite consultar los productos en los que el cliente puede invertir
     * @param idCliente id del cliente
     * @return lista de {@link ProductoDTO}
     * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
     * @date 12-05-2022
     */
    @GetMapping("/productos/nueva/inversion/{idCliente}")
    public List<ProductoDTO> consultarProductosParaNuevaInversion(@PathVariable Long idCliente) {
        return iProductoService.consultarProductosParaNuevaInversion(idCliente);
    }
}