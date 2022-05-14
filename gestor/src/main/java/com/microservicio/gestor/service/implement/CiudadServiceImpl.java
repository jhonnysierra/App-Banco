package com.microservicio.gestor.service.implement;

import com.microservicio.gestor.exception.excepcionpersonalizada.BadRequestException;
import com.microservicio.gestor.exception.excepcionpersonalizada.NotFoundException;
import com.microservicio.gestor.model.Ciudad;
import com.microservicio.gestor.model.dto.CiudadDTO;
import com.microservicio.gestor.repository.CiudadRepository;
import com.microservicio.gestor.service.ICiudadService;
import com.microservicio.gestor.service.mapper.CiudadMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de ciudad donde esta toda la logica de negocio de esta entidad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Service
public class CiudadServiceImpl implements ICiudadService {
    private final CiudadRepository ciudadRepository;
    private final CiudadMapper ciudadMapper;

    /**
     * Metodo contructor
     *
     * @param ciudadRepository repositorio para hacer uso de los metodos de jpa
     * @param ciudadMapper     mapper para pasar de dto a entidad
     */
    public CiudadServiceImpl(CiudadRepository ciudadRepository, CiudadMapper ciudadMapper) {
        this.ciudadRepository = ciudadRepository;
        this.ciudadMapper = ciudadMapper;
    }

    /**
     * Implemetación del metodo para consultar ciudades de un departamento
     *
     * @param idDepartamento departamento al que se le van a buscar las ciudades
     * @return lista de ciudades
     */
    @Override
    public List<CiudadDTO> consultarCiudadesDeDepartamento(Long idDepartamento) {
        if (idDepartamento == null) {
            throw new BadRequestException("departamento no valido");
        } else {
            List<Ciudad> listaCiudades = ciudadRepository.findByDepartamentoId(idDepartamento);
            if (listaCiudades.size() == 0) {
                throw new NotFoundException("Departamento no existe");
            } else {
                return ciudadMapper.convertirListaEntidadAListaDTO(listaCiudades);
            }
        }
    }

}
