package com.softwareiv.ubico.controller;

import com.softwareiv.ubico.domain.Disponibilidad;
import com.softwareiv.ubico.useCases.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disponibilidades")
public class DisponibilidadController {
    private final DisponibilidadService disponibilidadService;

    @Autowired
    public DisponibilidadController(DisponibilidadService disponibilidadService) {
        this.disponibilidadService = disponibilidadService;
    }

    @PostMapping("/create")
    public ResponseEntity<Disponibilidad> createDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        Disponibilidad createdDisponibilidad = disponibilidadService.createDisponibilidad(disponibilidad);
        return ResponseEntity.ok(createdDisponibilidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disponibilidad> getDisponibilidadById(@PathVariable String id) {
        Disponibilidad disponibilidad = disponibilidadService.getDisponibilidadById(id);
        return disponibilidad != null ? ResponseEntity.ok(disponibilidad) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Disponibilidad>> getAllDisponibilidades() {
        List<Disponibilidad> disponibilidades = disponibilidadService.getAllDisponibilidades();
        return ResponseEntity.ok(disponibilidades);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Disponibilidad> updateDisponibilidad(@PathVariable String id, @RequestBody Disponibilidad disponibilidad) {
        disponibilidad.setId(id);
        Disponibilidad updatedDisponibilidad = disponibilidadService.updateDisponibilidad(disponibilidad);
        return updatedDisponibilidad != null ? ResponseEntity.ok(updatedDisponibilidad) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDisponibilidad(@PathVariable String id) {
        disponibilidadService.deleteDisponibilidad(id);
        return ResponseEntity.ok().build();
    }
}
