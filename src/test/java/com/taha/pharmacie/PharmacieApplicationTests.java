package com.taha.pharmacie;

import com.taha.pharmacie.entities.Medicament;
import com.taha.pharmacie.repos.MedicamentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class PharmacieApplicationTests {
	@Autowired
	private MedicamentRepository medicamentRepository;
	@Test
	public void testCreateMedicament() {
		Medicament medicament = new Medicament("Fervex",2200.500,"France",new Date());
		medicamentRepository.save(medicament);
	}

	@Test
	public void testFindMedicament()
	{
		Medicament medicament = medicamentRepository.findById(1L).get();
		System.out.println(medicament);
	}
	@Test
	public void testUpdateMedicament()
	{
		Medicament medicament = medicamentRepository.findById(1L).get();
		medicament.setPrixMedicament(1000.0);
		medicamentRepository.save(medicament);
	}
	@Test
	public void testDeleteMedicament()
	{
		medicamentRepository.deleteById(1L);
	}

	@Test
	public void testListerTousMedicaments()
	{
		List<Medicament> medicaments = medicamentRepository.findAll();
		for (Medicament m : medicaments)
		{
			System.out.println(m);
		}
	}

}
