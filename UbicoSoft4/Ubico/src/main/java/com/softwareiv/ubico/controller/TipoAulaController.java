package com.softwareiv.ubico.controller;

import com.softwareiv.ubico.domain.TipoAula;
import com.softwareiv.ubico.useCases.TipoAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipoaulas")
public class TipoAulaController {
    private final TipoAulaService tipoAulaService;

    @Autowired
    public TipoAulaController(TipoAulaService tipoAulaService) {
        this.tipoAulaService = tipoAulaService;
    }

    @PostMapping("/create")
    public ResponseEntity<TipoAula> createTipoAula(@RequestBody TipoAula tipoAula) {
        TipoAula createdTipoAula = tipoAulaService.createTipoAula(tipoAula);
        return ResponseEntity.ok(createdTipoAula);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAula> getTipoAulaById(@PathVariable String id) {
        TipoAula tipoAula = tipoAulaService.getTipoAulaById(id);
        return tipoAula != null ? ResponseEntity.ok(tipoAula) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<TipoAula>> getAllTipoAulas() {
        List<TipoAula> tipoAulas = tipoAulaService.getAllTipoAulas();
        return ResponseEntity.ok(tipoAulas);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TipoAula> updateTipoAula(@PathVariable String id, @RequestBody TipoAula tipoAula) {
        tipoAula.setId(id);
        TipoAula updatedTipoAula = tipoAulaService.updateTipoAula(tipoAula);
        return updatedTipoAula != null ? ResponseEntity.ok(updatedTipoAula) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTipoAula(@PathVariable String id) {
        tipoAulaService.deleteTipoAula(id);
        return ResponseEntity.ok().build();
    }
}
