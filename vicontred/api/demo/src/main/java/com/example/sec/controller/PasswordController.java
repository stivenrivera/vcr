package com.example.sec.controladores;

import com.example.sec.entidades.Passwords;
import com.example.sec.servicios.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passwords")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping
    public Passwords save(@RequestBody Passwords password) {
        return passwordService.save(password);
    }

    @GetMapping
    public List<Passwords> getAll() {
        return passwordService.getAll();
    }

    @GetMapping("/{id}")
    public Passwords getById(@PathVariable Long id) {
        return passwordService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        passwordService.delete(id);
    }
}

