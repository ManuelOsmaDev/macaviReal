package com.macavi.service.mapper;

import com.macavi.domain.Departamento;
import com.macavi.domain.Pais;
import com.macavi.service.dto.DepartamentoDTO;
import com.macavi.service.dto.PaisDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Departamento} and its DTO {@link DepartamentoDTO}.
 */
@Mapper(componentModel = "spring")
public interface DepartamentoMapper extends EntityMapper<DepartamentoDTO, Departamento> {
    @Mapping(target = "pais", source = "pais", qualifiedByName = "paisNombrePais")
    DepartamentoDTO toDto(Departamento s);

    @Named("paisNombrePais")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombrePais", source = "nombrePais")
    PaisDTO toDtoPaisNombrePais(Pais pais);
}
