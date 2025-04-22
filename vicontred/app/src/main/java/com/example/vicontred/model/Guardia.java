package com.example.vicontred.model;

import javax.persistence.*;

@Entity
@Table(name = "Guardias", schema = "db_seguridad")
public class Guardia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGuardia;
    private String dni;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String telefono;
    private String fechaDeNacimiento;
    private String codigoGuardia;
    private String recordMilitar;
    private String regAuditoria;
    private String correo;

    public Guardia(String dni, String primerApellido, String segundoApellido,
            String primerNombre, String segundoNombre, String telefono,
            String fechaDeNacimiento, String codigoGuardia, String recordMilitar,
            String regAuditoria, String correo) {
        this.dni = dni;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.telefono = telefono;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.codigoGuardia = codigoGuardia;
        this.recordMilitar = recordMilitar;
        this.regAuditoria = regAuditoria;
        this.correo = correo;
    }

    // Getters y Setters

    public Long getIdGuardia() {
        return idGuardia;
    }

    public void setIdGuardia(Long idGuardia) {
        this.idGuardia = idGuardia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCodigoGuardia() {
        return codigoGuardia;
    }

    public void setCodigoGuardia(String codigoGuardia) {
        this.codigoGuardia = codigoGuardia;
    }

    public String getRecordMilitar() {
        return recordMilitar;
    }

    public void setRecordMilitar(String recordMilitar) {
        this.recordMilitar = recordMilitar;
    }

    public String getRegAuditoria() {
        return regAuditoria;
    }

    public void setRegAuditoria(String regAuditoria) {
        this.regAuditoria = regAuditoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
