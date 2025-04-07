package com.example.sec.entidades;

import javax.persistence.*;

@Entity
@Table(name = "empresa", schema = "db_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String correo;
    private String celular;
    private String dni;

    @Column(name = "director")
    private String director;

    @Column(name = "dni_director")
    private String dniDirector;

    @Column(name = "telefono_directo")
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
