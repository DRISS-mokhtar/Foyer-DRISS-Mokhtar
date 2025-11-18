package org.example.rev.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    private String idReservation;

    private LocalDate anneeUniversitaire;

    private boolean estValide;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    @JsonBackReference("chambre-reservations")
    private Chambre chambre;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    @JsonBackReference("etudiant-reservations")
    private Etudiant etudiant;
}

