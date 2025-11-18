package org.example.rev.controller;

import java.util.List;
import org.example.rev.entity.Chambre;
import org.example.rev.service.ChambreService;
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
@RequestMapping("/api/chambres")
public class ChambreController {

    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping
    public List<Chambre> getAll() {
        return chambreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getById(@PathVariable Long id) {
        return chambreService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Chambre> create(@RequestBody Chambre chambre) {
        return ResponseEntity.ok(chambreService.save(chambre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> update(@PathVariable Long id, @RequestBody Chambre chambre) {
        if (chambreService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        chambre.setIdChambre(id);
        return ResponseEntity.ok(chambreService.save(chambre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        chambreService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

