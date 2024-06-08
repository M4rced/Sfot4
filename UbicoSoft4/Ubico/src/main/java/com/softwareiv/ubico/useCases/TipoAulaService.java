package com.softwareiv.ubico.useCases;

import com.softwareiv.ubico.adapter.repository.TipoAulaRepository;
import com.softwareiv.ubico.domain.TipoAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAulaService {
    private final TipoAulaRepository tipoAulaRepository;

    @Autowired
    public TipoAulaService(TipoAulaRepository tipoAulaRepository) {
        this.tipoAulaRepository = tipoAulaRepository;
    }

    public TipoAula createTipoAula(TipoAula tipoAula) {
        return tipoAulaRepository.save(tipoAula);
    }

    public TipoAula getTipoAulaById(String id) {
        return tipoAulaRepository.findById(id);
    }

    public List<TipoAula> getAllTipoAulas() {
        return tipoAulaRepository.findAll();
    }

    public TipoAula updateTipoAula(TipoAula tipoAula) {
        return tipoAulaRepository.update(tipoAula);
    }

    public void deleteTipoAula(String id) {
        tipoAulaRepository.deleteById(id);
    }
}
