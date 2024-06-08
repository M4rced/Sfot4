package com.softwareiv.ubico.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "aulas_id")
    @NotNull
    private Aula aulas;

    @Column(name = "fecha")
    @NotNull
    private LocalDate fecha;

    @Column(name = "hora_inicio")
    @NotNull
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    @NotNull
    private LocalTime horaFin;

    public Disponibilidad(String id, Aula aula, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.aulas = aulas;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Disponibilidad() {

    }

    public String getId() {
        return id;
    }

    public Aula getAula() {
        return aulas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAula(Aula aula) {
        this.aulas = aula;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
