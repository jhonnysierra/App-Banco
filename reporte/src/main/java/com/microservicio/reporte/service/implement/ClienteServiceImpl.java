package com.microservicio.reporte.service.implement;

import com.microservicio.reporte.excepcion.excepcionpersonalizada.BadRequestException;
import com.microservicio.reporte.model.dto.InversionDto;
import com.microservicio.reporte.model.dto.ReporteInversionDto;
import com.microservicio.reporte.repository.ClienteRepository;
import com.microservicio.reporte.service.IClienteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
 * @project  empresa-de-inversion
 * @class ClienteServiceImpl
 * @date 05-05-2022
 * @version 1.0
 */
@Service
public class ClienteServiceImpl implements IClienteService {
    private final ClienteRepository clienteRepository;

    /**
     * Metodo constructor
     * @param clienteRepository
     */
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    /**
     * Metodo que permite generar reporte de productos del cliente
     * @param idCliente idCliente
     * @return {@link ReporteInversionDto}
     * @author <a href="julian.rivera@segurosbolivar.com"> Julian M Rivera</a>
     * @date 06-05-2022
     */
    @Override
    public List<ReporteInversionDto> generarReporteCliente(Long idCliente) {

        List<InversionDto> listaInversion = clienteRepository.generarReporteCliente(idCliente);
        List<ReporteInversionDto> listaReporte;

        if (listaInversion.size() == 0) {
            throw new BadRequestException("El cliente no existe");
        } else {
            listaReporte = new ArrayList<>();
            for (InversionDto inversion : listaInversion) {
                ReporteInversionDto reporteInversion = new ReporteInversionDto();
                if (inversion.getFechaactivacion().isAfter(LocalDate.now()) || inversion.getFechaactivacion().equals(LocalDate.now())) {
                    reporteInversion.setNombreProducto(inversion.getProductonombre());
                    reporteInversion.setDiasPermancia(0);
                    reporteInversion.setFechaInicioInversion(inversion.getFechaactivacion());
                    reporteInversion.setFechaFinInversion(null);
                    reporteInversion.setSaldoInicial(inversion.getSaldoactualproducto());
                    reporteInversion.setSaldoActual(inversion.getSaldoactualproducto());
                    if (inversion.getFechaactivacion().equals(LocalDate.now())) {
                        reporteInversion.setEstado("ACTIVO");
                    } else {
                        reporteInversion.setEstado("EN PROCESO DE ACTIVACION");
                    }
                } else {
                    reporteInversion.setNombreProducto(inversion.getProductonombre());
                    reporteInversion.setDiasPermancia(clienteRepository.calcularDiasEntreFechas(inversion.getFechaactivacion(), inversion.getFechafinportafolio()));
                    reporteInversion.setFechaInicioInversion(inversion.getFechaactivacion());
                    reporteInversion.setSaldoInicial(clienteRepository.obtenerSaldoInicial(inversion.getIdinversion(), inversion.getFechaactivacion()));
                    reporteInversion.setSaldoActual(inversion.getSaldoactualproducto());
                    if (inversion.getFechafinportafolio() == null) {
                        reporteInversion.setFechaFinInversion(null);
                        reporteInversion.setEstado("ACTIVO");
                    }
                    if (inversion.getFechafinportafolio() != null) {
                        reporteInversion.setFechaFinInversion(inversion.getFechafinportafolio());
                        reporteInversion.setEstado("INVERSION INACTIVA");
                    }
                }
                listaReporte.add(reporteInversion);
            }
        }
        return listaReporte;
    }
}
