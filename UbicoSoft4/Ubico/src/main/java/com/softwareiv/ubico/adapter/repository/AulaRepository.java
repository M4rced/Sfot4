package com.softwareiv.ubico.adapter.repository;

import com.softwareiv.ubico.domain.Aula;

import java.util.List;

public interface AulaRepository {
    Aula save(Aula aula);
    Aula findById(String id);
    List<Aula> findAll();
    Aula update(Aula aula);
    void deleteById(String id);
}
