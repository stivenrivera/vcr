package com.example.vicontred.model;

import javax.persistence.*;

@Entity
@Table(name = "seguridad", schema = "db_seguridad")
public class Seguridad {

    @Id
    @Column(length = 20)
    private String dni;

    private String nombreComercial;
    private String razonSocial;
    private String representanteLegal;
    private String direccion;
    private String correo;
    private String telefono;
    private String supervisor;
    private String telefonoSeguridad;
    private String regAuditoria;

    public Seguridad() {
    }

    public Seguridad(String dni, String nombreComercial, String razonSocial,
            String representanteLegal, String direccion, String correo,
            String telefono, String regAuditoria) {
        this.dni = dni;
        this.nombreComercial = nombreComercial;
        this.razonSocial = razonSocial;
        this.representanteLegal = representanteLegal;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.regAuditoria = regAuditoria;
    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
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

    public String getTelefono() {
        return telefono;
    }

    public void setRegAuditoria(String regAuditoria) {
        this.regAuditoria = regAuditoria;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTelefonoSeguridad() {
        return telefonoSeguridad;
    }

    public void setTelefonoSeguridad(String telefonoSeguridad) {
        this.telefonoSeguridad = telefonoSeguridad;
    }
}
