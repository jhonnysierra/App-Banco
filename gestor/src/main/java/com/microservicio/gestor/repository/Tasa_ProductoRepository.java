package com.microservicio.gestor.repository;

import com.microservicio.gestor.model.Tasa_Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Repositorio de tasa producto para acceder a los metodos de JpaRepository y realizar consultas
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Repository
public interface Tasa_ProductoRepository extends JpaRepository<Tasa_Producto, Long> {

    @Query("select tp from Tasa_Producto tp where tp.producto.id=:id and tp.fecha_dia=:fecha")
    public Tasa_Producto consultarTasaPorProductoYFecha(@Param("id") Long id, @Param("fecha") LocalDate fecha);

    @Query("SELECT avg(t.tasa_diaria) from Tasa_Producto t WHERE t.producto.id=:idProducto ")
    public BigDecimal consultarPromedioTasaProducto(@Param("idProducto") Long idProducto);

}
