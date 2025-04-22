package com.example.vicontred.model;

public class Localizacion {

    private Long id;
    private String matriz;
    private String localizacion;

    public Localizacion(String matriz, String localizacion) {
        this.matriz = matriz;
        this.localizacion = localizacion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriz() {
        return matriz;
    }

    public void setMatriz(String matriz) {
        this.matriz = matriz;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return matriz + ": " + localizacion;
    }
}
