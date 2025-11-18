package org.example.rev.controller;

import java.util.List;
import org.example.rev.entity.Bloc;
import org.example.rev.service.BlocService;
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
@RequestMapping("/api/blocs")
public class BlocController {

    private final BlocService blocService;

    public BlocController(BlocService blocService) {
        this.blocService = blocService;
    }

    @GetMapping
    public List<Bloc> getAll() {
        return blocService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getById(@PathVariable Long id) {
        return blocService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bloc> create(@RequestBody Bloc bloc) {
        return ResponseEntity.ok(blocService.save(bloc));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> update(@PathVariable Long id, @RequestBody Bloc bloc) {
        if (blocService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bloc.setIdBloc(id);
        return ResponseEntity.ok(blocService.save(bloc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        blocService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

