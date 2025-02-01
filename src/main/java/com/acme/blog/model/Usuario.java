package com.acme.blog.model;

public class Usuario extends Persona{

    private Integer idUsuario;

    public Usuario() {}

    public Usuario(Integer idUsuario, String nombres, String paterno, String materno, String pais, String email) {
        super(nombres, paterno, materno, pais, email);
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
