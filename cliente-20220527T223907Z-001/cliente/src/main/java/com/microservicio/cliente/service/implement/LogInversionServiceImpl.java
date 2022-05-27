package com.microservicio.cliente.service.implement;

import com.microservicio.cliente.exception.excepcion_personalizada.NotFoundException;
import com.microservicio.cliente.model.dto.LogInversionDTO;
import com.microservicio.cliente.repository.InversionRepository;
import com.microservicio.cliente.repository.LogInversionRepository;
import com.microservicio.cliente.service.ILogInversionService;
import com.microservicio.cliente.service.mapper.LogInversionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogInversionServiceImpl implements ILogInversionService {
    private final LogInversionRepository logInversionRepository;
    private final LogInversionMapper logInversionMapper;
    private final InversionRepository inversionRepository;

    public LogInversionServiceImpl(LogInversionRepository logInversionRepository, LogInversionMapper logInversionMapper, InversionRepository inversionRepository) {
        this.logInversionRepository = logInversionRepository;
        this.logInversionMapper = logInversionMapper;
        this.inversionRepository = inversionRepository;
    }

    @Override
    public List<LogInversionDTO> consultarMovimientosInversion(Long idInversion) {
        if(!inversionRepository.findById(idInversion).isEmpty()){
          return logInversionMapper.convertirListaEntidadAListaDTO(logInversionRepository.findByInversionId(idInversion));
        }else{
            throw new NotFoundException("La inversion no existe");
        }
    }
}
