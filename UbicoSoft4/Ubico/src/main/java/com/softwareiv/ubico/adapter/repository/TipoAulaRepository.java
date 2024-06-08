package com.softwareiv.ubico.adapter.repository;

import com.softwareiv.ubico.domain.TipoAula;

import java.util.List;

public interface TipoAulaRepository {

    TipoAula save(TipoAula tipoAula);
    TipoAula findById(String id);
    List<TipoAula> findAll();

    List<TipoAula> fillALl();

    TipoAula update(TipoAula tipoAula);
    void deleteById(String id);

}
