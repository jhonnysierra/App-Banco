package com.microservicio.gestor.repository;

import com.microservicio.gestor.model.Ciudad;
import com.microservicio.gestor.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de ciudad para acceder a los metodos de JpaRepository y realizar consultas
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    public List<Ciudad> findByDepartamentoId(Long id);

}
