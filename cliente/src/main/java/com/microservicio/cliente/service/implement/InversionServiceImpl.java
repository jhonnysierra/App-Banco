package com.microservicio.cliente.service.implement;

import com.microservicio.cliente.exception.custom.exceptions.BadRequestException;
import com.microservicio.cliente.exception.custom.exceptions.ConflictException;
import com.microservicio.cliente.exception.custom.exceptions.NotFoundException;
import com.microservicio.cliente.model.Cliente;
import com.microservicio.cliente.model.Inversion;
import com.microservicio.cliente.model.Producto;
import com.microservicio.cliente.model.dto.InversionDTO;
import com.microservicio.cliente.model.dto.MisProductosDTO;
import com.microservicio.cliente.repository.ClienteRepository;
import com.microservicio.cliente.repository.InversionRepository;
import com.microservicio.cliente.repository.ProductoRepository;
import com.microservicio.cliente.service.IInversionService;
import com.microservicio.cliente.service.mapper.InversionMapper;
import com.microservicio.cliente.utilities.Utilidades;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class InversionServiceImpl implements IInversionService {
    private final InversionRepository inversionRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final InversionMapper inversionMapper;
    private final Utilidades utilidades;

    public InversionServiceImpl(InversionRepository inversionRepository, ClienteRepository clienteRepository, ProductoRepository productoRepository, InversionMapper inversionMapper, Utilidades utilidades) {
        this.inversionRepository = inversionRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.inversionMapper = inversionMapper;
        this.utilidades = utilidades;
    }

    /**
     * Metodo que permite crear una inversion inicial al momento del primero login del cliente. Solo se ejecuta la primera vez
     * @param inversionDTO recibe un DTO con el id del cliente y el saldo inicial
     * @return DTO de la inversion realizada.
     */
    @Override
    public InversionDTO crearInversionInicial(InversionDTO inversionDTO) {
        if (inversionDTO.getIdCliente() != null && inversionDTO.getSaldo() != null) {
            if (!clienteRepository.findById(inversionDTO.getIdCliente()).isEmpty()) {
                Inversion inversion = inversionMapper.convertirDTOAInversion(inversionDTO);
                /**
                 * Se crea el produto por defecto
                 */
                Producto producto = new Producto();
                producto.setId(1L);

                /**
                 * Se asigna el producto por defecto
                 */
                inversion.setProducto(producto);

                /**
                 * Fecha de activacion del prodcuto. Se toma como la fecha del registro
                 */
                inversion.setFechaSolicitud(LocalDate.now());

                /**
                 * Calcular los días de activacion de producto y sumarlos a la fecha anterior
                 * TENER EN CUENTA LOS DIAS HABILES.
                 * Se llama la funcion que es para todos
                 */
                inversion.setFechaActivacion(inversion.getFechaSolicitud().plusDays(1));

                /**
                 * se debe validar que no exista la el mismo pruducto en la misma fecha
                 */
                return inversionMapper.convertirInversionADTO(inversionRepository.save(inversion));
            } else {
                throw new NotFoundException("El cliente no existe");
            }
        } else {
            throw new BadRequestException("Algunos campos necesarios están nulos");
        }
    }

    /**
     * Metodo que permite consultar el saldo de un cliente teniendo en cuenta
     * todos los productos en los que ha invertido y que estan activos
     * @param id Identificador del cliente
     * @return saldo total del cliente en el sistema
     */
    @Override
    public BigDecimal consultarSaldoCliente(Long id) {
        if (id != null) {
            // No se hace mapper porque es una consulta nativa
            return inversionRepository.consultarSaldo(id);
        } else {
            throw new BadRequestException("Es necesario un ID para consultar el saldo del cliente");
        }
    }

    /**
     * Metodo que permite hacer una recomposicion de los productos activos del cliente para invertir en otros.
     * @param inversionDTOS Lista DTO de inversiones
     * @param idCliente Identificador del cliente
     * @return
     */
    @Override
    @Transactional
    public List<InversionDTO> hacerRecomposicionCliente(List<InversionDTO> inversionDTOS, Long idCliente) {
        // Se valida que el DTO y el id del cliente vengan con datos
        if (inversionDTOS.size() > 0 && idCliente != null) {
            // Se busca que el id corresponda a un cliente en caso contrario se lanza una excepcion
            Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(()-> new NotFoundException("No se encuentra el cliente"));

            // Se suman los saldos de las inversiones de la recomposicion
            BigDecimal sumaSaldoInversiones = utilidades.sumarSaldoInversiones(inversionDTOS);

            // Se consulta el saldo total actual del cliente
            BigDecimal saldoCliente = inversionRepository.consultarSaldo(idCliente);

            /**
             * Se comparan los saldo para garantizar que se haga una recomposicion total del saldo del cliente
             */
            if (saldoCliente.compareTo(sumaSaldoInversiones) == 0) {
                /**
                 * Se consultan las inversiones del cliente para poner la fecha de fin de la inversion.
                 * Posteriormente se debe almacenar la nueva inversion
                 */
                List<Inversion> inversionesAnteriores = inversionRepository.consultarInversionesCliente(cliente.getId());
                for (Inversion inversion: inversionesAnteriores) {
                    inversion.setFechaFinPortafolio(LocalDate.now());
                    inversionRepository.save(inversion);
                }

                //DTO a retornar
                List<InversionDTO> inversionNuevaDTOS = new ArrayList<>();

                for (InversionDTO inversionDTO : inversionDTOS) {
                    //Se valida que el id del cliente, id producto y saldo no sean null. Estos datos son necesarios para almacenar la inversion
                    if (inversionDTO.getIdCliente() != null && inversionDTO.getIdProducto() != null && inversionDTO.getSaldo() != null) {
                        /**
                         * Se valida que los identificadores del cliente coincidan (DTO y parametro), para hacer
                         * recomposicion de los productos a un cloente especifico.
                         * Se debe tener en cuenta que el cliente ya tiene inversiones en el sistema, por eso no se realiza
                         * esta validacion en este punto. La inversion en el sistema se garantiza creando
                         * la inversion inicial del cliente.
                         */
                        if (inversionDTO.getIdCliente().compareTo(idCliente)==0){
                            Producto producto = productoRepository.findById(inversionDTO.getIdProducto()).orElseThrow(()-> new NotFoundException("No se encuentra el producto"));
                            if (inversionDTO.getSaldo().compareTo(producto.getMontoMinimo())==0 ||
                                    inversionDTO.getSaldo().compareTo(producto.getMontoMinimo())>0){

                                Inversion inversion = inversionMapper.convertirDTOAInversion(inversionDTO);

                                inversion.setFechaSolicitud(LocalDate.now());

                                // Se calcula la fecha de activacion dependiendo de los dias habiles del producto
                                inversion.setFechaActivacion(utilidades.calcularDiasHabiles(inversion.getFechaSolicitud(), producto.getTiempoActivacion()));
                                /**
                                 *  Se agregan los clientes guardados en el DTO a retornar que contiene las inversiones
                                 *  nuevas almacenadas
                                 */
                                inversionNuevaDTOS.add(inversionMapper.convertirInversionADTO(inversionRepository.save(inversion)));
                            }else{
                                throw new ConflictException
                                        ("El la cantidad invertida no coincide con el monto mínimo del producto");
                            }
                        }else{
                            throw new BadRequestException("Los identificadores del cliente no coinciden.");
                        }
                    } else {
                        throw new BadRequestException("Algunos datos necesarios no se enviaron.");
                    }
                }
                // Si no hay excepciones se retorna el DTO con las inversiones almacenadas
                return inversionNuevaDTOS;
            }else{
                throw new ConflictException("El saldo del cliente no coincide con el total de la recomposición");
            }
        } else {
            throw new BadRequestException("Algunos datos necesarios no se enviaron.");
        }
    }

    /**
     * Metodo que permite consultar las inversiones que un cliente tiene activas o por activar
     *
     * @param idCliente id del cliente a consultar
     * @return DTO con los productos que tiene el cliente
     */
    @Override
    public List<MisProductosDTO> consultarInversionesCliente(Long idCliente) {
        if (idCliente != null) {
            if (!clienteRepository.findById(idCliente).isEmpty()) {
                List<Inversion> listaInversiones = inversionRepository.consultarInversionesCliente(idCliente);
                if (listaInversiones.size() > 0) {
                    List<MisProductosDTO> listaMisProductos = inversionMapper.convertirListaEntidadAListaMisproductosDTO(listaInversiones);
                    for (MisProductosDTO misProductosDTO : listaMisProductos) {
                        if (misProductosDTO.getFechaActivacion().isAfter(LocalDate.now()) || misProductosDTO.getFechaActivacion().equals(LocalDate.now())) {
                            misProductosDTO.setEstado("EN PROCESO DE ACTIVACION");
                        } else {
                            misProductosDTO.setEstado("INVERSION ACTIVA");
                        }
                    }
                    return listaMisProductos;
                } else {
                    throw new NotFoundException("El cliente no tiene productos asociados");
                }
            } else {
                throw new NotFoundException("Cliente no existe");
            }
        } else {
            throw new BadRequestException("Id de cliente no puede ser nulo");
        }

    }

    /**
     * Metodo que permite validar si un cliente ya cumplio todos los requisitos en sus productos anteriores
     * @param idCliente id del cliente
     * @return Boolean true si cumple o false si por alguna razon no puede hacer recomposicion
     * @author <a href="jhonnysierrap@gmail.com"> Jhonny Sierra Parra</a>
     * @date 12-05-2022
     */
    @Override
    public Boolean ValidarRecomposicion(Long idCliente) {
        if (idCliente != null) {
            if (!clienteRepository.findById(idCliente).isEmpty()) {
                List<Inversion> listaInversion = inversionRepository.consultarInversionesCliente(idCliente);
                if (listaInversion.size() > 0) {
                    for (Inversion inversion : listaInversion) {
                        if (inversion.getFechaActivacion().isAfter(LocalDate.now())
                                || inversion.getFechaActivacion().equals(LocalDate.now())) {
                            return false;
                        } else {
                            Long dias = utilidades.ConsultarDiasEntreDosFechas(inversion.getFechaActivacion(), LocalDate.now());
                            System.out.println(dias);
                            if (dias < inversion.getProducto().getTiempoPermanencia()) {
                                return false;
                            }
                        }
                    }
                } else {
                    throw new NotFoundException("El cliente no tiene productos asociados");
                }
            } else {
                throw new NotFoundException("Cliente no existe");
            }
        } else {
            throw new BadRequestException("Id de cliente no puede ser nulo");
        }
        return true;
    }
}
