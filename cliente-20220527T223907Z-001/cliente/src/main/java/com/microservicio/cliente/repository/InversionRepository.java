package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.Inversion;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
/**
 * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @version 1.0
 * @project empresa-de-inversion
 * @class InversionRepository
 * @date 12-05-2022
 */
@Repository
public interface InversionRepository extends CrudRepository<Inversion, Long> {

    @Query(value = "select i from Inversion i inner join Producto p on i.producto=p.id where i.cliente.id=:idCliente and i.fechaFinPortafolio=null")
    public List<Inversion> consultarInversionesCliente(@Param("idCliente") Long idCliente);

    @Query(value = "select SUM(i.saldo)  from Inversion i where i.cliente.id=:idCliente and i.fechaFinPortafolio=null")
    public BigDecimal calcularSaldoCliente(@Param("idCliente") Long idCliente);

    /**
     * Consulta que permite saber el saldo inicial de una inversion
     *
     * @param idInversion Identificador de la inversion
     * @param fechaActivacion Fecha de activacion de la inversion
     * @return Valor inicial invertido
     */
   // @Query(value = "SELECT CONSULTAR_SALDO_INICIAL(:idInversion,:fechaActivacion) FROM DUAL", nativeQuery = true)
    @Query(value = "SELECT PKG_REPORTE.FUNC_CONSULTAR_SALDO_INICIAL(:idInversion,:fechaActivacion) FROM DUAL", nativeQuery = true)
    public BigDecimal obtenerSaldoInicial(@Param("idInversion") Long idInversion, @Param("fechaActivacion") LocalDate fechaActivacion);


   // @Modifying
    //@Query(value = "CALL funcionalidades.calcular_rendimiento(1)",nativeQuery = true)
   // @Query(value = "CALL CALCULAR_RENDIMIENTO()",nativeQuery = true)
    // int procedimientoPrueba();


    @Modifying
    @Query(value = "CALL PKG_RENDIMIENTO.CALCULAR_RENDIMIENTO()",nativeQuery = true)
    void procedimientoPrueba();

}
