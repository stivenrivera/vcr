package com.example.vicontred.model;

import com.google.gson.annotations.SerializedName;

public class Empresa {

    @SerializedName("id")
    private Long id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("direccion")
    private String direccion;

    @SerializedName("correo")
    private String correo;

    @SerializedName("celular")
    private String celular;

    @SerializedName("dni")
    private String dni;

    @SerializedName("director")
    private String director;

    @SerializedName("dni_director")
    private String dniDirector;

    @SerializedName("telefono_directo")
    private String telefonoDirecto;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDniDirector() {
        return dniDirector;
    }

    public void setDniDirector(String dniDirector) {
        this.dniDirector = dniDirector;
    }

    public String getTelefonoDirecto() {
        return telefonoDirecto;
    }

    public void setTelefonoDirecto(String telefonoDirecto) {
        this.telefonoDirecto = telefonoDirecto;
    }
}
