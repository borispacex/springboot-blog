package com.acme.blog.model;

import java.time.LocalDate;

public class Autor extends Persona{

    private Integer idAutor;
    private String nacimiento;

    public Autor() { }

    public Autor(int idAutor, String nacimiento, String nombres, String paterno, String materno, String pais, String email) {
        super(nombres, paterno, materno, pais, email);
        this.idAutor = idAutor;
        this.nacimiento = nacimiento;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

}
