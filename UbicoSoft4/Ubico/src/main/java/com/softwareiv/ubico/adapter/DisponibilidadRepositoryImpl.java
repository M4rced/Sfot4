package com.softwareiv.ubico.adapter;

import com.softwareiv.ubico.adapter.repository.DisponibilidadRepository;
import com.softwareiv.ubico.domain.Disponibilidad;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class DisponibilidadRepositoryImpl implements DisponibilidadRepository {
    private final List<Disponibilidad> database = new ArrayList<>();
    private int currentId = 1;

    @Override
    public Disponibilidad save(Disponibilidad disponibilidad) {
        disponibilidad.setId(String.valueOf(currentId++));
        database.add(disponibilidad);
        return disponibilidad;
    }

    @Override
    public Optional<Disponibilidad> findById(String id) {
        return database.stream()
                .filter(disponibilidad -> disponibilidad.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Disponibilidad> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Disponibilidad findByAulaAndFechaAndHoraInicioAndHoraFin(String aulaId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        return database.stream()
                .filter(disponibilidad -> disponibilidad.getAula().getId().equals(aulaId)
                        && disponibilidad.getFecha().equals(fecha)
                        && disponibilidad.getHoraInicio().equals(horaInicio)
                        && disponibilidad.getHoraFin().equals(horaFin))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Disponibilidad update(Disponibilidad disponibilidad) {
        Optional<Disponibilidad> optionalDisponibilidad = database.stream()
                .filter(d -> d.getId().equals(disponibilidad.getId()))
                .findFirst();
        if (optionalDisponibilidad.isPresent()) {
            database.remove(optionalDisponibilidad.get());
            database.add(disponibilidad);
            return disponibilidad;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        database.removeIf(disponibilidad -> disponibilidad.getId().equals(id));
    }
}
