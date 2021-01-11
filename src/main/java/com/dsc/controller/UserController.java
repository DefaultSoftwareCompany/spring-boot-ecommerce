package com.dsc.controller;

import com.dsc.model.Purchase;
import com.dsc.model.User;
import com.dsc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/api/purchases/get/user/{userId}")
    public ResponseEntity<List<Purchase>> getPurchasesByUser(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(service.getOne(userId).getPurchases());
    }

}
