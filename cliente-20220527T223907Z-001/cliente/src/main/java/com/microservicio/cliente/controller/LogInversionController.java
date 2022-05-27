package com.microservicio.cliente.controller;

import com.microservicio.cliente.model.dto.LogInversionDTO;
import com.microservicio.cliente.service.ILogInversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/techcamp/api/1.0")
public class LogInversionController {
    private final ILogInversionService iLogInversionService;

    public LogInversionController(ILogInversionService iLogInversionService) {
        this.iLogInversionService = iLogInversionService;
    }

    @GetMapping("/consultar/historial/inversion/{idInversion}")
    public List<LogInversionDTO> consultarMovimientosInversion(@PathVariable Long idInversion) {
        return this.iLogInversionService.consultarMovimientosInversion(idInversion);
    }
}
