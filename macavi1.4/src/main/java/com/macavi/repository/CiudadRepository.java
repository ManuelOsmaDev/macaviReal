package com.macavi.repository;

import com.macavi.domain.Ciudad;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Ciudad entity.
 */
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    default Optional<Ciudad> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Ciudad> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Ciudad> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct ciudad from Ciudad ciudad left join fetch ciudad.departamento",
        countQuery = "select count(distinct ciudad) from Ciudad ciudad"
    )
    Page<Ciudad> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct ciudad from Ciudad ciudad left join fetch ciudad.departamento")
    List<Ciudad> findAllWithToOneRelationships();

    @Query("select ciudad from Ciudad ciudad left join fetch ciudad.departamento where ciudad.id =:id")
    Optional<Ciudad> findOneWithToOneRelationships(@Param("id") Long id);
}
