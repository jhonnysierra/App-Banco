package com.microservicio.reporte.repository;

import com.microservicio.reporte.model.Cliente;
import com.microservicio.reporte.model.dto.InversionDto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class ClienteRepository
 * @date 05-05-2022
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("    SELECT I.ID  idinversion ,P.NOMBRE  productonombre, I.SALDO  saldoactualproducto,I.FECHA_ACTIVACION  fechaactivacion,I.FECHA_FIN_PORTAFOLIO  fechafinportafolio \n" +
            "    FROM INVERSIONES I \n" +
            "    INNER JOIN PRODUCTOS P \n" +
            "    ON I.PRODUCTO_ID=P.ID\n" +
            "    WHERE I.CLIENTE_ID=:idCliente")
    public List<InversionDto> generarReporteCliente(@Param("idCliente") Long idCliente);


    @Query("SELECT DIFERENCIA_DIAS_FECHAS(:fechaActivacion,:fechaFinPortafolio) FROM DUAL")
    public int calcularDiasEntreFechas(@Param("fechaActivacion") LocalDate fechaActivacion, @Param("fechaFinPortafolio") LocalDate fechaFinPortafolio);

    @Query("SELECT CONSULTAR_SALDO_INICIAL(:idInversion,:fechaActivacion)FROM DUAL")
    public double obtenerSaldoInicial(@Param("idInversion") Long idInversion, @Param("fechaActivacion") LocalDate fechaActivacion);

}
