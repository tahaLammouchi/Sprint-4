package com.taha.pharmacie.service;

import com.taha.pharmacie.entities.Famille;
import com.taha.pharmacie.entities.Medicament;
import com.taha.pharmacie.repos.FamilleRepository;
import com.taha.pharmacie.repos.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class MedicamentServiceImpl implements MedicamentService {
        @Autowired
        MedicamentRepository medicamentRepository;
        @Autowired
        FamilleRepository familleRepository;
        @Override
        public Medicament saveMedicament(Medicament medicament) {
            return medicamentRepository.save(medicament);
        }
        @Override
        public Medicament updateMedicament(Medicament medicament) {
            return medicamentRepository.save(medicament);
        }
        @Override
        public void deleteMedicament(Medicament medicament) {
            medicamentRepository.delete(medicament);
        }
        @Override
        public void deleteMedicamentById(Long id) {
            medicamentRepository.deleteById(id);
        }
        @Override
        public Medicament getMedicament(Long id) {
            return medicamentRepository.findById(id).get();
        }
        @Override
        public List<Medicament> getAllMedicaments() {
            return medicamentRepository.findAll();
        }
        @Override
        public Page<Medicament> getAllMedicamentsParPage(int page, int size) {
            return medicamentRepository.findAll(PageRequest.of(page, size));
        }
        @Override
        public List<Medicament> findByNomMedicament(String nom) {
            return medicamentRepository.findByNomMedicament(nom);
        }
        @Override
        public List<Medicament> findByNomMedicamentContains(String nom) {
            return medicamentRepository.findByNomMedicamentContains(nom);
        }
        @Override
        public List<Medicament> findByNomPrix(String nom, Double prix) {
            return medicamentRepository.findByNomPrix(nom, prix);
        }
        @Override
        public List<Medicament> findByFamille(Famille famille) {
            return medicamentRepository.findByFamille(famille);
        }
        @Override
        public List<Medicament> findByFamilleIdFam(Long id) {
            return medicamentRepository.findByFamilleIdFam(id);
        }
        @Override
        public List<Medicament> findByOrderByNomMedicamentAsc() {
            return medicamentRepository.findByOrderByNomMedicamentAsc();
        }
        @Override
        public List<Medicament> trierMedicamentsNomsPrix() {
            return medicamentRepository.trierMedicamentsNomsPrix();
        }

        @Override
        public List<Famille> getAllFamilles() {
            return familleRepository.findAll();
        }
    }

