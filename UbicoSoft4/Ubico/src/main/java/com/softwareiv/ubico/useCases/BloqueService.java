package com.softwareiv.ubico.useCases;

import com.softwareiv.ubico.adapter.repository.BloqueRepository;
import com.softwareiv.ubico.domain.Bloque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloqueService {
    private final BloqueRepository bloqueRepository;

    @Autowired
    public BloqueService(BloqueRepository bloqueRepository) {
        this.bloqueRepository = bloqueRepository;
    }

    public Bloque createBloque(Bloque bloque) {
        return bloqueRepository.save(bloque);
    }

    public Bloque getBloqueById(String id) {
        return bloqueRepository.findById(id);
    }

    public List<Bloque> getAllBloques() {
        return bloqueRepository.findAll();
    }

    public Bloque updateBloque(Bloque bloque) {
        return bloqueRepository.update(bloque);
    }

    public void deleteBloque(String id) {
        bloqueRepository.deleteById(id);
    }
}
