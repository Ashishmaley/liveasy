package com.myapp.loads.service;

import com.myapp.loads.entity.Load;
import com.myapp.loads.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    public Load saveLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Optional<Load> getLoadById(UUID loadId) {
        return loadRepository.findById(loadId);
    }

    public void deleteLoadById(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
