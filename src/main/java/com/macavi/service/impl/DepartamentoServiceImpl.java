package com.macavi.service.impl;

import com.macavi.domain.Departamento;
import com.macavi.repository.DepartamentoRepository;
import com.macavi.service.DepartamentoService;
import com.macavi.service.dto.DepartamentoDTO;
import com.macavi.service.mapper.DepartamentoMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Departamento}.
 */
@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    private final Logger log = LoggerFactory.getLogger(DepartamentoServiceImpl.class);

    private final DepartamentoRepository departamentoRepository;

    private final DepartamentoMapper departamentoMapper;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, DepartamentoMapper departamentoMapper) {
        this.departamentoRepository = departamentoRepository;
        this.departamentoMapper = departamentoMapper;
    }

    @Override
    public DepartamentoDTO save(DepartamentoDTO departamentoDTO) {
        log.debug("Request to save Departamento : {}", departamentoDTO);
        Departamento departamento = departamentoMapper.toEntity(departamentoDTO);
        departamento = departamentoRepository.save(departamento);
        return departamentoMapper.toDto(departamento);
    }

    @Override
    public DepartamentoDTO update(DepartamentoDTO departamentoDTO) {
        log.debug("Request to save Departamento : {}", departamentoDTO);
        Departamento departamento = departamentoMapper.toEntity(departamentoDTO);
        departamento = departamentoRepository.save(departamento);
        return departamentoMapper.toDto(departamento);
    }

    @Override
    public Optional<DepartamentoDTO> partialUpdate(DepartamentoDTO departamentoDTO) {
        log.debug("Request to partially update Departamento : {}", departamentoDTO);

        return departamentoRepository
            .findById(departamentoDTO.getId())
            .map(existingDepartamento -> {
                departamentoMapper.partialUpdate(existingDepartamento, departamentoDTO);

                return existingDepartamento;
            })
            .map(departamentoRepository::save)
            .map(departamentoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DepartamentoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Departamentos");
        return departamentoRepository.findAll(pageable).map(departamentoMapper::toDto);
    }

    public Page<DepartamentoDTO> findAllWithEagerRelationships(Pageable pageable) {
        return departamentoRepository.findAllWithEagerRelationships(pageable).map(departamentoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DepartamentoDTO> findOne(Long id) {
        log.debug("Request to get Departamento : {}", id);
        return departamentoRepository.findOneWithEagerRelationships(id).map(departamentoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Departamento : {}", id);
        departamentoRepository.deleteById(id);
    }
}
