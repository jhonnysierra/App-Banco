package com.microservicio.gestor.service;


import com.microservicio.gestor.model.dto.Tasa_ProductoDTO;

/**
 * Interfaz para definir metodos del servicio de tasa producto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
public interface ITasa_ProductoService {
    /**
     * Metodo para asignar la tasa de ganancia o perdida a un producto
     *
     * @param tasa_productoDTO datos de la tasa a ser asignados
     * @return tasa asignada a su producto correspondiente
     */
    public Tasa_ProductoDTO asignarTasaProducto(Tasa_ProductoDTO tasa_productoDTO);


}
