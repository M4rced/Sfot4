package com.softwareiv.ubico.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "aulas")
public class Aula {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id = UUID.randomUUID().toString();

    @Column(name = "nombre")
    @NotNull
    @Size(max = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "bloque_id")
    @NotNull
    private Bloque bloque;

    @Column(name = "capacidad")
    @NotNull
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "tipo_aula_id")
    @NotNull
    private TipoAula tipoAula;

    @OneToOne(mappedBy = "aula")
    private Disponibilidad disponibilidad;

    public Aula() {}

    public Aula(String id, String nombre, Bloque bloque, int capacidad, TipoAula tipoAula) {
        this.id = id;
        this.nombre = nombre;
        this.bloque = bloque;
        this.capacidad = capacidad;
        this.tipoAula = tipoAula;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Bloque getBloque() {
        return bloque;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
    }
}
