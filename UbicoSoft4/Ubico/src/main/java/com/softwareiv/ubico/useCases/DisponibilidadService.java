package com.softwareiv.ubico.useCases;

import com.softwareiv.ubico.adapter.repository.DisponibilidadRepository;
import com.softwareiv.ubico.domain.Disponibilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DisponibilidadService {
    private final DisponibilidadRepository disponibilidadRepository;

    @Autowired
    public DisponibilidadService(DisponibilidadRepository disponibilidadRepository) {
        this.disponibilidadRepository = disponibilidadRepository;
    }

    public Disponibilidad createDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    public Disponibilidad getDisponibilidadById(String id) {
        return disponibilidadRepository.findById(id);
    }

    public List<Disponibilidad> getAllDisponibilidades() {
        return disponibilidadRepository.findAll();
    }

    public Disponibilidad getDisponibilidadByAulaAndFechaAndHora(String aulaId, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        return disponibilidadRepository.findByAulaAndFechaAndHoraInicioAndHoraFin(aulaId, fecha, horaInicio, horaFin);
    }

    public Disponibilidad updateDisponibilidad(Disponibilidad disponibilidad) {
        return disponibilidadRepository.update(disponibilidad);
    }

    public void deleteDisponibilidad(String id) {
        disponibilidadRepository.deleteById(id);
    }
}
