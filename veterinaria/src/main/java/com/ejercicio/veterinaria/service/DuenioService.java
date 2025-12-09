package com.ejercicio.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.veterinaria.model.Duenio;
import com.ejercicio.veterinaria.model.Mascota;
import com.ejercicio.veterinaria.repository.IDuenioRepository;

@Service
public class DuenioService implements IDuenioService{

    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public void postDuenio(Duenio duenio) {
        if (duenio.getListaMascota() !=null){
            for(Mascota m: duenio.getListaMascota()){
                m.setDuenio(duenio);
            }
        }
        duenioRepo.save(duenio);
    }

    @Override
    public List<Duenio> getDuenio() {
        List<Duenio> listaDuenio=duenioRepo.findAll();
        return listaDuenio;
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepo.deleteById(id);
    }

    @Override
    public void editDuenio(Long id, Long idNuevo, String nuevoNombre, String nuevoApellido, int nuevoDni,
            int nuevoTel) {
        
        Duenio duenio = this.findDuenio(id);
        duenio.setNombre(nuevoNombre);
        duenio.setApellido(nuevoApellido);
        duenio.setDni(nuevoDni);
        duenio.setTelefono(nuevoTel);
        
        this.postDuenio(duenio);
    }

    @Override
    public Duenio findDuenio(Long id) {
        Duenio duenio = duenioRepo.findById(id).orElse(null);
        return duenio;
    }
}
