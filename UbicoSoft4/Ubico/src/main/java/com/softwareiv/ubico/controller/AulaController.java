package com.softwareiv.ubico.controller;

import com.softwareiv.ubico.domain.Aula;
import com.softwareiv.ubico.useCases.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {
    private final AulaService aulaService;

    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @PostMapping("/create")
    public ResponseEntity<Aula> createAula(@RequestBody Aula aula) {
        Aula createdAula = aulaService.createAula(aula);
        return ResponseEntity.ok(createdAula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> getAulaById(@PathVariable String id) {
        Aula aula = aulaService.getAulaById(id);
        return aula != null ? ResponseEntity.ok(aula) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Aula>> getAllAulas() {
        List<Aula> aulas = aulaService.getAllAulas();
        return ResponseEntity.ok(aulas);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable String id, @RequestBody Aula aula) {
        aula.setId(id);
        Aula updatedAula = aulaService.updateAula(aula);
        return updatedAula != null ? ResponseEntity.ok(updatedAula) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable String id) {
        aulaService.deleteAula(id);
        return ResponseEntity.ok().build();
    }
}
