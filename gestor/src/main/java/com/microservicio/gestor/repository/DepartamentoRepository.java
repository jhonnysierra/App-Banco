package com.microservicio.gestor.repository;

import com.microservicio.gestor.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de departamento para acceder a los metodos de JpaRepository y realizar consultas
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
