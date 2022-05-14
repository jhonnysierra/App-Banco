package com.microservicio.gestor.service.implement;


import com.microservicio.gestor.exception.excepcionpersonalizada.BadRequestException;
import com.microservicio.gestor.exception.excepcionpersonalizada.ConflictExcepcion;
import com.microservicio.gestor.exception.excepcionpersonalizada.NotFoundException;
import com.microservicio.gestor.model.Producto;
import com.microservicio.gestor.model.dto.GestorDTO;
import com.microservicio.gestor.model.dto.ProductoDTO;
import com.microservicio.gestor.repository.GestorRepository;
import com.microservicio.gestor.repository.ProductoRepository;
import com.microservicio.gestor.service.IProductoService;
import com.microservicio.gestor.service.mapper.ProductoMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio de producto donde esta toda la logica de negocio de esta entidad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Service
public class ProductoServiceImpl implements IProductoService {
    private final ProductoRepository productoRepository;
    private final GestorRepository gestorRepository;
    private final ProductoMapper productoMapper;

    /**
     * Metodo constructor
     *
     * @param productoRepository repositorio para consultar metodos de jpa
     * @param gestorRepository   repositorio para consultar metodos de jpa
     * @param productoMapper     mapper para pasar de dto a entidad
     */
    public ProductoServiceImpl(ProductoRepository productoRepository, GestorRepository gestorRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.gestorRepository = gestorRepository;
        this.productoMapper = productoMapper;
    }


    /**
     * Metodo que permite a un gestor crear un nuevo producto de inversión
     *
     * @param productoDTO datos del producto a ser creado
     * @return producto creado exitosamente
     */
    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        if (productoDTO.getNombre() == null || productoDTO.getGestor() == null || productoDTO.getTiempo_activacion() == 0 || productoDTO.getOrigen() == null) {
            throw new BadRequestException("Faltan datos necesarios para crear un producto");
        }
        if (productoRepository.findByNombre(productoDTO.getNombre()) != null) {
            throw new ConflictExcepcion("El nombre del producto ya existe");
        }
        if (gestorRepository.findById(productoDTO.getGestor()).isEmpty()) {
            throw new NotFoundException("El gestor de inversion no existe");
        } else {
            if (productoDTO.getCiudad() == null) {
                productoDTO.setCiudad(0L);
            }
            Producto producto = productoMapper.convertirDTOAEntidad(productoDTO);
            productoRepository.save(producto);
            return productoMapper.convertirEntidadADTO(productoRepository.save(producto));
        }
    }

    /**
     * Metodo que permite consultar los productos pendientes por asignar tasa de un gestor
     *
     * @param gestorDTO gestor al cual se le van a consultar los productos pendientes
     * @return lista de productos pendientes por asignarles tasa el dia actual
     */
    @Override
    public List<ProductoDTO> consultarProductosParaAsignarTasas(GestorDTO gestorDTO) {
        if (gestorDTO.getId() == null) {
            throw new BadRequestException("Faltan datos de gestor para consultar productos");
        }
        if (gestorRepository.findById(gestorDTO.getId()).isEmpty()) {
            throw new NotFoundException("El gestor no existe");
        } else {
            List<Producto> productosSinTasa = productoRepository.consultarProductosSinTasaAsignada(gestorDTO.getId(), LocalDate.now());
            return productoMapper.convertirListaEntidadAListaDTO(productosSinTasa);
        }
    }

    /**
     * Metodo que permite listar todos el portafolio de productos de la empresa
     *
     * @return lista de productos
     */
    @Override
    public List<ProductoDTO> consultarProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productoMapper.convertirListaEntidadAListaDTO(productos);
    }

    /**
     * @param productoDTO
     * @return
     */
    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) {
        return null;
    }
}
