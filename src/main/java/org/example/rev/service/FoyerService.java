package org.example.rev.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.rev.entity.Foyer;
import org.example.rev.repository.FoyerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoyerService {

    private final FoyerRepository foyerRepository;

    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    public Optional<Foyer> findById(Long id) {
        return foyerRepository.findById(id);
    }

    public Foyer save(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public void delete(Long id) {
        foyerRepository.deleteById(id);
    }
}

