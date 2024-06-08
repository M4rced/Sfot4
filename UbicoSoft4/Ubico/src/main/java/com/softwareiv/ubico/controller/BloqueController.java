package com.softwareiv.ubico.controller;

import com.softwareiv.ubico.domain.Bloque;
import com.softwareiv.ubico.useCases.BloqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloques")
public class BloqueController {
    private final BloqueService bloqueService;

    @Autowired
    public BloqueController(BloqueService bloqueService) {
        this.bloqueService = bloqueService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bloque> createBloque(@RequestBody Bloque bloque) {
        Bloque createdBloque = bloqueService.createBloque(bloque);
        return ResponseEntity.ok(createdBloque);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloque> getBloqueById(@PathVariable String id) {
        Bloque bloque = bloqueService.getBloqueById(id);
        return bloque != null ? ResponseEntity.ok(bloque) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bloque>> getAllBloques() {
        List<Bloque> bloques = bloqueService.getAllBloques();
        return ResponseEntity.ok(bloques);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bloque> updateBloque(@PathVariable String id, @RequestBody Bloque bloque) {
        bloque.setId(id);
        Bloque updatedBloque = bloqueService.updateBloque(bloque);
        return updatedBloque != null ? ResponseEntity.ok(updatedBloque) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBloque(@PathVariable String id) {
        bloqueService.deleteBloque(id);
        return ResponseEntity.ok().build();
    }
}
