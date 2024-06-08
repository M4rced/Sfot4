package com.softwareiv.ubico.useCases;

import com.softwareiv.ubico.adapter.repository.AulaRepository;
import com.softwareiv.ubico.domain.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    private final AulaRepository aulaRepository;

    @Autowired
    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public Aula createAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    public Aula getAulaById(String id) {
        return aulaRepository.findById(id);
    }

    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    public Aula updateAula(Aula aula) {
        return aulaRepository.update(aula);
    }

    public void deleteAula(String id) {
        aulaRepository.deleteById(id);
    }
}
