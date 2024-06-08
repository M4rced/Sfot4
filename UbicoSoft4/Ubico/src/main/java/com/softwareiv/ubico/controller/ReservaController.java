package com.softwareiv.ubico.controller;

import com.softwareiv.ubico.domain.Reserva;
import com.softwareiv.ubico.useCases.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping("/create")
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        try {
            Reserva createdReserva = reservaService.createReserva(reserva);
            return ResponseEntity.ok(createdReserva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable String id) {
        Reserva reserva = reservaService.getReservaById(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaService.getAllReservas();
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable String id, @RequestBody Reserva reserva) {
        reserva.setId(id);
        Reserva updatedReserva = reservaService.updateReserva(reserva);
        return updatedReserva != null ? ResponseEntity.ok(updatedReserva) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable String id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.ok().build();
    }
}
