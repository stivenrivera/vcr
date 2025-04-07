package com.example.sec.service;

import com.example.sec.entidades.Empresa;
import com.example.sec.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    public Empresa guardar(Empresa empresa) {
        return repository.save(empresa);
    }

    public List<Empresa> listar() {
        return repository.findAll();
    }
}

