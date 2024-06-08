package com.softwareiv.ubico.useCases;

import com.softwareiv.ubico.adapter.repository.DisponibilidadRepository;
import com.softwareiv.ubico.adapter.repository.ReservaRepository;
import com.softwareiv.ubico.domain.Disponibilidad;
import com.softwareiv.ubico.domain.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final DisponibilidadRepository disponibilidadRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, DisponibilidadRepository disponibilidadRepository) {
        this.reservaRepository = reservaRepository;
        this.disponibilidadRepository = disponibilidadRepository;
    }

    public Reserva createReserva(Reserva reserva) {
        Disponibilidad disponibilidad = disponibilidadRepository.findByAulaAndFechaAndHoraInicioAndHoraFin(
                reserva.getAula().getId(),
                reserva.getFechaInicioReserva(),
                reserva.getHoraInicio(),
                reserva.getHoraFin()
        );

        if (disponibilidad == null) {
            throw new IllegalArgumentException("No hay disponibilidad para esta aula en el horario solicitado.");
        }

        return reservaRepository.save(reserva);
    }

    public Reserva getReservaById(String id) {
        return reservaRepository.findById(id);
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva updateReserva(Reserva reserva) {
        return reservaRepository.update(reserva);
    }

    public void deleteReserva(String id) {
        reservaRepository.deleteById(id);
    }
}
