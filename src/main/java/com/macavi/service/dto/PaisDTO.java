package com.macavi.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.macavi.domain.Pais} entity.
 */
public class PaisDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 75)
    private String nombrePais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaisDTO)) {
            return false;
        }

        PaisDTO paisDTO = (PaisDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, paisDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaisDTO{" +
            "id=" + getId() +
            ", nombrePais='" + getNombrePais() + "'" +
            "}";
    }
}
