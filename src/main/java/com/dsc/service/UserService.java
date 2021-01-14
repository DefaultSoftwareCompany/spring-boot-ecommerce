package com.dsc.service;

import com.dsc.model.Roles;
import com.dsc.model.User;
import com.dsc.repository.RolesRepository;
import com.dsc.repository.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository repository;
    private final RolesRepository rolesRepository;

    @Autowired
    public UserService(UserRepository repository, RolesRepository rolesRepository) {
        this.repository = repository;
        this.rolesRepository = rolesRepository;
    }

    public User getByUsername(String username) {
        return repository.getByUserName(username);
    }

    public User getOne(Long userId) throws Exception {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) return user.get();
        else throw new Exception("There is no user with such an id");
    }

    public User save(User user) throws Exception {
        if (user.getUserName() == null || user.getUserName().length() < 6 || user.getFirstName() == null || user.getFirstName().length() < 5 || user.getLastName() == null || user.getLastName().length() < 5 || user.getPhoneNumber() == null || user.getPhoneNumber().length() < 7 || user.getPassword() == null || user.getPassword().length() < 5 || user.getEmail() == null
                || !EmailValidator.getInstance().isValid(user.getEmail())) {
            throw new Exception("Fill Out form the correctly");
        } else {
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            Set<Roles> roles = new HashSet<>();
            roles.add(rolesRepository.getByRoleName("CUSTOMER"));
            user.setRoles(roles);
            return repository.save(user);
        }
    }

    public User edit(User user, Long userId) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            if (user.getUserName() != null && user.getUserName().length() > 5) {
                oldUser.setUserName(user.getUserName());
            }
            if (user.getFirstName() != null && user.getFirstName().length() > 4) {
                oldUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null && user.getLastName().length() > 4) {
                oldUser.setLastName(user.getLastName());
            }
            if (user.getPhoneNumber() != null && user.getPhoneNumber().length() > 6) {
                oldUser.setPhoneNumber(user.getPhoneNumber());
            }
            if (user.getPassword() != null && user.getPassword().length() > 4) {
                oldUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            }
            if (user.getEmail() != null && EmailValidator.getInstance().isValid(user.getEmail())) {
                oldUser.setEmail(user.getEmail());
            }
            return repository.save(oldUser);
        } else return null;
    }
}
