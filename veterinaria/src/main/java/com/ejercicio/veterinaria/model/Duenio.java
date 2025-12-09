package com.ejercicio.veterinaria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDuenio;
    private String nombre;
    private String apellido;
    private int dni ;
    private int telefono;

    @OneToMany(mappedBy = "duenio", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Mascota> listaMascota;

    public Duenio() {
    }

    public Duenio(Long idDuenio, String nombre, String apellido, int dni, int telefono, List<Mascota> listaMascota) {
        this.idDuenio = idDuenio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.listaMascota = listaMascota;
    }
}
