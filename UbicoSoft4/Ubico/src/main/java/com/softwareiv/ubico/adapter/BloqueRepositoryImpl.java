package com.softwareiv.ubico.adapter;

import com.softwareiv.ubico.adapter.repository.BloqueRepository;
import com.softwareiv.ubico.domain.Bloque;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BloqueRepositoryImpl implements BloqueRepository {

    private final List<Bloque> database = new ArrayList<>();
    private int currentId = 1;

    @Override
    public Bloque save(Bloque bloque) {
        bloque.setId(String.valueOf(currentId++));
        database.add(bloque);
        return bloque;
    }

    @Override
    public Bloque findById(String id) {
        return database.stream()
                .filter(bloque -> bloque.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Bloque> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Bloque update(Bloque bloque) {
        Optional<Bloque> optionalBloque = database.stream()
                .filter(b -> b.getId().equals(bloque.getId()))
                .findFirst();
        if (optionalBloque.isPresent()) {
            database.remove(optionalBloque.get());
            database.add(bloque);
            return bloque;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        database.removeIf(bloque -> bloque.getId().equals(id));
    }

}
