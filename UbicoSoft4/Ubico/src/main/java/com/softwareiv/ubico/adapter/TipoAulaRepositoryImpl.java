package com.softwareiv.ubico.adapter;

import com.softwareiv.ubico.adapter.repository.TipoAulaRepository;
import com.softwareiv.ubico.domain.TipoAula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TipoAulaRepositoryImpl implements TipoAulaRepository {
    private final List<TipoAula> database = new ArrayList<>();
    private int currentId = 1;

    @Override
    public TipoAula save(TipoAula tipoAula) {
        tipoAula.setId(String.valueOf(currentId++));
        database.add(tipoAula);
        return tipoAula;
    }

    @Override
    public TipoAula findById(String id) {
        return database.stream()
                .filter(tipoAula -> tipoAula.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TipoAula> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public List<TipoAula> fillALl() {
        return null;
    }

    @Override
    public TipoAula update(TipoAula tipoAula) {
        Optional<TipoAula> optionalTipoAula = database.stream()
                .filter(ta -> ta.getId().equals(tipoAula.getId()))
                .findFirst();
        if (optionalTipoAula.isPresent()) {
            database.remove(optionalTipoAula.get());
            database.add(tipoAula);
            return tipoAula;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        database.removeIf(tipoAula -> tipoAula.getId().equals(id));
    }

}
