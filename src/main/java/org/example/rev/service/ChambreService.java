package org.example.rev.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.rev.entity.Chambre;
import org.example.rev.repository.ChambreRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChambreService {

    private final ChambreRepository chambreRepository;

    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> findById(Long id) {
        return chambreRepository.findById(id);
    }

    public Chambre save(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void delete(Long id) {
        chambreRepository.deleteById(id);
    }
}

