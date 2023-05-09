package com.taha.pharmacie.controllers;

import com.taha.pharmacie.entities.Famille;
import com.taha.pharmacie.entities.Medicament;
import com.taha.pharmacie.service.MedicamentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MedicamentController {
    @Autowired
    MedicamentService medicamentService;

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        List<Famille> fams = medicamentService.getAllFamilles();
        Medicament medicament = new Medicament();
        Famille fam = new Famille();
        fam = fams.get(0);
        medicament.setFamille(fam);
        modelMap.addAttribute("medicament",medicament);
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("familles", fams);
        return "formMedicament";
    }

    @RequestMapping("/saveMedicament")
    public String saveMedicament(@Valid Medicament medicament, BindingResult bindingResult, ModelMap modelMap, @RequestParam (name="size", defaultValue = "2") int size, RedirectAttributes redirectAttributes)
    {
        List<Famille> fams = medicamentService.getAllFamilles();
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("familles", fams);
        if (bindingResult.hasErrors())
        {

            return "formMedicament";
        }

        medicamentService.saveMedicament(medicament);
        int totalMedicamentPages = (int) Math.ceil((double) medicamentService.getAllMedicaments().size()/size);
        int lastPage = totalMedicamentPages - 1;

        redirectAttributes.addAttribute("page", lastPage);
        return "redirect:/ListeMedicaments";
    }



    @RequestMapping("/ListeMedicaments")
    public String listeMedicaments(ModelMap modelMap, @RequestParam (name="page",defaultValue = "0") int page,
                                @RequestParam (name="size", defaultValue = "2") int size)
    {
        Page<Medicament> medicaments = medicamentService.getAllMedicamentsParPage(page, size);
        modelMap.addAttribute("medicaments", medicaments);
        modelMap.addAttribute("pages", new int[medicaments.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMedicaments";
    }


    @RequestMapping("/supprimerMedicament")
    public String supprimerMedicament(@RequestParam("id") Long id, ModelMap modelMap,
                                   @RequestParam (name="page",defaultValue = "0") int page,
                                  @RequestParam (name="size", defaultValue = "2") int size)
    {
        medicamentService.deleteMedicamentById(id);
        Page<Medicament> medicaments = medicamentService.getAllMedicamentsParPage(page, size);
        modelMap.addAttribute("medicaments", medicaments);
        modelMap.addAttribute("pages", new int[medicaments.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeMedicaments";
    }


    @RequestMapping("/modifierMedicament")
    public String editerMedicament(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Medicament m = 	medicamentService.getMedicament(id);
        List<Famille> fams = medicamentService.getAllFamilles();
        modelMap.addAttribute("medicament", m);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("familles", fams);
        return "formMedicament";
    }
    @RequestMapping("/updateMedicament")
    public String updateMedicament(@ModelAttribute("medicament") Medicament medicament, @RequestParam("date") String date, ModelMap modelMap) throws ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFabrication = dateformat.parse(String.valueOf(date));
        medicament.setDateFabrication(dateFabrication);
        medicamentService.updateMedicament(medicament);
        List<Medicament> medicaments = medicamentService.getAllMedicaments();
        modelMap.addAttribute("medicaments", medicaments);
        return "listeMedicaments";
    }
}