package com.taha.pharmacie.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMedicament", types = { Medicament.class })

public interface MedicamentProjection {
    public String getNomMedicament();
}
