package com.softwareiv.ubico.adapter;

import com.softwareiv.ubico.domain.User;
import com.softwareiv.ubico.adapter.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> database = new HashMap<>();

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(String.valueOf(database.size() + 1));
        }
        database.put(user.getCorreoElectronico(), user);
        return user;
    }

    @Override
    public User findByCorreoElectronico(String correoElectronico) {
        return database.get(correoElectronico);
    }

    @Override
    public User findById(String id) {
        return database.values().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        database.values().removeIf(user -> user.getId().equals(id));
    }
}
