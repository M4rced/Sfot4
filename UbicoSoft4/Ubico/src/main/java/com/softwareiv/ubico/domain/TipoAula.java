package com.softwareiv.ubico.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "tipoAulas")
public class TipoAula {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id = UUID.randomUUID().toString();

    @Column(name = "nombre_tipo_aula")
    @NotNull
    @Size(max = 100)
    private String nombreTipoAula;

    public TipoAula() {}

    public TipoAula(String id, String nombreTipoAula) {
        this.id = id;
        this.nombreTipoAula = nombreTipoAula;
    }

    public String getId() {
        return id;
    }

    public String getNombreTipoAula() {
        return nombreTipoAula;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreTipoAula(String nombreTipoAula) {
        this.nombreTipoAula = nombreTipoAula;
    }
}
