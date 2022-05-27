package com.microservicio.gestor.controller;


import com.microservicio.gestor.model.dto.Tasa_ProductoDTO;
import com.microservicio.gestor.service.ITasa_ProductoService;
import org.springframework.web.bind.annotation.*;

/**
 * Clase controlador para manejar end points de las tasas de ganancia o perdida
 * asignados a un Producto de inversión
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class Tasa_ProductoController {

    private final ITasa_ProductoService iTasa_productoService;

    /**
     * Metodo constructor
     *
     * @param iTasa_productoService
     */
    public Tasa_ProductoController(ITasa_ProductoService iTasa_productoService) {
        this.iTasa_productoService = iTasa_productoService;
    }

    /**
     * Metodo para asignar la tasa de ganancia o perdida a un producto
     *
     * @param tasa_productoDTO datos de la tasa a ser asignados
     * @return tasa asignada a su producto correspondiente
     */
    @PostMapping("/asignar/tasa/producto")
    public Tasa_ProductoDTO asignarTasaProducto(@RequestBody Tasa_ProductoDTO tasa_productoDTO) {
        return iTasa_productoService.asignarTasaProducto(tasa_productoDTO);
    }
}
