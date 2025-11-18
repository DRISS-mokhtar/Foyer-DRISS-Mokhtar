package org.example.rev.controller;

import java.util.List;
import org.example.rev.entity.Foyer;
import org.example.rev.service.FoyerService;
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
@RequestMapping("/api/foyers")
public class FoyerController {

    private final FoyerService foyerService;

    public FoyerController(FoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @GetMapping
    public List<Foyer> getAll() {
        return foyerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getById(@PathVariable Long id) {
        return foyerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Foyer> create(@RequestBody Foyer foyer) {
        return ResponseEntity.ok(foyerService.save(foyer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> update(@PathVariable Long id, @RequestBody Foyer foyer) {
        if (foyerService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        foyer.setIdFoyer(id);
        return ResponseEntity.ok(foyerService.save(foyer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foyerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

