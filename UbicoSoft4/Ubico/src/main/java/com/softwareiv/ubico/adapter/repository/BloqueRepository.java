package com.softwareiv.ubico.adapter.repository;

import com.softwareiv.ubico.domain.Bloque;

import java.util.List;

public interface BloqueRepository {
    Bloque save(Bloque bloque);
    Bloque findById(String id);
    List<Bloque> findAll();
    Bloque update(Bloque bloque);
    void deleteById(String id);
}
