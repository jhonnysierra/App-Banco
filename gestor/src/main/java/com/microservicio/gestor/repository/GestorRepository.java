package com.microservicio.gestor.repository;


import com.microservicio.gestor.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio de gestor para acceder a los metodos de JpaRepository y realizar consultas
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Repository
public interface GestorRepository extends JpaRepository<Gestor,Long> {

    public Gestor findByCorreo(String correo);

    public Gestor findByCedula(Long cedula);
}
