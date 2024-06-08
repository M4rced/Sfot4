package com.softwareiv.ubico.adapter;

import com.softwareiv.ubico.adapter.repository.ReservaRepository;
import com.softwareiv.ubico.domain.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {
    private final List<Reserva> database = new ArrayList<>();
    private int currentId = 1;

    @Override
    public Reserva save(Reserva reserva) {
        reserva.setId(String.valueOf(currentId++));
        database.add(reserva);
        return reserva;
    }

    @Override
    public Reserva findById(String id) {
        return database.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reserva> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Reserva update(Reserva reserva) {
        Optional<Reserva> optionalReserva = database.stream()
                .filter(r -> r.getId().equals(reserva.getId()))
                .findFirst();
        if (optionalReserva.isPresent()) {
            database.remove(optionalReserva.get());
            database.add(reserva);
            return reserva;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        database.removeIf(reserva -> reserva.getId().equals(id));
    }
}
