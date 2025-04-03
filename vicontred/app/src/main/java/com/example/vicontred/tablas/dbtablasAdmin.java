package com.example.vicontred.tablas;

public class dbtablasAdmin {
    private String indreg;
    private String dni;
    private String mmusuario;
    private String mmuser1;
    private String mmuser2;
    private String mmapell1;
    private String mmapell2;
    private String mmpass;
    private String mmcpass;
    private String cell;
    private String mail;
    private String admin;
    private String seguridad;
    private String estado;
    private String feccrea;
    private String userdb;

    public dbtablasAdmin(){
        super();
    }
    public dbtablasAdmin(String indreg, String dni, String mmusuario, String mmuser1, String mmuser2, String mmapell1, String mmapell2, String mmpass, String mmcpass, String cell, String mail, String admin, String seguridad, String estado, String feccrea, String userdb) {
        this.indreg = indreg;
        this.dni = dni;
        this.mmusuario = mmusuario;
        this.mmuser1 = mmuser1;
        this.mmuser2 = mmuser2;
        this.mmapell1 = mmapell1;
        this.mmapell2 = mmapell2;
        this.mmpass = mmpass;
        this.mmcpass = mmcpass;
        this.cell = cell;
        this.mail = mail;
        this.admin = admin;
        this.seguridad = seguridad;
        this.estado = estado;
        this.feccrea = feccrea;
        this.userdb = userdb;
    }

    public String getIndreg() {
        return indreg;
    }

    public void setIndreg(String indreg) {
        this.indreg = indreg;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMmusuario() {
        return mmusuario;
    }

    public void setMmusuario(String mmusuario) {
        this.mmusuario = mmusuario;
    }

    public String getMmuser1() {
        return mmuser1;
    }

    public void setMmuser1(String mmuser1) {
        this.mmuser1 = mmuser1;
    }

    public String getMmuser2() {
        return mmuser2;
    }

    public void setMmuser2(String mmuser2) {
        this.mmuser2 = mmuser2;
    }

    public String getMmapell1() {
        return mmapell1;
    }

    public void setMmapell1(String mmapell1) {
        this.mmapell1 = mmapell1;
    }

    public String getMmapell2() {
        return mmapell2;
    }

    public void setMmapell2(String mmapell2) {
        this.mmapell2 = mmapell2;
    }

    public String getMmpass() {
        return mmpass;
    }

    public void setMmpass(String mmpass) {
        this.mmpass = mmpass;
    }

    public String getMmcpass() {
        return mmcpass;
    }

    public void setMmcpass(String mmcpass) {
        this.mmcpass = mmcpass;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFeccrea() {
        return feccrea;
    }

    public void setFeccrea(String feccrea) {
        this.feccrea = feccrea;
    }

    public String getUserdb() {
        return userdb;
    }

    public void setUserdb(String userdb) {
        this.userdb = userdb;
    }
}
