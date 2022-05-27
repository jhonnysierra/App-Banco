package com.microservicio.cliente.utilities;

import com.microservicio.cliente.model.dto.InversionDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class Utilidades {

    public Long ConsultarDiasEntreDosFechas(LocalDate fechaIncial, LocalDate fechaFinal) {
        Long dias = ChronoUnit.DAYS.between(fechaIncial, fechaFinal);
        return dias;
    }

    public LocalDate calcularDiasHabiles(LocalDate fechaInicial, int diasHabiles) {

        List<LocalDate> diasFestivos = new ArrayList<LocalDate>() {{
            add(LocalDate.parse("2022-01-10"));
            add(LocalDate.parse("2022-03-21"));
            add(LocalDate.parse("2022-04-14"));
            add(LocalDate.parse("2022-04-15"));
            add(LocalDate.parse("2022-05-30"));
            add(LocalDate.parse("2022-06-20"));
            add(LocalDate.parse("2022-06-27"));
            add(LocalDate.parse("2022-07-04"));
            add(LocalDate.parse("2022-07-20"));
            add(LocalDate.parse("2022-08-15"));
            add(LocalDate.parse("2022-10-17"));
            add(LocalDate.parse("2022-11-07"));
            add(LocalDate.parse("2022-11-14"));
            add(LocalDate.parse("2022-12-08"));
        }};

        int dias = diasHabiles;
        boolean bandera=false;
        boolean bandera2=false;
        int i = 0;
        while (i < dias) {

            if (fechaInicial.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                fechaInicial = fechaInicial.plusDays(1);
                bandera=true;
                continue;
            } else if (fechaInicial.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                fechaInicial = fechaInicial.plusDays(1);
                bandera=true;
                continue;
            } else if (!(fechaInicial.getDayOfWeek().equals(DayOfWeek.SATURDAY)) || !(fechaInicial.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {

                if(diasFestivos.contains(fechaInicial)){
                    fechaInicial = fechaInicial.plusDays(1);
                    bandera=true;
                    continue;
                }
                if(bandera==false){
                    fechaInicial = fechaInicial.plusDays(1);
                    bandera=true;
                    continue;
                }
                if(bandera2==false){
                    fechaInicial = fechaInicial.plusDays(1);
                    i++;
                }else{
                    i++;
                }
                if(i==(dias) && ((fechaInicial.getDayOfWeek().equals(DayOfWeek.SATURDAY)) || (fechaInicial.getDayOfWeek().equals(DayOfWeek.SUNDAY)) || diasFestivos.contains(fechaInicial))){
                    i--;
                    bandera2=true;
                }



            }
        }
        return fechaInicial;
    }

    /**
     * Metodo que permite sumar los saldos de las inversiones que se reciben.
     *
     * @param inversionDTOS Lista de las inversiones DTO
     * @return suma de los saldos de las inversiones ingresadas
     */
    public BigDecimal sumarSaldoInversiones(List<InversionDTO> inversionDTOS) {
        BigDecimal sumaSaldoInversiones = new BigDecimal(0);

        for (InversionDTO inversionDTO : inversionDTOS) {
            sumaSaldoInversiones = sumaSaldoInversiones.add(inversionDTO.getSaldo());
        }

        return sumaSaldoInversiones;
    }
}
