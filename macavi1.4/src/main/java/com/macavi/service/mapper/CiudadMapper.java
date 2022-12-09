package com.macavi.service.mapper;

import com.macavi.domain.Ciudad;
import com.macavi.domain.Departamento;
import com.macavi.service.dto.CiudadDTO;
import com.macavi.service.dto.DepartamentoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ciudad} and its DTO {@link CiudadDTO}.
 */
@Mapper(componentModel = "spring")
public interface CiudadMapper extends EntityMapper<CiudadDTO, Ciudad> {
    @Mapping(target = "departamento", source = "departamento", qualifiedByName = "departamentoNombreDepartamento")
    CiudadDTO toDto(Ciudad s);

    @Named("departamentoNombreDepartamento")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombreDepartamento", source = "nombreDepartamento")
    DepartamentoDTO toDtoDepartamentoNombreDepartamento(Departamento departamento);
}
