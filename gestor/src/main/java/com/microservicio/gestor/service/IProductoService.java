package com.microservicio.gestor.service;



import com.microservicio.gestor.model.dto.ProductoDTO;

import java.util.List;

/**
 * Interfaz para definir metodos del servicio de producto
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
public interface IProductoService {
    /**
     * Metodo que permite a un gestor crear un nuevo producto de inversión
     *
     * @param productoDTO datos del producto a ser creado
     * @return producto creado exitosamente
     */
    public ProductoDTO crearProducto(ProductoDTO productoDTO) ;

    /**
     * @param productoDTO
     * @return
     */
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO);

    /**
     * Metodo que permite consultar los productos pendientes por asignar tasa de un gestor
     *
     * @param idGestor id del gestor al cual se le van a consultar los productos pendientes
     * @return lista de productos pendientes por asignarles tasa el dia actual
     */
    public List<ProductoDTO> consultarProductosParaAsignarTasas(Long idGestor) ;

    /**
     * Metodo que permite listar todos el portafolio de productos de la empresa
     *
     * @return lista de productos
     */
    public List<ProductoDTO> consultarProductos();
}
