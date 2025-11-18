package org.example.rev.repository;

import org.example.rev.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
}

