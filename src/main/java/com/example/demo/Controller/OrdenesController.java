package com.example.demo.Controller;

import com.example.demo.Model.Ordenes;
import com.example.demo.Service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrdenesController {
    @Autowired
    private OrdenesService service;

    @GetMapping("/Ordenes")
    public List<Ordenes> findAllOrdenes() {
        return service.findAllOrdenes();
    }

    @GetMapping("/Ordenes/{id}")
    public Ordenes findById(@PathVariable Long id) {
        Optional<Ordenes> ordenes = service.findOneById(id);
        return ordenes.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ordenes not found"));
    }

    @PostMapping("/CreateOrdenes")
    public ResponseEntity<Ordenes> createLibros(@RequestBody Ordenes ordenes) {
        Ordenes createdOrdenes = service.save(ordenes);
        return ResponseEntity.ok(createdOrdenes);
    }

    @PutMapping("/UpdateOrdenes/{id}")
    public ResponseEntity<Ordenes> updateOrdenes(@PathVariable Long id, @RequestBody Ordenes ordenes) {
        Ordenes updatedOrdenes = service.update(id,ordenes);
        return ResponseEntity.ok(updatedOrdenes);
    }

    @DeleteMapping("/DeleteOrdenes/{id}")
    public ResponseEntity<Ordenes> deleteOrdenes(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
