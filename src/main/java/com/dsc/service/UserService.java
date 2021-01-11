package com.dsc.service;

import com.dsc.model.User;
import com.dsc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getByUsername(String username) {
        return repository.getByUserName(username);
    }

    public User getOne(Long userId) throws Exception {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) return user.get();
        else throw new Exception("There is no user with such an id");
    }
}
