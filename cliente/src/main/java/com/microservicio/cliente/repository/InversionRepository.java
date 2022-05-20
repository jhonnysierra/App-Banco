package com.microservicio.cliente.repository;

import com.microservicio.cliente.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Long> {

    @Query(value = "SELECT SUM(i.saldo) FROM Inversion i " +
            "WHERE i.cliente.id=:idCliente AND i.fechaFinPortafolio=null")
    public BigDecimal consultarSaldo(@Param("idCliente") Long idCliente);

    /**
     * Consulta que trae las inversiones activas del cliente
     *
     * @param idCliente Identificador del cliente
     * @return Lista con las inversiones del cliente
     */
    @Query(value = "select i from Inversion i inner join Producto p on i.producto=p.id " +
            "where i.cliente.id=:idCliente and i.fechaFinPortafolio=null")
    public List<Inversion> consultarInversionesCliente(@Param("idCliente") Long idCliente);

    /**
     * Consulta que permite saber el saldo inicial de una inversion
     *
     * @param idInversion Identificador de la inversion
     * @param fechaActivacion Fecha de activacion de la inversion
     * @return Valor inicial invertido
     */
    @Query(value = "SELECT CONSULTAR_SALDO_INICIAL(:idInversion,:fechaActivacion) FROM DUAL", nativeQuery = true)
    public BigDecimal obtenerSaldoInicial(@Param("idInversion") Long idInversion, @Param("fechaActivacion") LocalDate fechaActivacion);

    //HACER ESTA GRAN PERRA CON NATIVE QUERY
    /*
    @Query(value = "SELECT SUM(i.saldo) FROM Inversion i " +
            "WHERE i.cliente.id=:idCliente AND i.fechaFinPortafolio=null")
            //SELECT i.saldo FROM inversiones i WHERE i.cliente_id=1 AND i.fecha_fin_portafolio IS NULL
    public BigDecimal consultarSaldo(@Param("idCliente") Long idCliente);
    */

}
