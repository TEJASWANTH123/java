package com.example.crud.repository;

import com.example.crud.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        }
        users.removeIf(u -> u.getId().equals(user.getId()));
        users.add(user);
        return user;
    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
