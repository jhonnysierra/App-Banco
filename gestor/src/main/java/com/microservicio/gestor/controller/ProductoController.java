package com.microservicio.gestor.controller;


import com.microservicio.gestor.model.dto.GestorDTO;
import com.microservicio.gestor.model.dto.ProductoDTO;
import com.microservicio.gestor.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase controlador para manejar end points de Productos de inversión
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class ProductoController {
    private final IProductoService iProductoService;

    /**
     * Metodo constructor
     *
     * @param iProductoService
     */
    public ProductoController(IProductoService iProductoService) {
        this.iProductoService = iProductoService;
    }

    /**
     * Metodo que permite a un gestor crear un nuevo producto de inversión
     *
     * @param productoDTO datos del producto a ser creado
     * @return producto creado exitosamente
     */
    @PostMapping("/crear/producto")
    public ProductoDTO crearProducto(@RequestBody ProductoDTO productoDTO) {
        return iProductoService.crearProducto(productoDTO);
    }

    /**
     * Metodo que permite listar todos el portafolio de productos de la empresa
     *
     * @return lista de productos
     */
    @GetMapping("/consultar/productos")
    public List<ProductoDTO> consultarProductos() {
        return iProductoService.consultarProductos();
    }

    /**
     * Metodo que permite consultar los productos pendientes por asignar tasa de un gestor
     *
     * @param
     * @return lista de productos pendientes por asignarles tasa el dia actual
     */
    @GetMapping("/consultar/productos/tasa/{idGestor}")
    public List<ProductoDTO> consultarProductostasaAsignada(@PathVariable Long idGestor) {
        return iProductoService.consultarProductosParaAsignarTasas(idGestor);
    }
}
