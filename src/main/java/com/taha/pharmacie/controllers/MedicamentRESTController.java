package com.taha.pharmacie.controllers;

import com.taha.pharmacie.entities.Medicament;
import com.taha.pharmacie.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class MedicamentRESTController {
    @Autowired
    MedicamentService medicamentService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Medicament> getAllMedicaments() {
        return medicamentService.getAllMedicaments();
    }
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Medicament getMedicamentById(@PathVariable("id") Long id) {
        return medicamentService.getMedicament(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Medicament createMedicament(@RequestBody Medicament medicament) {
        return medicamentService.saveMedicament(medicament);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Medicament updateProduit(@RequestBody Medicament medicament) {
        return medicamentService.updateMedicament(medicament);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void deleteMedicament(@PathVariable("id") Long id)
    {
        medicamentService.deleteMedicamentById(id);
    }
    @RequestMapping(value="/medsfam/{idFam}",method = RequestMethod.GET)
    public List<Medicament> getMedicamentsByFamId(@PathVariable("idFam") Long idFam) {
        return medicamentService.findByFamilleIdFam(idFam);
    }




}
