package com.microservicio.cliente.service.implement;

import com.microservicio.cliente.exception.custom.exceptions.BadRequestException;
import com.microservicio.cliente.exception.custom.exceptions.NotFoundException;
import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.Producto;
import com.microservicio.cliente.model.dto.ProductoDTO;
import com.microservicio.cliente.repository.ClienteRepository;
import com.microservicio.cliente.repository.InversionRepository;
import com.microservicio.cliente.repository.ProductoRepository;
import com.microservicio.cliente.service.IProductoService;
import com.microservicio.cliente.service.mapper.ProductoMapper;
import com.microservicio.cliente.utilities.Utilidades;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project ProductoServiceImpl
 * @class IInversionService
 * @date 12-05-2022
 */
@Service
public class ProductoServiceImpl implements IProductoService {
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final InversionRepository inversionRepository;
    private final Utilidades utilidades;
    private final ProductoMapper productoMapper;

    /**
     * Metodo constructor
     *
     * @param clienteRepository
     * @param productoRepository
     * @param utilidades
     * @param inversionRepository
     * @param productoMapper
     */
    public ProductoServiceImpl(ClienteRepository clienteRepository, ProductoRepository productoRepository, Utilidades utilidades, InversionRepository inversionRepository, ProductoMapper productoMapper) {
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.utilidades = utilidades;
        this.inversionRepository = inversionRepository;
        this.productoMapper = productoMapper;
    }

    /**
     * Metodo que permite consultar los productos en los que el cliente puede invertir
     *
     * @param idCliente id del cliente
     * @return lista de {@link ProductoDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 12-05-2022
     */
    @Override
    public List<ProductoDTO> consultarProductosParaNuevaInversion(Long idCliente) {
        List<ProductoDTO> listaProductoCliente;
        if (idCliente != null) {
            Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new NotFoundException("Cliente no existe"));
            List<Producto> listaProductos = productoRepository.consultarProductosSinInversionCliente(idCliente);
            listaProductoCliente = new ArrayList<>();
            for (Producto producto : listaProductos) {
                if (utilidades.ConsultarDiasEntreDosFechas(cliente.getFechaRegistro(), LocalDate.now()) >= producto.getTiempoCompania()) {

                    if (inversionRepository.consultarSaldo(idCliente).compareTo(producto.getMontoCompania()) == 1
                            || inversionRepository.consultarSaldo(idCliente).compareTo(producto.getMontoCompania()) == 0) {
                        if (producto.getCiudad().getId() == 2) {
                            listaProductoCliente.add(productoMapper.convertirEntidadADTO(producto));
                        }
                    }
                }
            }
        } else {
            throw new BadRequestException("Id de cliente no puede ser nulo");
        }
        return listaProductoCliente;
    }
}
