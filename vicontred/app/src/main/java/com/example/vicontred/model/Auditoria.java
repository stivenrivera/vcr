package com.example.vicontred.model;

public class Auditoria {
    private String fecha; // formato: yyyy-MM-dd
    private String hora; // formato: HH:mm:ss
    private String pais;
    private String usuario;
    private String equipo;
    private String token;
    private String regSec;

    // Constructor vacío
    public Auditoria() {
    }

    public Auditoria(String fecha, String hora, String pais, String usuario, String equipo, String token,
            String regSec) {
        this.fecha = fecha;
        this.hora = hora;
        this.pais = pais;
        this.usuario = usuario;
        this.equipo = equipo;
        this.token = token;
        this.regSec = regSec;
    }

    // Getters y Setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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
