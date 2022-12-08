package com.macavi.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.macavi.domain.Ciudad} entity.
 */
public class CiudadDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 75)
    private String nombreCiudad;

    private DepartamentoDTO departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CiudadDTO)) {
            return false;
        }

        CiudadDTO ciudadDTO = (CiudadDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, ciudadDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CiudadDTO{" +
            "id=" + getId() +
            ", nombreCiudad='" + getNombreCiudad() + "'" +
            ", departamento=" + getDepartamento() +
            "}";
    }
}
