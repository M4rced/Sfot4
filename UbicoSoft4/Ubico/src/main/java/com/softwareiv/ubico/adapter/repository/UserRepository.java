package com.softwareiv.ubico.adapter.repository;

import com.softwareiv.ubico.domain.User;

public interface UserRepository {
    User save(User user);
    User findByCorreoElectronico(String correoElectronico);
    User findById(String id);
    void deleteById(String id);
}
