package com.dsc.controller;

import com.dsc.model.Firm;
import com.dsc.service.FirmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirmController {
    private final FirmService service;

    public FirmController(FirmService service) {
        this.service = service;
    }

    @GetMapping("/api/firm/all")
    public ResponseEntity<List<Firm>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
