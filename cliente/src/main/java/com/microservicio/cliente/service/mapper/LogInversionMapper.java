package com.microservicio.cliente.service.mapper;


import com.microservicio.cliente.model.LogInversion;
import com.microservicio.cliente.model.dto.LogInversionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface LogInversionMapper {

    @Mapping(source = "logInversionDTO.inversion",target = "inversion.id")
    public LogInversion convertirDTOAEntidad(LogInversionDTO logInversionDTO);

    @Mapping(source = "logInversion.inversion.id",target = "inversion")
    public LogInversionDTO convertirEntidadADTO(LogInversion logInversion);

    public List<LogInversionDTO> convertirListaEntidadAListaDTO(List<LogInversion> listaLogInversionDTO);

    public List<LogInversion> convertirListaDTOAListaEntidad(List<LogInversionDTO> listaInversionDTO);
}
