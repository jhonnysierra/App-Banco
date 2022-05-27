package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class ProductoRepository
 * @date 12-05-2022
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("select p from Producto p where p.id not in (select p.id from Producto p inner join Inversion i on p.id=i.producto.id where i.fechaFinPortafolio=null and i.cliente.id=:idCliente)")
    public List<Producto> consultarProductosSinInversionCliente(@Param("idCliente") Long idCliente);
}
