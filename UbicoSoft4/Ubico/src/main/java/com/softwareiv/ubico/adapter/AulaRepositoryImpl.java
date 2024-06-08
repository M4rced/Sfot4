package com.softwareiv.ubico.adapter;

import com.softwareiv.ubico.adapter.repository.AulaRepository;
import com.softwareiv.ubico.domain.Aula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AulaRepositoryImpl implements AulaRepository {
    private final List<Aula> database = new ArrayList<>();
    private int currentId = 1;

    @Override
    public Aula save(Aula aula) {
        aula.setId(String.valueOf(currentId++));
        database.add(aula);
        return aula;
    }

    @Override
    public Aula findById(String id) {
        return database.stream()
                .filter(aula -> aula.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Aula> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Aula update(Aula aula) {
        Optional<Aula> optionalAula = database.stream()
                .filter(a -> a.getId().equals(aula.getId()))
                .findFirst();
        if (optionalAula.isPresent()) {
            database.remove(optionalAula.get());
            database.add(aula);
            return aula;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        database.removeIf(aula -> aula.getId().equals(id));
    }
}
