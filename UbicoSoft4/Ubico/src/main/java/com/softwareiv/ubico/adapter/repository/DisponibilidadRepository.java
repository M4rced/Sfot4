package com.softwareiv.ubico.adapter.repository;

import com.softwareiv.ubico.domain.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, String> {
    Disponibilidad save(Disponibilidad disponibilidad);
    Optional<Disponibilidad> findById(String id);
    List<Disponibilidad> findAll();
    Disponibilidad findByAulaAndFechaAndHoraInicioAndHoraFin(String aulaId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin);
    Disponibilidad update(Disponibilidad disponibilidad);


}
