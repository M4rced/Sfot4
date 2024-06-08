package com.softwareiv.ubico.domain;

import com.softwareiv.ubico.domain.enums.Periodicidad;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "aula_id")
    @NotNull
    private Aula aula;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull
    private User user;

    @Column(name = "fecha_inicio_reserva")
    @NotNull
    private LocalDate fechaInicioReserva;

    @Column(name = "fecha_fin_reserva")
    @NotNull
    private LocalDate fechaFinReserva;

    @Column(name = "hora_inicio")
    @NotNull
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    @NotNull
    private LocalTime horaFin;

    @Column(name = "periodicidad")
    @Size(max = 50)
    private Periodicidad periodicidad;

    @Column(name = "observacion")
    @Size(max = 255)
    private String observacion;

    public Reserva() {}

    public Reserva(String id, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, LocalTime horaInicio, LocalTime horaFin,
                   Aula aula, User user, Periodicidad periodicidad, String observacion) {
        this.id = id;
        this.fechaInicioReserva = fechaInicioReserva;
        this.fechaFinReserva = fechaFinReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
        this.user = user;
        this.periodicidad = periodicidad;
        this.observacion = observacion;
    }

    public String getId() {
        return id;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public Aula getAula() {
        return aula;
    }

    public User getUser() {
        return user;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        this.fechaFinReserva = fechaFinReserva;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
