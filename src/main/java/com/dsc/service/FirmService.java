package com.dsc.service;

import com.dsc.model.Firm;
import com.dsc.repository.FirmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirmService {
    private final FirmRepository repository;

    public FirmService(FirmRepository repository) {
        this.repository = repository;
    }

    public List<Firm> getAll() {
        return repository.findAll();
    }

    public Firm getOne(Long firmId) throws Exception {
        Optional<Firm> firm = repository.findById(firmId);
        if (firm.isPresent()) return firm.get();
        else throw new Exception("There is no firm with such an id");
    }
}
