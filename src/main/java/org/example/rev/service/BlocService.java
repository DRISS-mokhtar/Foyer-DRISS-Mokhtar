package org.example.rev.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.rev.entity.Bloc;
import org.example.rev.repository.BlocRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlocService {

    private final BlocRepository blocRepository;

    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    public Optional<Bloc> findById(Long id) {
        return blocRepository.findById(id);
    }

    public Bloc save(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public void delete(Long id) {
        blocRepository.deleteById(id);
    }
}

