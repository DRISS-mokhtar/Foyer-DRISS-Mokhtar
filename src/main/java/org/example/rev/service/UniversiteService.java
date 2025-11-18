package org.example.rev.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.rev.entity.Universite;
import org.example.rev.repository.UniversiteRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversiteService {

    private final UniversiteRepository universiteRepository;

    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    public Optional<Universite> findById(Long id) {
        return universiteRepository.findById(id);
    }

    public Universite save(Universite universite) {
        return universiteRepository.save(universite);
    }

    public void delete(Long id) {
        universiteRepository.deleteById(id);
    }
}

