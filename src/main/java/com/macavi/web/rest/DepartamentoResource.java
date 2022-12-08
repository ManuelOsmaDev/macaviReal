package com.macavi.web.rest;

import com.macavi.repository.DepartamentoRepository;
import com.macavi.service.DepartamentoService;
import com.macavi.service.dto.DepartamentoDTO;
import com.macavi.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.macavi.domain.Departamento}.
 */
@RestController
@RequestMapping("/api")
public class DepartamentoResource {

    private final Logger log = LoggerFactory.getLogger(DepartamentoResource.class);

    private static final String ENTITY_NAME = "departamento";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DepartamentoService departamentoService;

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoResource(DepartamentoService departamentoService, DepartamentoRepository departamentoRepository) {
        this.departamentoService = departamentoService;
        this.departamentoRepository = departamentoRepository;
    }

    /**
     * {@code POST  /departamentos} : Create a new departamento.
     *
     * @param departamentoDTO the departamentoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new departamentoDTO, or with status {@code 400 (Bad Request)} if the departamento has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/departamentos")
    public ResponseEntity<DepartamentoDTO> createDepartamento(@Valid @RequestBody DepartamentoDTO departamentoDTO)
        throws URISyntaxException {
        log.debug("REST request to save Departamento : {}", departamentoDTO);
        if (departamentoDTO.getId() != null) {
            throw new BadRequestAlertException("A new departamento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DepartamentoDTO result = departamentoService.save(departamentoDTO);
        return ResponseEntity
            .created(new URI("/api/departamentos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /departamentos/:id} : Updates an existing departamento.
     *
     * @param id the id of the departamentoDTO to save.
     * @param departamentoDTO the departamentoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated departamentoDTO,
     * or with status {@code 400 (Bad Request)} if the departamentoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the departamentoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/departamentos/{id}")
    public ResponseEntity<DepartamentoDTO> updateDepartamento(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody DepartamentoDTO departamentoDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Departamento : {}, {}", id, departamentoDTO);
        if (departamentoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, departamentoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!departamentoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        DepartamentoDTO result = departamentoService.update(departamentoDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, departamentoDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /departamentos/:id} : Partial updates given fields of an existing departamento, field will ignore if it is null
     *
     * @param id the id of the departamentoDTO to save.
     * @param departamentoDTO the departamentoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated departamentoDTO,
     * or with status {@code 400 (Bad Request)} if the departamentoDTO is not valid,
     * or with status {@code 404 (Not Found)} if the departamentoDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the departamentoDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/departamentos/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<DepartamentoDTO> partialUpdateDepartamento(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody DepartamentoDTO departamentoDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Departamento partially : {}, {}", id, departamentoDTO);
        if (departamentoDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, departamentoDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!departamentoRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<DepartamentoDTO> result = departamentoService.partialUpdate(departamentoDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, departamentoDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /departamentos} : get all the departamentos.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of departamentos in body.
     */
    @GetMapping("/departamentos")
    public ResponseEntity<List<DepartamentoDTO>> getAllDepartamentos(
        @org.springdoc.api.annotations.ParameterObject Pageable pageable,
        @RequestParam(required = false, defaultValue = "true") boolean eagerload
    ) {
        log.debug("REST request to get a page of Departamentos");
        Page<DepartamentoDTO> page;
        if (eagerload) {
            page = departamentoService.findAllWithEagerRelationships(pageable);
        } else {
            page = departamentoService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /departamentos/:id} : get the "id" departamento.
     *
     * @param id the id of the departamentoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the departamentoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/departamentos/{id}")
    public ResponseEntity<DepartamentoDTO> getDepartamento(@PathVariable Long id) {
        log.debug("REST request to get Departamento : {}", id);
        Optional<DepartamentoDTO> departamentoDTO = departamentoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(departamentoDTO);
    }

    /**
     * {@code DELETE  /departamentos/:id} : delete the "id" departamento.
     *
     * @param id the id of the departamentoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/departamentos/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id) {
        log.debug("REST request to delete Departamento : {}", id);
        departamentoService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
