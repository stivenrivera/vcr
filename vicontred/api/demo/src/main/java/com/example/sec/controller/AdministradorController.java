package com.example.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sec.entidades.Administrador;
import com.example.sec.repository.AdministradorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    // Obtener todos los administradores
    @GetMapping
    public List<Administrador> obtenerAdministradores() {
        return administradorRepository.findAll();
    }

    // Obtener un administrador por ID
    @GetMapping("/{id}")
    public Administrador obtenerAdministrador(@PathVariable Long id) {
        return administradorRepository.findById(id).orElse(null);
    }

    // Crear un nuevo administrador
    @PostMapping
    public Administrador crearAdministrador(@RequestBody Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    // Actualizar un administrador existente
    @PutMapping("/{id}")
    public Administrador actualizarAdministrador(@PathVariable Long id, @RequestBody Administrador detalles) {
        Administrador administrador = administradorRepository.findById(id).orElse(null);
        if (administrador != null) {
            administrador.setDni(detalles.getDni());
            administrador.setPrimerNombre(detalles.getPrimerNombre());
            administrador.setSegundoNombre(detalles.getSegundoNombre());
            administrador.setPrimerApellido(detalles.getPrimerApellido());
            administrador.setSegundoApellido(detalles.getSegundoApellido());
            administrador.setTelefono(detalles.getTelefono());
            administrador.setMail(detalles.getMail());
            return administradorRepository.save(administrador);
        }
        return null;
    }

    // Eliminar un administrador
    @DeleteMapping("/{id}")
    public void eliminarAdministrador(@PathVariable Long id) {
        administradorRepository.deleteById(id);
    }
}
