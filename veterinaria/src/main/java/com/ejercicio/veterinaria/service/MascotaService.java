package com.ejercicio.veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.veterinaria.dto.MascoDuenioDTO;
import com.ejercicio.veterinaria.model.Mascota;
import com.ejercicio.veterinaria.repository.IMascotaRepository;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepo;

    @Override
    public void postMascota(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

    @Override
    public List<Mascota> getMascota() {
        return mascotaRepo.findAll();
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepo.deleteById(id);
    }

    @Override
    public void editMascota(Long id, Long idnuevo, String nombreNuevo, String especieNuevo, String colorNuevo,
            String razaNuevo) {
        Mascota mascota=this.findMascota(id);
        mascota.setNombre(nombreNuevo);
        mascota.setEspecie(especieNuevo);
        mascota.setColor(colorNuevo);
        mascota.setRaza(razaNuevo);
        this.postMascota(mascota);
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota mascota=mascotaRepo.findById(id).orElse(null);
        return mascota;
    }

    @Override
    public List<Mascota> getMascotaEspRaz() {
        List<Mascota> lista=new ArrayList<>();
        for(Mascota m: this.getMascota()){
            String especie = m.getEspecie().toLowerCase();
            String raza = m.getRaza().toLowerCase();
            if(especie.contains("perro") || raza.contains("caniche")){
                lista.add(m);
            }
        }
        return lista;
    }

    public List<MascoDuenioDTO> getMascoDuenios(){
        List<Mascota> listaMascotas = this.getMascota();
        List<MascoDuenioDTO> listaMascoDuenio = new ArrayList<MascoDuenioDTO>();
        MascoDuenioDTO masco_duenio = new MascoDuenioDTO();
        
        for (Mascota masco : listaMascotas) {
            
            System.out.println(masco.getNombre());
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());
            
            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new MascoDuenioDTO();//reseteo
        }
        return listaMascoDuenio;
    }
}
