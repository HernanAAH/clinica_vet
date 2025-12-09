package com.ejercicio.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.veterinaria.model.Duenio;

@Repository
public interface IDuenioRepository extends JpaRepository<Duenio, Long>{

}
