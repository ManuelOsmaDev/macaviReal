package com.macavi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Pais.
 */
@Entity
@Table(name = "pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 75)
    @Column(name = "nombre_pais", length = 75, nullable = false, unique = true)
    private String nombrePais;

    @OneToMany(mappedBy = "pais")
    @JsonIgnoreProperties(value = { "ciudads", "pais" }, allowSetters = true)
    private Set<Departamento> departamentos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Pais id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePais() {
        return this.nombrePais;
    }

    public Pais nombrePais(String nombrePais) {
        this.setNombrePais(nombrePais);
        return this;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Set<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    public void setDepartamentos(Set<Departamento> departamentos) {
        if (this.departamentos != null) {
            this.departamentos.forEach(i -> i.setPais(null));
        }
        if (departamentos != null) {
            departamentos.forEach(i -> i.setPais(this));
        }
        this.departamentos = departamentos;
    }

    public Pais departamentos(Set<Departamento> departamentos) {
        this.setDepartamentos(departamentos);
        return this;
    }

    public Pais addDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
        departamento.setPais(this);
        return this;
    }

    public Pais removeDepartamento(Departamento departamento) {
        this.departamentos.remove(departamento);
        departamento.setPais(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pais)) {
            return false;
        }
        return id != null && id.equals(((Pais) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Pais{" +
            "id=" + getId() +
            ", nombrePais='" + getNombrePais() + "'" +
            "}";
    }
}
