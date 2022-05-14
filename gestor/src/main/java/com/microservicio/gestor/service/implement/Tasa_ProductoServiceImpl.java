package com.microservicio.gestor.service.implement;


import com.microservicio.gestor.exception.excepcionpersonalizada.BadRequestException;
import com.microservicio.gestor.exception.excepcionpersonalizada.ConflictExcepcion;
import com.microservicio.gestor.exception.excepcionpersonalizada.NotFoundException;
import com.microservicio.gestor.model.Tasa_Producto;
import com.microservicio.gestor.model.dto.Tasa_ProductoDTO;
import com.microservicio.gestor.repository.ProductoRepository;
import com.microservicio.gestor.repository.Tasa_ProductoRepository;
import com.microservicio.gestor.service.ITasa_ProductoService;
import com.microservicio.gestor.service.mapper.Tasa_ProductoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Servicio de tasa producto donde esta toda la logica de negocio de esta entidad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Service
public class Tasa_ProductoServiceImpl implements ITasa_ProductoService {

    private final Tasa_ProductoRepository tasa_productoRepository;
    private final ProductoRepository productoRepository;
    private final Tasa_ProductoMapper tasa_productoMapper;

    /**
     * Metodo constructor
     *
     * @param tasa_productoRepository repositorio para consultar metodos de jpa
     * @param productoRepository      repositorio para consultar metodos de jpa
     * @param tasa_productoMapper     mapper que permite pasar dto a entidad
     */
    public Tasa_ProductoServiceImpl(Tasa_ProductoRepository tasa_productoRepository, ProductoRepository productoRepository, Tasa_ProductoMapper tasa_productoMapper) {
        this.tasa_productoRepository = tasa_productoRepository;
        this.productoRepository = productoRepository;
        this.tasa_productoMapper = tasa_productoMapper;
    }

    /**
     * Metodo para asignar la tasa de ganancia o perdida a un producto
     *
     * @param tasa_productoDTO datos de la tasa a ser asignados
     * @return tasa asignada a su producto correspondiente
     */
    @Override
    public Tasa_ProductoDTO asignarTasaProducto(Tasa_ProductoDTO tasa_productoDTO) {
        if (tasa_productoDTO.getTasa_diaria() == 0 || tasa_productoDTO.getProducto() == null) {
            throw new BadRequestException("Faltan datos para asignar tasa a un producto");
        } else if (productoRepository.findById(tasa_productoDTO.getProducto()).isEmpty()) {
            throw new NotFoundException("Producto no existe");
        } else if (tasa_productoRepository.consultarTasaPorProductoYFecha(tasa_productoDTO.getProducto(), LocalDate.now()) != null) {
            throw new ConflictExcepcion("Al producto ya se le asigno una tasa");
        } else {
            tasa_productoDTO.setFecha_dia(LocalDate.now());
            Tasa_Producto tasa_producto = tasa_productoMapper.convertirDTOAEntidad(tasa_productoDTO);
            return tasa_productoMapper.convertirEntidadADTO(tasa_productoRepository.save(tasa_producto));
        }
    }


}

