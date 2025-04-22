package com.example.sec.service;

import com.example.sec.entidades.Propietario;
import com.example.sec.repository.PropietarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    // Método para obtener todos los propietarios
    public List<Propietario> obtenerTodos() {
        return propietarioRepository.findAll();
    }

    // Método para guardar un propietario
    public Propietario guardar(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    // Método para obtener un propietario por su ID
    public Optional<Propietario> obtenerPorId(Long id) {
        return propietarioRepository.findById(id);
    }

    // Método para eliminar un propietario por su ID
    public void eliminar(Long id) {
        propietarioRepository.deleteById(id);
    }
}
