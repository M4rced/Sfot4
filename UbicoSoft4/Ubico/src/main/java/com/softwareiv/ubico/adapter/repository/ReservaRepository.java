package com.softwareiv.ubico.adapter.repository;

import com.softwareiv.ubico.domain.Reserva;

import java.util.List;

public interface ReservaRepository {
    Reserva save(Reserva reserva);
    Reserva findById(String id);
    List<Reserva> findAll();
    Reserva update(Reserva reserva);
    void deleteById(String id);
}
