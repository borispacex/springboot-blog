package com.acme.blog.model;

public class Persona {

    private String nombres;
    private String paterno;
    private String materno;
    private String pais;
    private String email;

    public Persona() { }

    public Persona(String nombres, String paterno, String materno, String pais, String email) {
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.pais = pais;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
