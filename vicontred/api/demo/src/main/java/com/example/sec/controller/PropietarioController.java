package com.example.sec.controladores;

import com.example.sec.entidades.Propietario;
import com.example.sec.service.PropietarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;

    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping
    public Propietario crearPropietario(@RequestBody Propietario propietario) {
        return propietarioService.guardar(propietario);
    }

    @GetMapping
    public List<Propietario> obtenerTodos() {
        return propietarioService.obtenerTodos();
    }

    // Obtener un propietario por su ID
    @GetMapping("/{id}")
    public Optional<Propietario> obtenerPorId(@PathVariable Long id) {
        return propietarioService.obtenerPorId(id);
    }

    // Eliminar un propietario por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        propietarioService.eliminar(id);
    }
}
