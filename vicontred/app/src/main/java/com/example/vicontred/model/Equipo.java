package com.example.vicontred.model;

public class Equipo {
    private Long idUsuario;
    private String androidId;
    private String marca;
    private String modelo;
    private String versionOs;
    private String fechaRegistro;
    private String imei;
    private String numeroTelefono;

    public Equipo(Long idUsuario, String androidId, String marca, String modelo,
            String versionOs, String fechaRegistro, String imei, String numeroTelefono) {
        this.idUsuario = idUsuario;
        this.androidId = androidId;
        this.marca = marca;
        this.modelo = modelo;
        this.versionOs = versionOs;
        this.fechaRegistro = fechaRegistro;
        this.imei = imei;
        this.numeroTelefono = numeroTelefono;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersionOs() {
        return versionOs;
    }

    public void setVersionOs(String versionOs) {
        this.versionOs = versionOs;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
