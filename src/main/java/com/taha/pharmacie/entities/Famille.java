package com.taha.pharmacie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Famille {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idFam;
        private String nomFam;
        private String descriptionFam;
        @JsonIgnore
        @OneToMany(mappedBy = "famille")
        private List<Medicament> medicaments;
}
