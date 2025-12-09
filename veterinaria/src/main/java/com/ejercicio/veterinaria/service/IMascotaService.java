package com.ejercicio.veterinaria.service;

import java.util.List;

import com.ejercicio.veterinaria.dto.MascoDuenioDTO;
import com.ejercicio.veterinaria.model.Mascota;

public interface IMascotaService{

    public void postMascota(Mascota mascota);

    public List<Mascota> getMascota();

    public void deleteMascota(Long id);

    public void editMascota(Long id, Long idnuevo, String nombreNuevo, String especieNuevo, String colorNuevo, String razaNuevo);

    public Mascota findMascota(Long id);

    public List<Mascota> getMascotaEspRaz();

    public List<MascoDuenioDTO> getMascoDuenios();
}
