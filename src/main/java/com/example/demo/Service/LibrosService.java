package com.example.demo.Service;

import com.example.demo.Model.Libros;
import com.example.demo.Repository.ILibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {
    private ILibrosRepository repository;


    @Autowired
    public LibrosService(ILibrosRepository repository) {
        this.repository = repository;
    }

    public List<Libros> findAllLibros() {
        return repository.findAll();
    }

    public Optional<Libros> findOneById(Long libroID) {
        return repository.findById(libroID);
    }

    public Libros save(Libros libros) {
        return repository.save(libros);
    }

    public Libros update(Long libroID, Libros libros) {
        libros.setLibroId(libroID);
        return repository.save(libros);
    }

    public void delete(Long libroID) {
        repository.deleteById(libroID);
    }
}