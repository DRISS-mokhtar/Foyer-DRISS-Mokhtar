package org.example.rev.controller;

import java.util.List;
import org.example.rev.entity.Universite;
import org.example.rev.service.UniversiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    private final UniversiteService universiteService;

    public UniversiteController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping
    public List<Universite> getAll() {
        return universiteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getById(@PathVariable Long id) {
        return universiteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Universite> create(@RequestBody Universite universite) {
        return ResponseEntity.ok(universiteService.save(universite));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> update(@PathVariable Long id, @RequestBody Universite universite) {
        if (universiteService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        universite.setIdUniversite(id);
        return ResponseEntity.ok(universiteService.save(universite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        universiteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

