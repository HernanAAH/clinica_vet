package com.ejercicio.veterinaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_duenio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Duenio duenio;
    
    public Mascota() {
    }

    public Mascota(Long idMascota, String nombre, String especie, String raza, String color, Duenio duenio) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.duenio = duenio;
    }

    

    
}
