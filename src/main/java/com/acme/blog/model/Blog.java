package com.acme.blog.model;

import com.acme.blog.model.enums.Estado;
import com.acme.blog.model.enums.Periocidad;

public class Blog {

    private Integer idBlog;
    private Boolean comentarios;
    private String titulo;
    private String tema;
    private String contenido;
    private Periocidad periocidad;
    private Estado estado;

    public Blog() {}

    public Blog(Integer idBlog, Boolean comentarios, String titulo, String tema, String contenido, Periocidad periocidad) {
        this.idBlog = idBlog;
        this.comentarios = comentarios;
        this.titulo = titulo;
        this.tema = tema;
        this.contenido = contenido;
        this.periocidad = periocidad;
        estado = Estado.NO_ELIMINADO;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public Boolean getComentarios() {
        return comentarios;
    }

    public void setComentarios(Boolean comentarios) {
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Periocidad getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(Periocidad periocidad) {
        this.periocidad = periocidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
