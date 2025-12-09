package com.ejercicio.veterinaria.service;

import java.util.List;

import com.ejercicio.veterinaria.model.Duenio;

public interface IDuenioService{

    public void postDuenio(Duenio duenio);

    public List<Duenio> getDuenio();

    public void deleteDuenio(Long id);

    public void editDuenio(Long id, Long idNuevo, String nuevoNombre, String nuevoApellido, int nuevoDni, int nuevoTel);

    public Duenio findDuenio(Long id);
}
