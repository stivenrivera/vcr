package com.example.sec.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "auditoria", schema = "dbrgsecurity")
public class Auditoria {

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "pais")
    private String pais;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "equipo")
    private String equipo;

    @Column(name = "token")
    private String token;

    @Id
    @Column(name = "reg_sec", length = 50)
    private String regSec;

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRegSec() {
        return regSec;
    }

    public void setRegSec(String regSec) {
        this.regSec = regSec;
    }
}

