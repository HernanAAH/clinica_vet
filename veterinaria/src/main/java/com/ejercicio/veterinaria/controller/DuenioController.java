package com.ejercicio.veterinaria.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.veterinaria.model.Duenio;
import com.ejercicio.veterinaria.service.IDuenioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DuenioController {

    @Autowired
    private IDuenioService duenioService;

    @PostMapping("/dueño/crear")
    public String crearDeunio(@RequestBody Duenio duenio) {
        duenioService.postDuenio(duenio);
        return "dueño creado";
    }

    @GetMapping("/dueño/lista")
    public List<Duenio> obtenerListaDuenio() {
        return duenioService.getDuenio();               
    }
    
    @PutMapping("/dueño/editar/{id}")
    public Duenio editarDuenio(@PathVariable Long id,
                            @RequestParam(required = false, name = "id") Long nuevoId,
                            @RequestParam(required = false, name = "nombre") String nombreNuevo,
                            @RequestParam(required = false, name = "apellido") String apellidoNuevo,
                            @RequestParam(required = false, name = "dni")Integer nuevoDni,
                            @RequestParam(required = false, name = "tel")Integer nuevoTel) {
        Duenio duenio = duenioService.findDuenio(id);

        if (nuevoId != null) duenio.setIdDuenio(nuevoId);
        if (nombreNuevo != null) duenio.setNombre(nombreNuevo);
        if (apellidoNuevo != null) duenio.setApellido(apellidoNuevo);
        if (nuevoDni != null) duenio.setDni(nuevoDni);
        if (nuevoTel != null) duenio.setTelefono(nuevoTel);

        duenioService.postDuenio(duenio);

        return duenio;
    }

    @DeleteMapping("/dueño/eliminar/{id}")
    public void eliminarDuenio(@PathVariable Long id){
        duenioService.deleteDuenio(id);
    }

    //hacer esto en mascota pero habiendo colocado un objeto dueño en la clase mascota y poner el manytoone 
    
}
