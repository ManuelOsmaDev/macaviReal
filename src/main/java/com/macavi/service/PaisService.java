package com.macavi.service;

import com.macavi.service.dto.PaisDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.macavi.domain.Pais}.
 */
public interface PaisService {
    /**
     * Save a pais.
     *
     * @param paisDTO the entity to save.
     * @return the persisted entity.
     */
    PaisDTO save(PaisDTO paisDTO);

    /**
     * Updates a pais.
     *
     * @param paisDTO the entity to update.
     * @return the persisted entity.
     */
    PaisDTO update(PaisDTO paisDTO);

    /**
     * Partially updates a pais.
     *
     * @param paisDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaisDTO> partialUpdate(PaisDTO paisDTO);

    /**
     * Get all the pais.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<PaisDTO> findAll(Pageable pageable);

    /**
     * Get the "id" pais.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaisDTO> findOne(Long id);

    /**
     * Delete the "id" pais.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
