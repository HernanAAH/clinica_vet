package com.ejercicio.veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.veterinaria.model.Mascota;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Long>{

}
