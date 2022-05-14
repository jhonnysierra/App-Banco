package com.microservicio.gestor.service.implement;

import com.microservicio.gestor.exception.excepcionpersonalizada.BadRequestException;
import com.microservicio.gestor.exception.excepcionpersonalizada.ConflictExcepcion;
import com.microservicio.gestor.exception.excepcionpersonalizada.NotFoundException;
import com.microservicio.gestor.exception.excepcionpersonalizada.UnauthorizedException;
import com.microservicio.gestor.model.Gestor;
import com.microservicio.gestor.model.dto.GestorDTO;
import com.microservicio.gestor.repository.GestorRepository;
import com.microservicio.gestor.service.IGestorService;
import com.microservicio.gestor.service.mapper.GestorMapper;
import org.springframework.stereotype.Service;

/**
 * Servicio de gestor donde esta toda la logica de negocio de esta entidad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Service
public class GestorServiceImpl implements IGestorService {

    private final GestorRepository gestorRepository;
    private final GestorMapper gestorMapper;

    /**
     * Metodo constructor
     *
     * @param gestorRepository repositorio para acceder a los metodos de jpa
     * @param gestorMapper     mapper para pasar de dto a entidad
     */
    public GestorServiceImpl(GestorRepository gestorRepository, GestorMapper gestorMapper) {
        this.gestorRepository = gestorRepository;
        this.gestorMapper = gestorMapper;
    }

    /**
     * Metodo para validar los datos de ingreso de un gestor
     *
     * @param gestorDTO datos del gestor para iniciar sesion
     * @return datos del gestor
     */
    @Override
    public GestorDTO ingresarGestor(GestorDTO gestorDTO) {
        if (gestorDTO.getCorreo() == null || gestorDTO.getContrasena() == null) {
            throw new BadRequestException("Faltan datos de ingreso de gestor");
        }
        Gestor gestorBuscado = gestorRepository.findByCorreo(gestorDTO.getCorreo());
        if (gestorBuscado == null) {
            throw new NotFoundException("Gestor no existe");
        }

        if (gestorBuscado.getContrasena().equals(gestorDTO.getContrasena())) {
            return gestorMapper.convertirEntidadADTO(gestorBuscado);
        } else {
            throw new UnauthorizedException("Datos de ingreso no validos");
        }
    }

    /**
     * Metodo para registrar un nuevo gestor de inversión
     *
     * @param gestorDTO datos del nuevo gestor que va a ser registrado
     * @return gestor registrado
     */
    @Override
    public GestorDTO registrarGestor(GestorDTO gestorDTO) {
        if (gestorDTO.getCedula() == null || gestorDTO.getNombres() == null || gestorDTO.getApellidos() == null || gestorDTO.getCorreo() == null || gestorDTO.getContrasena() == null || gestorDTO.getEstado() == 0) {
            throw new BadRequestException("Faltan datos para crear getor");
        }
        Gestor gestorBuscado = gestorRepository.findByCedula(gestorDTO.getCedula());
        Gestor gestorBuscado1 = gestorRepository.findByCorreo(gestorDTO.getCorreo());
        if (gestorBuscado == null && gestorBuscado1 == null) {
            gestorBuscado = gestorMapper.convertirDTOAEntidad(gestorDTO);
            return gestorMapper.convertirEntidadADTO(gestorRepository.save(gestorBuscado));
        } else {
            throw new ConflictExcepcion("La cedula o el correo que intenta registrar ya existe");
        }
    }
}
