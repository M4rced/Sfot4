package com.softwareiv.ubico.controller;

import com.softwareiv.ubico.domain.User;
import com.softwareiv.ubico.domain.enums.TipoDocumento;
import com.softwareiv.ubico.useCases.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String nombre, @RequestParam String primerApellido,
                                      @RequestParam String segundoApellido, @RequestParam String numeroDocumento,
                                      @RequestParam TipoDocumento tipoDocumento, @RequestParam String correoElectronico,
                                      @RequestParam String telefonoMovil, @RequestParam String password) {
        try {
            User user = userService.registerUser(nombre, primerApellido, segundoApellido, numeroDocumento, tipoDocumento,
                    correoElectronico, telefonoMovil, password);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String correoElectronico, @RequestParam String password) {
        try {
            User user = userService.loginUser(correoElectronico, password);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestParam String nombre, @RequestParam String primerApellido,
                                    @RequestParam String segundoApellido, @RequestParam String numeroDocumento,
                                    @RequestParam TipoDocumento tipoDocumento, @RequestParam String correoElectronico,
                                    @RequestParam String telefonoMovil, @RequestParam(required = false) String password) {
        try {
            User user = userService.updateUser(id, nombre, primerApellido, segundoApellido, numeroDocumento, tipoDocumento,
                    correoElectronico, telefonoMovil, password);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
