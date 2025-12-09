package com.ejercicio.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.veterinaria.dto.MascoDuenioDTO;
import com.ejercicio.veterinaria.model.Mascota;
import com.ejercicio.veterinaria.service.IMascotaService;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @PostMapping("/mascota/crear")
    public String crearMascota(@RequestBody Mascota mascota) {
        mascotaService.postMascota(mascota);
        return "mascota creada";
    }

    @GetMapping("/mascota/lista")
    public List<Mascota> obtenerListaMascota() {
        return mascotaService.getMascota();               
    }
    
    @PutMapping("/mascota/editar/{id}")
    public Mascota editarMascota(@PathVariable Long id,
                            @RequestParam(required = false, name = "id") Long nuevoId,
                            @RequestParam(required = false, name = "nombre") String nombreNuevo,
                            @RequestParam(required = false, name = "especie") String especieNuevo,
                            @RequestParam(required = false, name = "raza")String razaNuevo,
                            @RequestParam(required = false, name = "color")String nuevocolor) {
        Mascota mascota=mascotaService.findMascota(id);
        if (nombreNuevo != null) mascota.setNombre(nombreNuevo);
        if (especieNuevo != null) mascota.setEspecie(especieNuevo);
        if (razaNuevo != null) mascota.setRaza(razaNuevo);
        if (nuevocolor != null) mascota.setColor(nuevocolor);

        mascotaService.postMascota(mascota);
        return mascota;
    }

    @DeleteMapping("/mascota/eliminar/{id}")
    public void eliminarMascota(@PathVariable Long id){
        mascotaService.deleteMascota(id);
    }

    @GetMapping("/mascota/datos")
    public List<MascoDuenioDTO> getDatos() {
        return mascotaService.getMascoDuenios();

    }
}
