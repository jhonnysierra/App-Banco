package com.microservicio.cliente.service.implement;

import com.microservicio.cliente.exception.custom.exceptions.BadRequestException;
import com.microservicio.cliente.exception.custom.exceptions.ConflictException;
import com.microservicio.cliente.exception.custom.exceptions.NotFoundException;
import com.microservicio.cliente.exception.custom.exceptions.UnauthorizedException;
import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.dto.ClienteDTO;
import com.microservicio.cliente.repository.ClienteRepository;
import com.microservicio.cliente.service.IClienteService;
import com.microservicio.cliente.service.mapper.ClienteMapper;
import com.microservicio.cliente.utilities.Config;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Clase que implementa los metodos de la interface
 */
@Service
public class ClienteServiceImpl implements IClienteService {

    /**
     * Los atributos deben ser final para que obligatoriamente se definan en el constructor.
     * Sino se definen en el constructor deben ser @Autowired
     */
    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;


    public ClienteServiceImpl(ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        if (clienteDTO.getCedula() != null && clienteDTO.getNombres() != null && clienteDTO.getApellidos() != null
                && clienteDTO.getCorreo() != null && clienteDTO.getContrasenia() != null
                && clienteDTO.getIdCiudad() != null) {
            //Se convierte el DTO a cliente
            Cliente cliente = clienteMapper.convertirDTOACliente(clienteDTO);
            cliente.setEstado('1');
            cliente.setFechaRegistro(LocalDate.now());

            if (clienteRepository.findByCedula(cliente.getCedula()) == null
                    && clienteRepository.findByCorreo(cliente.getCorreo()) == null) {
                /**
                 *
                 * El save() no se crea es parte de JPARepository. Devuelve una entidad del mismo tipo que entra.
                 * Se usa el mapper para convertir a DTO la entidad guardada
                 */
                return clienteMapper.convertirClienteADTO(clienteRepository.save(cliente));
            } else {
                throw new ConflictException("Cédula o correo ya se encuentran registrados");
            }
        } else {
            throw new BadRequestException("Algunos campos necesarios estan vacíos.");
        }
    }

    /**
     * Metodo que permite consultar un cliente
     * @param id Identificador del cliente
     * @return Objeto {@link ClienteDTO} con los datos del cliente encontrado
     */
    @Override
    public ClienteDTO consultarCliente(Long id) {
        if (id != null) {
            Cliente cliente = clienteRepository.findById(id).orElseThrow( () -> new NotFoundException("No se encontró el usuario"));
            return clienteMapper.convertirClienteADTO(cliente);
        } else {
            throw new BadRequestException("Es necesario un ID para la búsqueda");
        }
    }

    /**
     * Metodo que valida datos de acceso de un cliente
     *
     * @param clienteDTO {@link ClienteDTO}
     * @return {@link ClienteDTO}
     * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
     * @date 09-05-2022
     */
    @Override
    public ClienteDTO ingresarCliente(ClienteDTO clienteDTO) {
        if (clienteDTO.getCorreo() != null || clienteDTO.getContrasenia() != null) {
            Cliente clientebuscado = clienteRepository.findByCorreo(clienteDTO.getCorreo());
            if (clientebuscado != null) {
                if (clientebuscado.getCorreo().equals(clienteDTO.getCorreo()) && clientebuscado.getContrasenia().equals(clienteDTO.getContrasenia())) {
                    return clienteMapper.convertirClienteADTO(clientebuscado);
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
