package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ClienteRepository
 * @date 07-05-2022
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByCedula(Long id);

    public Cliente findByCorreo(String correo);
}
