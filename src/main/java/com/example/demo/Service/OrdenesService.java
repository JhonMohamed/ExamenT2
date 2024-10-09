package com.example.demo.Service;

import com.example.demo.Model.Ordenes;
import com.example.demo.Repository.IOrdenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenesService {
    private IOrdenesRepository repository;

    @Autowired
    public OrdenesService(IOrdenesRepository repository) {
        this.repository = repository;
    }

    public List<Ordenes> findAllOrdenes() {
        return repository.findAll();
    }

    public Optional<Ordenes> findOneById(Long id) {
        return repository.findById(id);
    }

    public Ordenes save(Ordenes ordenes) {
        return repository.save(ordenes);
    }

    public Ordenes update(Long OrdenesId, Ordenes ordenes) {
        ordenes.setOrdenId(OrdenesId);
        return repository.save(ordenes);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
