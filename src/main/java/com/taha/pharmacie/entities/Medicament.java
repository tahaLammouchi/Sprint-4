package com.taha.pharmacie.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicament;

    @NotNull
    @Size(min = 4,max = 15)
    private String nomMedicament;

    @Min(value = 10)
    @Max(value = 10000)
    private Double prixMedicament;
    private String paysFabricant;

    @ManyToOne
    private Famille famille;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateFabrication;

    public Medicament() {
        super();
    }

    public Medicament(String nomMedicament, Double prixMedicament, String paysFabricant, Date dateFabrication) {
        this.nomMedicament = nomMedicament;
        this.prixMedicament = prixMedicament;
        this.paysFabricant = paysFabricant;
        this.dateFabrication = dateFabrication;
    }

    public Long getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Long idMedicament) {
        this.idMedicament = idMedicament;
    }

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public Double getPrixMedicament() {
        return prixMedicament;
    }

    public void setPrixMedicament(Double prixMedicament) {
        this.prixMedicament = prixMedicament;
    }

    public String getPaysFabricant() {
        return paysFabricant;
    }

    public void setPaysFabricant(String paysFabricant) {
        this.paysFabricant = paysFabricant;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }
}
