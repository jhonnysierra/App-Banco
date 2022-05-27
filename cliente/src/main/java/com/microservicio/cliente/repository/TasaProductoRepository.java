package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.TasaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TasaProductoRepository extends JpaRepository<TasaProducto,Long> {

    @Query("SELECT avg(t.tasaDiaria) from TasaProducto t WHERE t.producto.id=:idProducto ")
    public BigDecimal consultarPromedioTasaProducto(@Param("idProducto") Long idProducto);

}
