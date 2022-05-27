package com.microservicio.cliente.service;

import com.microservicio.cliente.model.dto.LogInversionDTO;

import java.util.List;

public interface ILogInversionService {

    List<LogInversionDTO> consultarMovimientosInversion(Long idInversion);
}
