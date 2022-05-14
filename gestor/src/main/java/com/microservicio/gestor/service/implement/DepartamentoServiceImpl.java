package com.microservicio.gestor.service.implement;

import com.microservicio.gestor.model.Departamento;
import com.microservicio.gestor.model.dto.DepartamentoDTO;
import com.microservicio.gestor.repository.DepartamentoRepository;
import com.microservicio.gestor.service.IDepartamentoService;
import com.microservicio.gestor.service.mapper.DepartamentoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de departamento donde esta toda la logica de negocio de esta entidad
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Service
public class DepartamentoServiceImpl implements IDepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;

    /**
     * Metodo constructor
     *
     * @param departamentoRepository repositorio para accerder a los metodos de jpa
     * @param departamentoMapper     mapper para pasar de dto a entidad
     */
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    /**
     * Metodo para listar los departamentos
     *
     * @return lista de departamentos
     */
    @Override
    public List<DepartamentoDTO> consultarDepartamentos() {
        return departamentoMapper.convertirListaEntidadAListaDTO(departamentoRepository.findAll());
    }
}
