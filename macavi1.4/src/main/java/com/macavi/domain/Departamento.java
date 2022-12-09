package com.macavi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Departamento.
 */
@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 75)
    @Column(name = "nombre_departamento", length = 75, nullable = false)
    private String nombreDepartamento;

    @OneToMany(mappedBy = "departamento")
    @JsonIgnoreProperties(value = { "clientes", "departamento" }, allowSetters = true)
    private Set<Ciudad> ciudads = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "departamentos" }, allowSetters = true)
    private Pais pais;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Departamento id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }

    public Departamento nombreDepartamento(String nombreDepartamento) {
        this.setNombreDepartamento(nombreDepartamento);
        return this;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Set<Ciudad> getCiudads() {
        return this.ciudads;
    }

    public void setCiudads(Set<Ciudad> ciudads) {
        if (this.ciudads != null) {
            this.ciudads.forEach(i -> i.setDepartamento(null));
        }
        if (ciudads != null) {
            ciudads.forEach(i -> i.setDepartamento(this));
        }
        this.ciudads = ciudads;
    }

    public Departamento ciudads(Set<Ciudad> ciudads) {
        this.setCiudads(ciudads);
        return this;
    }

    public Departamento addCiudad(Ciudad ciudad) {
        this.ciudads.add(ciudad);
        ciudad.setDepartamento(this);
        return this;
    }

    public Departamento removeCiudad(Ciudad ciudad) {
        this.ciudads.remove(ciudad);
        ciudad.setDepartamento(null);
        return this;
    }

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Departamento pais(Pais pais) {
        this.setPais(pais);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Departamento)) {
            return false;
        }
        return id != null && id.equals(((Departamento) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Departamento{" +
            "id=" + getId() +
            ", nombreDepartamento='" + getNombreDepartamento() + "'" +
            "}";
    }
}
