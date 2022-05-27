package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Expone los metodos para hacer CRUD en la base de datos entre otros generados
 * <Clase sobre la que se hará CRUD, llave primaria>
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    /**
     * Si se usa findByNombreAtributo JPA busca por el atributo en la DB
     * Los tipos deben coincidir con los de la entidad y el return debe ser del mismo tipo de la Entidad
     */

    /**
     * Permite buscar una cedula en la tabla cliente
     * @param id Identificador a buscar.
     * @return Entidad encontrada. En caso contrario null.
     */
    public Cliente findByCedula(Long id);

    /**
     * Permite buscar un cliente por correo electronico
     * @param correo Correo electronico del cliente a buscar
     * @return Objeto de la clase {@link Cliente}
     */
    public Cliente findByCorreo(String correo);
}
