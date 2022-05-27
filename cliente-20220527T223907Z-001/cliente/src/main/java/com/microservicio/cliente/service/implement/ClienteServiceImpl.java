package com.microservicio.cliente.service.implement;

import com.microservicio.cliente.exception.excepcion_personalizada.BadRequestException;
import com.microservicio.cliente.exception.excepcion_personalizada.ConflictExcepcion;
import com.microservicio.cliente.exception.excepcion_personalizada.NotFoundException;
import com.microservicio.cliente.exception.excepcion_personalizada.UnauthorizedException;
import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.dto.ClienteDTO;
import com.microservicio.cliente.repository.ClienteRepository;
import com.microservicio.cliente.service.IClienteService;
import com.microservicio.cliente.service.mapper.ClienteMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ClienteServiceImpl
 * @date 07-05-2022
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    /**
     * Metodo constructor
     *
     * @param clienteMapper
     * @param clienteRepository
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    public ClienteServiceImpl(ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Metodo que permite crear un nuevo cliente en la empresa de inversion
     *
     * @param clienteDTO objeto {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        if (clienteDTO.getCedula() != null && clienteDTO.getNombres() != null && clienteDTO.getApellidos() != null
                && clienteDTO.getCorreo() != null && clienteDTO.getContrasena() != null && clienteDTO.getCiudadId() != null) {


            Cliente cliente = clienteMapper.convertirDTOAEntidad(clienteDTO);
            cliente.setEstado('1');
            cliente.setFechaRegistro(LocalDate.now());

            if (clienteRepository.findByCedula(cliente.getCedula()) == null && clienteRepository.findByCorreo(cliente.getCorreo()) == null) {
                return clienteMapper.convertirEntidadADTO(clienteRepository.save(cliente));
            } else {
                throw new ConflictExcepcion("El correo o cedula del cliente ya se encuentra registrado");
            }

        } else {
            throw new BadRequestException("Faltan datos necesarios para crear un cliente ");
        }
    }

    /**
     * Metodo que permite consultar un cliente
     *
     * @param idCliente {idCliente}
     * @return {@link Cliente}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 07-05-2022
     */
    @Override
    public ClienteDTO consultarC(Long idCliente) {
        if (idCliente != null) {
            Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new NotFoundException("el cliente no existe"));
            return clienteMapper.convertirEntidadADTO(cliente);
        } else {
            throw new BadRequestException("cliente id no puede ser nulo");
        }
    }

    /**
     * Metodo que valida datos de acceso de un cliente
     *
     * @param clienteDTO {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 09-05-2022
     */
    @Override
    public ClienteDTO ingresarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO.getCorreo() != null || clienteDTO.getContrasena() != null) {
            Cliente clientebuscado = clienteRepository.findByCorreo(clienteDTO.getCorreo());
            if (clientebuscado != null) {
                if (clientebuscado.getCorreo().equals(clienteDTO.getCorreo()) && clientebuscado.getContrasena().equals(clienteDTO.getContrasena())) {
                    return clienteMapper.convertirEntidadADTO(clientebuscado);
                } else {
                    throw new UnauthorizedException("Datos de ingreso no validos");
                }
            } else {
                throw new NotFoundException("el cliente no existe");
            }
        } else {
            throw new BadRequestException("Faltan datos de ingreso del cliente");
        }
    }
}
