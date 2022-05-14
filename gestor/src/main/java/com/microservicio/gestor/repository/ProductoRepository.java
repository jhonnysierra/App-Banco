package com.microservicio.gestor.repository;

import com.microservicio.gestor.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio de producto para acceder a los metodos de JpaRepository y realizar consultas
 *
 * @author: Julian Mauricio Rivera
 * @version: v1.0
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public Producto findByNombre(String nombre);

    @Query("select p from Producto p where p.id not in (select p.id from Producto p left join Tasa_Producto tp on p.id=tp.producto.id where tp.fecha_dia=:fechaDia and p.gestor.id=:gestor) and p.gestor.id=:gestor")
    public List<Producto> consultarProductosSinTasaAsignada(@Param("gestor") Long gestor, @Param("fechaDia") LocalDate fechaDia);


}
