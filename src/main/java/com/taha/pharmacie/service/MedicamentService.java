package com.taha.pharmacie.service;

import com.taha.pharmacie.entities.Famille;
import com.taha.pharmacie.entities.Medicament;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MedicamentService {

    Medicament saveMedicament(Medicament medicament);
    Medicament updateMedicament(Medicament medicament);
    void deleteMedicament(Medicament medicament);
    void deleteMedicamentById(Long id);
    Medicament getMedicament(Long id);
    List<Medicament> getAllMedicaments();
    Page<Medicament> getAllMedicamentsParPage(int page, int size);


    List<Medicament> findByNomMedicament(String nom);
    List<Medicament> findByNomMedicamentContains(String nom);
    List<Medicament> findByNomPrix (String nom, Double prix);
    List<Medicament> findByFamille (Famille famille);
    List<Medicament> findByFamilleIdFam(Long id);
    List<Medicament> findByOrderByNomMedicamentAsc();
    List<Medicament> trierMedicamentsNomsPrix();

    List<Famille> getAllFamilles();



}
