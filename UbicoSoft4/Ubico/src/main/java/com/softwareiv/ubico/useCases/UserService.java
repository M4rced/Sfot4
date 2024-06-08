package com.softwareiv.ubico.useCases;

import com.softwareiv.ubico.domain.User;
import com.softwareiv.ubico.domain.enums.TipoDocumento;
import com.softwareiv.ubico.adapter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String nombre, String primerApellido, String segundoApellido, String numeroDocumento,
                             TipoDocumento tipoDocumento, String correoElectronico, String telefonoMovil, String password) {
        if (userRepository.findByCorreoElectronico(correoElectronico) != null) {
            throw new IllegalArgumentException("Email is already taken.");
        }
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(null, nombre, primerApellido, segundoApellido, numeroDocumento, tipoDocumento,
                correoElectronico, telefonoMovil, encodedPassword);
        return userRepository.save(user);
    }

    public User loginUser(String correoElectronico, String password) {
        User user = userRepository.findByCorreoElectronico(correoElectronico);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password.");
        }
        return user;
    }

    public User updateUser(String id, String nombre, String primerApellido, String segundoApellido, String numeroDocumento,
                           TipoDocumento tipoDocumento, String correoElectronico, String telefonoMovil, String password) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        user.setNombre(nombre);
        user.setPrimerApellido(primerApellido);
        user.setSegundoApellido(segundoApellido);
        user.setNumeroDocumento(numeroDocumento);
        user.setTipoDocumento(tipoDocumento);
        user.setCorreoElectronico(correoElectronico);
        user.setTelefonoMovil(telefonoMovil);
        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
