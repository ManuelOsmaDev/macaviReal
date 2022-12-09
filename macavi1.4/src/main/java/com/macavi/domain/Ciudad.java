package com.macavi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Ciudad.
 */
@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 75)
    @Column(name = "nombre_ciudad", length = 75, nullable = false)
    private String nombreCiudad;

    @OneToMany(mappedBy = "locate")
    @JsonIgnoreProperties(value = { "facturas", "locate", "tipoDni" }, allowSetters = true)
    private Set<Cliente> clientes = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "ciudads", "pais" }, allowSetters = true)
    private Departamento departamento;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Ciudad id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public Ciudad nombreCiudad(String nombreCiudad) {
        this.setNombreCiudad(nombreCiudad);
        return this;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Set<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        if (this.clientes != null) {
            this.clientes.forEach(i -> i.setLocate(null));
        }
        if (clientes != null) {
            clientes.forEach(i -> i.setLocate(this));
        }
        this.clientes = clientes;
    }

    public Ciudad clientes(Set<Cliente> clientes) {
        this.setClientes(clientes);
        return this;
    }

    public Ciudad addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.setLocate(this);
        return this;
    }

    public Ciudad removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
        cliente.setLocate(null);
        return this;
    }

    public Departamento getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Ciudad departamento(Departamento departamento) {
        this.setDepartamento(departamento);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ciudad)) {
            return false;
        }
        return id != null && id.equals(((Ciudad) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Ciudad{" +
            "id=" + getId() +
            ", nombreCiudad='" + getNombreCiudad() + "'" +
            "}";
    }
}
