package com.dsc.controller;

import com.dsc.model.User;
import com.dsc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/api/user/get/username/{username}")
    public ResponseEntity<User> getByUserName(@PathVariable String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @GetMapping("/api/user/get/{userId}")
    public ResponseEntity<User> getOne(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(service.getOne(userId));
    }


    @PostMapping("/api/customer/save")
    public ResponseEntity<User> save(@ModelAttribute User user) throws Exception {
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/api/user/edit/{userId}")
    public ResponseEntity<User> edit(@PathVariable Long userId, @ModelAttribute User user) {
        return ResponseEntity.ok(service.edit(user, userId));
    }

}
